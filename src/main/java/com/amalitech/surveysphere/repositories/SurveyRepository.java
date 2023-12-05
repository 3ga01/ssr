package com.amalitech.surveysphere.repositories;

import com.amalitech.surveysphere.models.Survey;
import com.amalitech.surveysphere.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<Survey,String> {

}
