package com.example.demo.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.example.demo.config.kafkaConfig;
import com.example.demo.database.entity.ExamDefenition;
import com.example.demo.database.entity.ExamInstance;
import com.example.demo.services.ExamInstanceService;

@RestController
@RequestMapping("/examInstances")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamInstanceController {
  
    @Autowired
   private ExamInstanceService examInstanceService;

   @Autowired
   KafkaTemplate<String,String>kafkaTemplate;

  @PostMapping()
    public ExamInstance createExamInstance(@RequestBody ExamInstance examInstance) {

        return examInstanceService.createExamInstance(examInstance);
    }

    @PostMapping("/post")
    public List<ExamInstance> createExamInstances(@RequestBody ExamInstance examInstance,@RequestBody String[] students,Principal principal) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
       
        String userName = (String) token.getTokenAttributes().get("preferred_username");
        examInstance.setCreatedBy(userName);
        return examInstanceService.createExamInstances(examInstance,students);
    }

    @PutMapping
    public ExamInstance putExamInstance(@RequestBody ExamInstance examInstance) {
        System.out.println(examInstance);
        
        return examInstanceService.putExamInstance(examInstance);
    }
    
     @DeleteMapping
    public void deleteAll() {
        examInstanceService.deleteAll();
       
    }
    
    @GetMapping
    public List<ExamInstance> getExamInstances(Principal principal) {
          JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String name = (String) token.getTokenAttributes().get("name");
        String userEmail = (String) token.getTokenAttributes().get("email");
        String userName = (String) token.getTokenAttributes().get("preferred_username");
         Object role =  token.getTokenAttributes().get("resource_access");
          role =((Map<String, Object>) role).get("springboot-keycloak-client");
          role =((Map<String, Object>) role).get("roles");
          ArrayList roles= (ArrayList) role;
          role =roles.get(0);
          if(role=="admin") return examInstanceService.findByCreatedBy(userName);
      else return examInstanceService.findByTakenBy(userName);
    }


    @GetMapping("/{id}")
    public ExamInstance findExamInstance(@PathVariable String id) {
        return examInstanceService.findExamInstance(id);
    }

    
    
}