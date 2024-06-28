package com.vini.surveyhack.controller;


import com.vini.surveyhack.modal.SurveyResponse;
import com.vini.surveyhack.service.SurveyResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responses")
public class SurveyResponseController {

    @Autowired
    private SurveyResponseService surveyResponseService;

    @GetMapping
    public List<SurveyResponse> getAllResponses() {
        return surveyResponseService.getAllResponses();
    }

    @GetMapping("/survey/{surveyId}")
    public List<SurveyResponse> getResponsesBySurveyId(@PathVariable Long surveyId) {
        return surveyResponseService.getResponsesBySurveyId(surveyId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponse> getResponseById(@PathVariable Long id) {
        SurveyResponse response = surveyResponseService.getResponseById(id);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public SurveyResponse createResponse(@RequestBody SurveyResponse response) {
        return surveyResponseService.createResponse(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyResponse> updateResponse(@PathVariable Long id, @RequestBody SurveyResponse responseDetails) {
        SurveyResponse updatedResponse = surveyResponseService.updateResponse(id, responseDetails);

        if (updatedResponse != null) {
            return ResponseEntity.ok(updatedResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Long id) {
        if (surveyResponseService.deleteResponse(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

