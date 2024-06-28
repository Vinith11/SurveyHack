package com.vini.surveyhack.service;


import com.vini.surveyhack.modal.SurveyResponse;
import com.vini.surveyhack.repository.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyResponseService {

    @Autowired
    private SurveyResponseRepository surveyResponseRepository;

    public List<SurveyResponse> getAllResponses() {
        return surveyResponseRepository.findAll();
    }

    public List<SurveyResponse> getResponsesBySurveyId(Long surveyId) {
        return surveyResponseRepository.findBySurveyId(surveyId);
    }

    public SurveyResponse getResponseById(Long id) {
        return surveyResponseRepository.findById(id).orElse(null);
    }

    public SurveyResponse createResponse(SurveyResponse response) {
        return surveyResponseRepository.save(response);
    }

    public SurveyResponse updateResponse(Long id, SurveyResponse responseDetails) {
        SurveyResponse response = surveyResponseRepository.findById(id).orElse(null);

        if (response != null) {
            response.setSurveyId(responseDetails.getSurveyId());
            response.setResponses(responseDetails.getResponses());
            return surveyResponseRepository.save(response);
        } else {
            return null;
        }
    }

    public boolean deleteResponse(Long id) {
        SurveyResponse response = surveyResponseRepository.findById(id).orElse(null);

        if (response != null) {
            surveyResponseRepository.delete(response);
            return true;
        } else {
            return false;
        }
    }
}
