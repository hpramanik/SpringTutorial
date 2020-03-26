package io.hspx.recipe.controllers;

import io.hspx.recipe.domain.Recipe;
import io.hspx.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

    @Mock
    Model model;
    @Mock
    RecipeService recipeService;

    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMocMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndex() {
        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe(4L, "Test", 1, 2, 3, "Test source", "Test://url"));
        recipeSet.add(new Recipe(5L, "Test2", 1, 2, 3, "Test source 2", "Test://url2"));

        when(recipeService.getRecipes()).thenReturn(recipeSet);
        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String requiredViewName = "index";
        String viewName = indexController.getIndex(model);

        //then
        assertEquals(requiredViewName, viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> recipeSetResult = (Set<Recipe>) argumentCaptor.getValue();
        assertEquals(2, recipeSet.size());
    }
}