package org.atmosware.internship.switching_between_profiles.controller;

import org.atmosware.internship.switching_between_profiles.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    @Autowired
    private Environment environment;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private RestartEndpoint restartEndpoint;

    @GetMapping("/current-profile")
    public String getProperty() {
        for (String profile: environment.getActiveProfiles()){
            System.out.println(profile);}
        return appConfig.getTestProperty();
    }

    @PostMapping("/change-profile")
    public String changeProfile(@RequestParam String profile){
        System.setProperty("spring.profiles.active", profile);

        for (String profile2: environment.getActiveProfiles()){
            System.out.println(profile2);}

        //Restarts the application context
        restartEndpoint.restart();

        return "Profile changed to: " + profile;
    }

}
