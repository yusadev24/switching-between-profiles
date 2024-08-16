package org.atmosware.internship.switching_between_profiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SwitchingBetweenProfilesApplication implements CommandLineRunner {


    private final Environment environment;

    public SwitchingBetweenProfilesApplication(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(SwitchingBetweenProfilesApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {
        for (String profile: environment.getActiveProfiles()){
        System.out.println(profile);}
    }
}
