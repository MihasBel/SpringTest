package com.example.vertical;

import com.example.vertical.model.Model;
import com.example.vertical.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import com.example.vertical.config.MongoConfig;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.example.vertical.model.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class GreetingController {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    MongoDBPOperations ops = new MongoDBPOperations();

    /*public String main(Map<String, Object> model) {

        Iterable<Student> students = mongoOperation.findAll(Student.class);
        model.put("students", students);

        return "main";
    }*/
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="red")
                                       String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Model> models = mongoOperation.findAll(Model.class);
        model.put("models", models);
        System.out.println(models);
        return "main";
    }
    /*@PostMapping
    public String add(@RequestParam String studentName, @RequestParam int studentAge, Map<String, Object> model) {
        Student student = new Student(studentName, studentAge);
        ops.saveStudent(mongoOperation, student);
        mongoOperation.save(student);
        Iterable<Student> students = mongoOperation.findAll(Student.class);
        model.put("students", students);
        return "main";

    }*/
    /*@PostMapping("/saveClient")
    public void add(@RequestParam String clientName, @RequestParam String clientEmail, @RequestParam String clientNumber,
                      @RequestParam String clientText, Map<String, Object> model) {
        Client client = new Client(clientName, clientEmail, clientNumber, clientText);
        System.out.println(client);
        mongoOperation.save(client);


    }*/
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
   /* @PostMapping
    public String add(@RequestParam String modelHeader, @RequestParam String modelPath, @RequestParam String modelDescription,
                       Map<String, Object> model) {
        Model mod = new Model(modelHeader, modelPath, modelDescription);

        mongoOperation.save(mod);
        Iterable<Model> models = mongoOperation.findAll(Model.class);
        model.put("models", models);
        System.out.println(models);
        return "main";
    }*/
}