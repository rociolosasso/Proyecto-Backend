
package com.portfolio.rbl;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author rocio <rocio.name at your.org>
 */ 
@EnableWebMvc

@Configuration
public class WebConfig {

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**");

    }

   
}
