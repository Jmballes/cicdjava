package com.jmbo.covid19;

public class CodepipelineEvent {
    private final String name;
    private final String model;
    private final int price;
    private final String[] colours;

    public CodepipelineEvent(String name, String model, int price, String[] colours) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.colours = colours;
    }
//    }
//		  "CodePipeline.job": {
//		    "data": {
//		      "artifactCredentials": {
//		        "secretAccessKey": "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY",
//		        "sessionToken": "token",
//		        "accessKeyId": "AKIAIOSFODNN7EXAMPLE"
//		      },
//		      "actionConfiguration": {
//		        "configuration": {
//		          "FunctionName": "my-function",
//		          "UserParameters": "user-parameter-string"
//		        }
//		      },
//		      "inputArtifacts": [
//		        {
//		          "revision": "ca2bdeadbeef7d1932acb4977e08c803295d9896",
//		          "name": "input-artifact",
//		          "location": {
//		            "type": "S3",
//		            "s3Location": {
//		              "objectKey": "test/key",
//		              "bucketName": "example-bucket"
//		            }
//		          }
//		        }
//		      ],
//		      "outputArtifacts": [
//		        {
//		          "revision": null,
//		          "name": "output-artifact",
//		          "location": {
//		            "type": "S3",
//		            "s3Location": {
//		              "objectKey": "test/key2",
//		              "bucketName": "example-bucket2"
//		            }
//		          }
//		        }
//		      ]
//		    },
//		    "id": "c968ef10-6415-4127-80b1-42502218a8c7",
//		    "accountId": "123456789012"
//		  }
//		}
}
