package com.lti.services;

import com.lti.entity.OutcomeFileDetailsEntity;

public interface ISharedFeedbackOutcomeService {

	
	void prepareAndSend(OutcomeFileDetailsEntity outcomeFileDetailsEntity);
}
