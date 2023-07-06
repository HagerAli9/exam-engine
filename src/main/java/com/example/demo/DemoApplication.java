package com.example.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.database.entity.Answer;
import com.example.demo.database.entity.AnswerdQuestion;
import com.example.demo.database.entity.ExamDefenition;
import com.example.demo.database.entity.ExamInstance;
import com.example.demo.database.entity.Question;
import com.example.demo.database.entity.User;
import com.example.demo.database.entity.Instructor;
import com.example.demo.database.repository.ExamDefenitionRepository;
import com.example.demo.database.repository.ExamInstanceRepository;
import com.example.demo.database.repository.InstructorRepository;
import com.example.demo.database.repository.QuestionRepository;
import com.example.demo.database.repository.UserRepository;
import com.example.demo.services.QuestionService;

@SpringBootApplication
@EnableMongoRepositories("com.example.demo.database.repository")

public class DemoApplication {
	@Autowired
	QuestionService questionService;
    @Autowired
	InstructorRepository instructorRepository;
	@Autowired
	ExamDefenitionRepository examDefenitionRepository;
	@Autowired
	ExamInstanceRepository examInstanceRepository;
     @Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    // @Bean
	// CommandLineRunner commandLineRunner (QuestionRepository questionRepository){

	// 	return args -> {

	// 		User user =new User();
	// 		user.setEmail("hagar.ali@atos.net");
	// 		user.setName("Ahmed Ali");
	// 		user.setUsername("user2");
	// 		userRepository.save(user);
			
			



	// 	};
	// }
			
	// 		 Question aQuestion=questionRepository.findById("6484cff3732da85f242dc072").get();
	// 		  instructor instructor=instructorRepository.findById("647bdf250fc2681d7617ef66").get();
	// 		ExamDefenition examDefenition=new ExamDefenition();
	// 		examDefenition.setCreatedBy(instructor);
	// 		examDefenition.setName("java");
	// 		examDefenition.setPassingScore(70);
	// 		//String[] questions={"64636aad2745af57dec90c8c"};
	// 		Question[] questions={aQuestion};
	// 		examDefenition.setQuestions(questions);
	// 		System.out.println(examDefenitionRepository.save(examDefenition));

	// 		//  ExamInstance examInstance = new ExamInstance();
	// 		// AnswerdQuestion answerdQuestion=new AnswerdQuestion();
	// 		// answerdQuestion.setAnswerTime(30);
	// 		// answerdQuestion.setDisplayTime(30);
	// 		// answerdQuestion.setQuestionId("64636aad2745af57dec90c8c");
	// 		// answerdQuestion.setSelectedAnswerId(0);
	// 		// System.out.println(answerdQuestionRepository.save(answerdQuestion));
	// 		// AnswerdQuestion[] answerdQuestions= {answerdQuestionRepository.findById("647bed96f0fb8b13fcbe5158").get()};

	// 		// examInstance.setAnswerdQuestions(answerdQuestions);
	// 		// examInstance.setStartedTime(LocalDateTime.now());
	// 		// examInstance.setEndTime(LocalTime.now().plusSeconds(answerdQuestions[0].getDisplayTime()));
	// 		// examInstance.setCreatedBy("hgt");
	// 		// examInstance.setCompletionTime(LocalTime.now());
	// 		// //examInstance.setDuration(examInstance.getEndTime().);
	// 		// System.out.println(examInstanceRepository.save(examInstance));

	// 		// Answer answer1=new Answer(0,"answer1",false);
	// 		// Answer answer2 = new Answer(1, "answer2", false);
	// 		// Answer answer3 = new Answer(2, "answer3", false);
	// 		// Answer answer4 = new Answer(2, "answer4", true);
	// 		// Question question = new Question();
	// 		// question.setName("question");
	// 		// List<Answer> list =new ArrayList<>();
	// 		// list.add(answer1);
	// 		// list.add(answer2);
	// 		// list.add(answer3);
	// 		// list.add(answer4);
	// 		// question.setAnswers(list);
	// 		// question.setCreated_at(LocalDateTime.now());
	// 		// question.setCreated_by(instructor);
	// 		// question.setDisplayDuration(Duration.ofSeconds(30));
	// 		// System.out.println(questionRepository.save(question)); 
			


			
	// 		//question.setAnswers(new List<Answer>());








	// 	};
	// }

}
