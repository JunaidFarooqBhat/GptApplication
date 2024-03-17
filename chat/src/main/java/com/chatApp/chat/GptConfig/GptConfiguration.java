package com.chatApp.chat.GptConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GptConfiguration {
    @Value("${openapi.key}")
    String apikey;
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate template= new RestTemplate();
        template.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add("Authorization","Bearer "+apikey);
            return execution.execute(request,body);
        }));
        return template;
    }
}
