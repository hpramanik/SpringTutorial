package io.hspx.sfdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.hspx.sfdi.controllers.ConstructorInjectedController;
import io.hspx.sfdi.controllers.MyController;
import io.hspx.sfdi.controllers.PropertyInjectedController;
import io.hspx.sfdi.controllers.SetterInjectedController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("--------- Primary Bean");
		String greeting = myController.getGreeting();
		System.out.println(greeting);

		System.out.println("--------- Property based");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter based");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor based");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

	}

}
