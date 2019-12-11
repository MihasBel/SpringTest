package com.example.vertical;

import com.example.vertical.model.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import com.example.vertical.config.MongoConfig;

import com.example.vertical.model.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class GreetingController {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Model> models = mongoOperation.findAll(Model.class);
        model.put("models", models);
        System.out.println(models);
        return "main";
    }

    @RequestMapping(value="/saveClient",method = RequestMethod.POST)
    public @ResponseBody void add(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam String clientName,
                                            @RequestParam String clientEmail,
                                            @RequestParam String clientNumber,
                                            @RequestParam String clientText, Map<String, Object> model) {
        System.out.println("Get state");
        Client client = new Client(clientName, clientEmail, clientNumber, clientText);
        System.out.println(client);
        mongoOperation.save(client);
    }

}