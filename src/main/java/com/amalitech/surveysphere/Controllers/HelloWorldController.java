package com.amalitech.surveysphere.Controllers;

import com.amalitech.surveysphere.models.Survey;
import com.amalitech.surveysphere.models.User;
import com.amalitech.surveysphere.repositories.SurveyRepository;
import com.amalitech.surveysphere.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private UserRepository userRepository;
    private  SurveyRepository surveyRepository;

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

                surveyRepository.save(survey);

            return new  ResponseEntity<Survey>(survey,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
