package com.lti.transformer;

import com.lti.entity.OutcomeFileDetailsEntity;

public interface ICreateEmailTrans {

	
	void prepareAndSend(String message, String mailSubject, OutcomeFileDetailsEntity outcomeFileDetailsEntity);
}
