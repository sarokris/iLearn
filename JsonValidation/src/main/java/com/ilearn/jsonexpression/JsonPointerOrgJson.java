package com.ilearn.jsonexpression;

import org.json.JSONObject;

public class JsonPointerOrgJson {
	public static void main(String[] args) {
		getValueUsingJsonPointerExpression();
	}

	private static void getValueUsingJsonPointerExpression() {
//		{
//			  "firstName": "John",
//			  "lastName" : "doe",
//			  "age"      : 26,
//			  "address"  : {
//			    "streetAddress": "naist street",
//			    "city"         : "Nara",
//			    "postalCode"   : "630-0192"
//			  },
//			  "phoneNumbers": [
//			    {
//			      "type"  : "iPhone",
//			      "number": "0123-4567-8888"
//			    },
//			    {
//			      "type"  : "home",
//			      "number": "0123-4567-8910"
//			    }
//			  ]
//			}
		
		String sampleJsonString = "{\"firstName\": \"John\",\"lastName\" : \"doe\",\"age\" : 26,\"address\": {\"streetAddress\": \"naist street\",\"city\": \"Nara\",\"postalCode\": \"630-0192\"},\"phoneNumbers\": [{\"type\": \"iPhone\",\"number\": \"0123-4567-8888\"},{\"type\"  : \"home\",\"number\": \"0123-4567-8910\"}]}";
		JSONObject jsonObj = new JSONObject(sampleJsonString);
		String firstName = jsonObj.query("/phoneNumbers/1/type").toString();
		System.out.println(firstName);
		
	}

}
