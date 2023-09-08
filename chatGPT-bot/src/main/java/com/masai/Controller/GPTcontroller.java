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
    
    private String str = "Assume you are a chatbot of a food buying website named Soumit Food and your name is Soumit now act as a chatbot of this food website and don't anything that is not related to other things rather than our website and the top 5 best selling items are Tomatoo chicken with price ₹700 , Salad Fish with price ₹300 , Dressed Salmon with price ₹400 , Samosa with price ₹50 , PaniPuri with price ₹30 and the if asked to top 5 higest price products sort these five products in decending order of price. and don't answer everything at once answer just what has been asked Now answer the question";

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
    	ChatGPTrequest request=new ChatGPTrequest(model, str+" "+prompt);
        chatGPTresponse chatGptResponse = template.postForObject(apiURL, request, chatGPTresponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}


