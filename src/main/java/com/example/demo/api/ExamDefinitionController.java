package com.example.demo.api;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.entity.ExamDefenition;
import com.example.demo.database.entity.Question;
import com.example.demo.database.entity.User;
import com.example.demo.database.repository.ExamDefenitionRepository;
import com.example.demo.services.ExamDefinitionService;
import com.example.demo.services.UserService;


@RestController
@RequestMapping("/examDefinitions")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamDefinitionController {
    @Autowired
    private ExamDefinitionService examDefenitionService;
    @Autowired
    UserService userService;

    @PostMapping()
    public ExamDefenition createExamDefenition(@RequestBody ExamDefenition examDefenition,Principal principal) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String name = (String) token.getTokenAttributes().get("name");
        String userEmail = (String) token.getTokenAttributes().get("email");
        String userName = (String) token.getTokenAttributes().get("preferred_username");
        User user = userService.FindByUserName(userName);
        examDefenition.setCreatedBy(userName);
        return examDefenitionService.creatExamDefenition(examDefenition);

    }
    
    @GetMapping
    public List<ExamDefenition> getExamDefenition(Principal principal) {
         JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        String name = (String) token.getTokenAttributes().get("name");
        String userEmail = (String) token.getTokenAttributes().get("email");
        String userName = (String) token.getTokenAttributes().get("preferred_username");
         Object role =  token.getTokenAttributes().get("resource_access");
          role =((Map<String, Object>) role).get("springboot-keycloak-client");
          role =((Map<String, Object>) role).get("roles");
          ArrayList roles= (ArrayList) role;
          role =roles.get(0);
    

       return examDefenitionService.findByCreatedBy(userName);
     
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable String id) {
       return examDefenitionService.deleteExamDefinition(id);
       
    }

    @GetMapping("/{id}")
    public ExamDefenition findExamDefenition(@PathVariable String id) {
        return examDefenitionService.findExamDefinition(id);
    }


      @DeleteMapping
    public void deleteAll() {
        examDefenitionService.deleteAll();
       
    }



    
}