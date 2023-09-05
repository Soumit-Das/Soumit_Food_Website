package com.masai.Controller;

import com.masai.dto.ChatGPTrequest;
import com.masai.dto.chatGPTresponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//SoumitAI

@RestController
@RequestMapping("/SoumitAI")
public class GPTcontroller {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
    	ChatGPTrequest request=new ChatGPTrequest(model, prompt);
        chatGPTresponse chatGptResponse = template.postForObject(apiURL, request, chatGPTresponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}


