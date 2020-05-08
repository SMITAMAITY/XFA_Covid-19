package com.lti.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.OutcomeFileDetailsEntity;
import com.lti.services.ISharedFeedbackOutcomeService;




@RestController
@CrossOrigin
public class SharedFeedbackOutcomeController {
	
	@Autowired
	ISharedFeedbackOutcomeService sharedFeedbackOutcomeServiceImpl;
	
	private static final Logger LOGGER = LogManager.getLogger(SharedFeedbackOutcomeController.class);

	/**
	 * 
	 * @param outcomeFileDetailsEntity
	 */
	@RequestMapping(value = "/sharedOutcomeWithUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUserFeedbackDetails(@RequestBody OutcomeFileDetailsEntity outcomeFileDetailsEntity) {
		
		sharedFeedbackOutcomeServiceImpl.prepareAndSend(outcomeFileDetailsEntity);
		LOGGER.debug("Mails sent successfully");
	}
}
