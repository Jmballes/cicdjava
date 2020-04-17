package com.jmbo.covid19;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestCodvid19 implements RequestHandler<Map<String,String>, String>{


	Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(Map<String,String> event, Context context)
    {
      LambdaLogger logger = context.getLogger();
      String response = new String("200 OK");
      // log execution details
      logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
      logger.log("CONTEXT: " + gson.toJson(context));
      // process event
      logger.log("EVENT: " + gson.toJson(event));
      logger.log("EVENT TYPE: " + event.getClass().toString());
      return response;
    }

//    public String handleRequest(AcknowledgeJobRequest  input, Context context) {
//
//        Logger logger = context.getLogger();
//        String response = new String("200 OK");
//        // log execution details
//        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
//        logger.log("CONTEXT: " + gson.toJson(context));
//        // process event
//        logger.log("EVENT: " + gson.toJson(event));
//        logger.log("EVENT TYPE: " + event.getClass().toString());
//    	AWSCodePipelineClient awsclient= awsclient.acknowledgeJob(request);
//   
//
//        return "ok";
//    }

}