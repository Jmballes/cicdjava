package com.jmbo.covid19;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModel1 {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {

//            JsonNode root = mapper.readTree(new File("D:\\aws\\workspace\\cicd-codepipeline-java\\testingApp\\src\\test\\resources\\file.json"));
//
//            // Get id
//            long id = root.path("id").asLong();
//            System.out.println("id : " + id);
//
//            // Get Name
//            JsonNode nameNode = root.path("name");
//            if (!nameNode.isMissingNode()) {        // if "name" node is exist
//                System.out.println("firstName : " + nameNode.path("first").asText());
//                System.out.println("middleName : " + nameNode.path("middle").asText());
//                System.out.println("lastName : " + nameNode.path("last").asText());
//            }
//
//            // Get Contact
//            JsonNode contactNode = root.path("contact");
//            if (contactNode.isArray()) {
//
//                System.out.println("Is this node an Array? " + contactNode.isArray());
//
//                for (JsonNode node : contactNode) {
//                    String type = node.path("type").asText();
//                    String ref = node.path("ref").asText();
//                    System.out.println("type : " + type);
//                    System.out.println("ref : " + ref);
//
//                }
//            }
        	
          JsonNode root = mapper.readTree(new File("D:\\aws\\workspace\\cicd-codepipeline-java\\testingApp\\src\\test\\resources\\codepipelineevent.json"));

          // Get id
          long id = root.path("id").asLong();
          System.out.println("id : " + id);

          // Get Name
          JsonNode nameNode = root.path("CodePipeline.job");
          System.out.println("--"+ nameNode.asText());
          JsonNode nameNode2 = nameNode.path("id");
          
          System.out.println("--"+ nameNode2.asText());
          

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
