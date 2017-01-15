package com.deepakrohan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class HelloTest implements Speechlet{

	private static final Logger log = LoggerFactory.getLogger(HelloTest.class);
	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		log.info("session:"+session.getSessionId()+"::Request::"+request.getRequestId());
		
	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		log.info("session:"+session.getSessionId()+"::Request::"+request.getRequestId());
		return getWelcomeMessage();
	}



	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		Intent intent = request.getIntent();
		String intentName = (intent!=null)?intent.getName():null;
		
		if("HelloWorldIntent".equals(intentName)){
			return getHelloResponse();
		}else if("AMAZON.HelpIntent".equals(intentName)){
			return getHelpResponse();
		}
		return null;
	}



	private SpeechletResponse getHelpResponse() {
	      String speechText = "You can say hello to me!";

	        // Create the Simple card content.
	        SimpleCard card = new SimpleCard();
	        card.setTitle("HelloWorld");
	        card.setContent(speechText);

	        // Create the plain text output.
	        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
	        speech.setText(speechText);

	        // Create reprompt
	        Reprompt reprompt = new Reprompt();
	        reprompt.setOutputSpeech(speech);

	        return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
		// TODO Auto-generated method stub
		
	}
	private SpeechletResponse getWelcomeMessage() {
		String speech = "Welcome to the Alexa Skills Kit, you can say hello";
		
		SimpleCard card = new SimpleCard();
		card.setTitle("Hello World");
		card.setContent("Hey this is an hello world app");
		
		PlainTextOutputSpeech speech1 = new PlainTextOutputSpeech();
		speech1.setText(speech);
		
		Reprompt rep = new Reprompt();
		rep.setOutputSpeech(speech1);
		
		
		return SpeechletResponse.newAskResponse(speech1, rep);
	}
	
	private SpeechletResponse getHelloResponse() {
		String speechText = "Hello World";
		
		SimpleCard card = new SimpleCard();
		card.setTitle(speechText);
		card.setContent(speechText);
		
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);
		
		return SpeechletResponse.newTellResponse(speech, card);
	}
}
