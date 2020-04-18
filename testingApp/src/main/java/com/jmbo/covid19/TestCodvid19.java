package com.jmbo.covid19;
import com.amazonaws.services.codepipeline.AWSCodePipeline;
import com.amazonaws.services.codepipeline.AWSCodePipelineClient;
import com.amazonaws.services.codepipeline.AWSCodePipelineClientBuilder;
import com.amazonaws.services.codepipeline.model.AcknowledgeJobRequest;
import com.amazonaws.services.codepipeline.model.AcknowledgeJobResult;
import com.amazonaws.services.codepipeline.model.PutJobSuccessResultRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.lang.IllegalStateException;

public class TestCodvid19 implements RequestStreamHandler {


	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static final ObjectMapper mapper = new ObjectMapper();

	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
	  {

	    LambdaLogger logger = context.getLogger();
		logger.log("INIT");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("US-ASCII")));
	    PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("US-ASCII"))));
	    try
	    {
	    	JsonNode root = mapper.readTree(inputStream);
	    	logger.log("XXXXXXXXXXXX");
		    
	          // Get id
	          long id = root.path("id").asLong();
	          System.out.println("id : " + id);
		    	logger.log("2222222222222");
	          // Get Name
	          JsonNode nameNode = root.path("CodePipeline.job");
	          System.out.println("--"+ nameNode.asText());
	          JsonNode nameNode2 = nameNode.path("id");
		    	logger.log("33333333333333");
	          System.out.println("--"+ nameNode2.asText());	

		      AcknowledgeJobRequest n= new AcknowledgeJobRequest();
		    	logger.log("4444444444");
		      n.setJobId(nameNode2.asText());
		    	logger.log("555555555");
		      AWSCodePipeline awsclient= AWSCodePipelineClientBuilder.defaultClient();
		    	logger.log("66666666666");
		      PutJobSuccessResultRequest pj= new PutJobSuccessResultRequest();
		    	logger.log("777777777");
		      pj.setJobId(nameNode2.asText());
		      awsclient.putJobSuccessResult(pj);
		    	logger.log("88888888888");
//	      HashMap event = gson.fromJson(reader, HashMap.class);
//	      logger.log("STREAM TYPE: " + inputStream.getClass().toString());
//	      logger.log("EVENT TYPE: " + event.getClass().toString());
//	      writer.write(gson.toJson(event));
//	      String variable=gson.toJson(event);
//	      
//	      logger.log("variable: " +variable);
//	      ObjectMapper mapper = new ObjectMapper();
//	      JsonNode actualObj = mapper.readTree(variable);
//	      JsonNode jsonNode1 = actualObj.get("id");
//	      logger.log("nodo::");
//	      logger.log("nodo:::::::::::"+jsonNode1.textValue());
//	      if (writer.checkError())
//	      {
//	        logger.log("WARNING: Writer encountered an error.");
//	      }
//	      logger.log("Mostrar hasmap::");
//	      if(!event.isEmpty()) {
//	          Iterator it = event.entrySet().iterator();
//	          while(it.hasNext()) {
//	             Map.Entry obj = (Entry)it.next();
//	             logger.log(""+obj.getValue());
//	          }
//	       }

	    }
	    catch (IllegalStateException | JsonSyntaxException exception)
	    {
	      logger.log(exception.toString());
	    }
	    finally
	    {
	      reader.close();
	      writer.close();
	    }
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