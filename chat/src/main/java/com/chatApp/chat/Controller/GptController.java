package com.chatApp.chat.Controller;

import com.chatApp.chat.GptPayload.GptRequest;
import com.chatApp.chat.GptPayload.GptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GptController {
    @Value("${openapi.model}")
    String model;

    @Value("${openapi.url}")
    String url;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/chatgpt")
    public String getResponse(@RequestParam("prompt") String prompt){
        GptRequest request = new GptRequest(model,prompt);
       GptResponse response= restTemplate.postForObject(url,request, GptResponse.class);
       return response.getChoices().get(0).getMessage().getContent();
    }
}
