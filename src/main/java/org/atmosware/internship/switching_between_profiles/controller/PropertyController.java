package org.atmosware.internship.switching_between_profiles.controller;

import org.atmosware.internship.switching_between_profiles.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
    RefreshEndpoint refreshEndpoint;

    @Autowired
    private RestTemplate restTemplate;
    //Environment

    @GetMapping("/current-profile")
    public String getProperty() {
        for (String profile: environment.getActiveProfiles()){
            System.out.println(profile);}
        return appConfig.getTestProperty();
    }

    @PostMapping("/change-profile")
    public String changeProfile(@RequestParam String profile){
        System.setProperty("spring.profiles.active", profile);

        refreshEndpoint.refresh();

        for (String profile2: environment.getActiveProfiles()){
            System.out.println(profile2);}
        return "Profile changed to: " + profile;
    }

}
