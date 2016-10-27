package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utils.RestUtilityService;

@Controller
@RequestMapping(value="/objectStore")
public class ObjectStoreController {
	
	protected RestUtilityService restUtility = new RestUtilityService();
	
	@RequestMapping(value = "/uploadFile", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		
		try {
		      
		      String filename = uploadfile.getOriginalFilename();
		      
		      // REPLACE DIRECTORY PATH WITH SWIFT CONTAINER PATH/URL
		      String directory = "C:/";
		      String filepath = Paths.get(directory, filename).toString();
		      
	          // do we want to store file on local drive ? otherwise we can remove this part of the code.	     
		      BufferedOutputStream stream =
		          new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		      stream.write(uploadfile.getBytes());
		      stream.close();
		      
		      // This can be async call if we have local copy.
		      boolean success = restUtility.addObjectToContainer(new File(filepath));
		    }
		    catch (Exception e) {
		      System.out.println(e.getMessage());
		      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
		    
		    return new ResponseEntity<>(HttpStatus.OK);
		  } 
	
	
	// test method to access object store
	
	@RequestMapping(value="/testget", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> testMethod() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
