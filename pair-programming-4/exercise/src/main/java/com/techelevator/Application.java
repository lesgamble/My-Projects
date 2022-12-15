package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.util.TELog;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog logger = new TELog();
			logger.log("Search application started\n");
			
			
			// Step Four: Instantiate a Search Domain
			//System.getProperty("user.dir");
			SearchDomain dataSearch = new SearchDomain("exercise/data");
			logger.log("Files Found:\n" + dataSearch.toString());
			
			// Step Six: Single word search
			//
			SearchEngine testSearch = new SearchEngine(dataSearch);
			testSearch.indexFiles();
			List<String> squirrelSearch = testSearch.search("squirrel");
			for (String squirrel: squirrelSearch) {
				System.out.println(squirrel);
			}

			
			// Step Seven: Multiple word search
			//

			List<String> telephoneLineSearch = testSearch.search("telephone line");
			for (String phone: telephoneLineSearch) {
				System.out.println(phone);

			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
