package com.jmbo.calculator;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.util.IOUtils;
import com.jmbo.calculator.model.ServerlessInput;
import com.jmbo.calculator.model.ServerlessOutput;

/**
 * Lambda function that triggered by the API Gateway event "GET /". It reads query parameter "id" for the article id and retrieves
 * the content of that article from the underlying S3 bucket and returns the content as the payload of the HTTP Response.
 */
public class Calculator implements RequestHandler<ServerlessInput, ServerlessOutput> {
	private static final String NUM1="NUM1";
	private static final String NUM2="NUM2";
	private static final String OP="OP";
    @Override
    public ServerlessOutput handleRequest(ServerlessInput serverlessInput, Context context) {
        // Using builder to create the clients could allow us to dynamically load the region from the AWS_REGION environment
        // variable. Therefore we can deploy the Lambda functions to different regions without code change.    
    	 LambdaLogger logger = context.getLogger();
 		logger.log("INIT");
        ServerlessOutput output = new ServerlessOutput();
 		logger.log("INIT");
        int num1=Integer.parseInt(serverlessInput.getQueryStringParameters().get(NUM1));
        int num2=Integer.parseInt(serverlessInput.getQueryStringParameters().get(NUM2));
        String op=serverlessInput.getQueryStringParameters().get(OP);
        int result=0;
        try {
            if (serverlessInput.getQueryStringParameters() == null || serverlessInput.getQueryStringParameters().get(NUM1) == null || serverlessInput.getQueryStringParameters().get(NUM2) == null || serverlessInput.getQueryStringParameters().get(OP) == null) {
                    throw new Exception("Parameters num1, num2 and op in query must be provided!");
            }
            
            switch(op)
            {
                case "add":
                	result = num1 + num2;
                    break;

                case "sub":
                	result = num1 - num2;
                    break;

                case "mul":
                	result = num1 * num2;
                    break;

                case "div":
                	result = num1 / num2;
                    break;


            }


            output.setStatusCode(200);
            //Faltan comillas
            String stringresult="{\"result\":\""+result + "\"}";
            output.setBody(stringresult);
        } catch (Exception e) {
            output.setStatusCode(500);
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            output.setBody(sw.toString());
        }

        return output;
    }
}