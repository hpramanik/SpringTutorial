package io.hspx.sfdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({ "EN", "default" }) // Adding it as default. Now if the active profile is not set in
                              // application.properties it will wire up the I18EnglishGreetingService
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - English";
    }

}