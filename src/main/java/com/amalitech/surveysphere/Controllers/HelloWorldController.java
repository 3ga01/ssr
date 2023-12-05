package com.amalitech.surveysphere.Controllers;

import com.amalitech.surveysphere.models.Survey;
import com.amalitech.surveysphere.models.User;
import com.amalitech.surveysphere.repositories.SurveyRepository;
import com.amalitech.surveysphere.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private UserRepository userRepository;
    private  SurveyRepository surveyRepository;
    private MongoTemplate mongoTemplate;

    @RequestMapping("/")

    public String getPlanet(){
        return "Hello, Welcome to Earth";
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){

        try {

            userRepository.save(user);
            return new  ResponseEntity<User>(user,HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity<>("User cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addSurvey")
    public ResponseEntity<?> addSurvey(@RequestBody Survey survey){
        try {


            mongoTemplate.save(survey);
            String userId = survey.getUserId();

            User user = mongoTemplate.findById(userId, User.class);

            if (user.getSurveyId() == null) {
                user.setSurveyId(new ArrayList<>());
            }
            user.getSurveyId().add(survey);
            mongoTemplate.save(user);
//                surveyRepository.save(survey);
//                User user = userRepository.findById(userId);

            return new  ResponseEntity<Survey>(survey,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
