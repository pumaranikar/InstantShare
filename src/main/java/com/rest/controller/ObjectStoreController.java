package com.rest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ObjectStoreController {
	
	
	@RequestMapping(value = "/uploadFile", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		
		try {
		      
		      String filename = uploadfile.getOriginalFilename();
		      
		      // REPLACE DIRECTORY PATH WITH SWIFT CONTAINER PATH/URL
		      String directory = "C:/";
		      String filepath = Paths.get(directory, filename).toString();
		      
		     
		      BufferedOutputStream stream =
		          new BufferedOutputStream(new FileOutputStream(new File(filepath)));
		      stream.write(uploadfile.getBytes());
		      stream.close();
		    }
		    catch (Exception e) {
		      System.out.println(e.getMessage());
		      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		    }
		    
		    return new ResponseEntity<>(HttpStatus.OK);
		  } 

}
