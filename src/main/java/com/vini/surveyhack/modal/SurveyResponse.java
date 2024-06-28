package com.vini.surveyhack.modal;


import jakarta.persistence.*;

import java.util.Map;

@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long surveyId;

    @ElementCollection
    private Map<String, String> responses;

    // Constructors, getters, and setters
    public SurveyResponse() {}

    public SurveyResponse(Long surveyId, Map<String, String> responses) {
        this.surveyId = surveyId;
        this.responses = responses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Map<String, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<String, String> responses) {
        this.responses = responses;
    }
}

