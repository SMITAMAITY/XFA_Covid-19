package com.lti.transformer.impl;
import java.io.File;

import javax.mail.internet.InternetAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.FileSystemResource;

//import javax.activation.DataSource;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import com.lti.commons.XFAConstants;
import com.lti.entity.OutcomeFileDetailsEntity;
import com.lti.transformer.ICreateEmailTrans;



/**
 * 
 * @author 10653960
 *
 */
@Component
public class CreateEmailTransImpl implements ICreateEmailTrans {
	
	private static final Logger LOGGER = LogManager.getLogger(CreateEmailTransImpl.class);
	private JavaMailSender mailSender;
	
	/**
	 * 
	 * @param mailSender
	 */
    public CreateEmailTransImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
 

	@Override
	public void prepareAndSend(String message, String mailSubject, OutcomeFileDetailsEntity outcomeFileDetailsEntity) {
MimeMessagePreparator messagePreparator = mimeMessage -> {
    		
    		LOGGER.debug("Mails Prepartion start");
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            
            messageHelper.setFrom(XFAConstants.SENDER_MAIL_ADDRESS);
            messageHelper.setSubject(mailSubject);
            messageHelper.setText(message);
            
            if(null != outcomeFileDetailsEntity) {
            	
            	messageHelper.setTo(InternetAddress.parse(outcomeFileDetailsEntity.getEmail()));
            	
//            	messageHelper.addAttachment(outcomeFileDetailsEntity.getAttachmentFilename(), outcomeFileDetailsEntity.getInputStreamSource());
            	
                FileSystemResource file = new FileSystemResource(new File("C:\\Users\\smita\\Downloads\\RPSAssessment.pdf"));
            	messageHelper.addAttachment(file.getFilename(), file);
//                
            	//TODO This we have to use
                //messageHelper.addAttachment(outcomeFileDetailsEntity.getAttachmentFilename(), outcomeFileDetailsEntity.getInputStreamSource(), "png");
            }
            LOGGER.debug("Mails Prepartion complete");
        };
        try {
            
        	mailSender.send(messagePreparator);
        	LOGGER.debug("Mails sent successfully.");
        } catch (MailException mailException) {
            
        	LOGGER.debug("There is an error in mails sending: " + mailException.getMessage());
        	System.out.println("Mails is not sent." + mailException.getMessage());
        }
		
	}

}
