package com.deepakrohan;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class HelloWorldSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler{
	     private static final Set<String> supportedApplicationIds = new HashSet<String>();
	     static {
	         /*
	          * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
	          * Alexa Skill and put the relevant Application Ids in this Set.
	          */
	         supportedApplicationIds.add("amzn1.ask.skill.b80d8f56-9e03-4568-bc2d-911852d90d1b");
	     }

	     public HelloWorldSpeechletRequestStreamHandler() {
	         super(new HelloTest(), supportedApplicationIds);
	     }
}
