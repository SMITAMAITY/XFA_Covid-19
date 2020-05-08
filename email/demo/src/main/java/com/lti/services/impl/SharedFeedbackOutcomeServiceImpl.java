package com.lti.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.OutcomeFileDetailsEntity;
import com.lti.services.ISharedFeedbackOutcomeService;
import com.lti.transformer.ICreateEmailTrans;

@Service
public class SharedFeedbackOutcomeServiceImpl implements ISharedFeedbackOutcomeService {

private static final Logger LOGGER = LogManager.getLogger(SharedFeedbackOutcomeServiceImpl.class);
	
	@Autowired
	ICreateEmailTrans createEmailTransImpl;
	
	@Override
	public void prepareAndSend(OutcomeFileDetailsEntity outcomeFileDetailsEntity) {
	LOGGER.debug("prepareAndSend Start: ");
		
		String message = "Welcome Message"; // TODO
		String mailSubject = "Welcome Message"; // TODO
		
		createEmailTransImpl.prepareAndSend(message, mailSubject, outcomeFileDetailsEntity);
		LOGGER.debug("prepareAndSend End: ");
	}
	
	
}