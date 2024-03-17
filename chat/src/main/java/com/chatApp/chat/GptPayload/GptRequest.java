package com.chatApp.chat.GptPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GptRequest {
    private String model;
    private List<Message> messages;
   public GptRequest(String model,String prompt){
        this.model=model;
        this.messages=new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }
}
