package com.pp.controller;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.repositary.WebServiceModel;
import com.pp.service.WebSrvService;

@RestController
@RequestMapping("model")
@Slf4j
public class WebServiceController {


	private WebSrvService webSrvService;

	@Autowired
	private WebServiceController(WebSrvService webSrvService)
	{
		this.webSrvService = webSrvService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<WebServiceModel>> getAllRecords() 
	{

		return ResponseEntity.ok(webSrvService.getAllRecords());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<WebServiceModel> getRecordById(@PathVariable("id") int id) 
		{log.info("Get By Id WebServiceModel called...");
		Optional<WebServiceModel> optional = webSrvService.getRecordById(id);
		
		return ResponseEntity.ok(optional.get());
	}

	 @PostMapping("/save")
	public ResponseEntity<WebServiceModel> saveRecord(@RequestBody WebServiceModel webServiceModel) 
	 {
		 return ResponseEntity.ok(webSrvService.saveRecord(webServiceModel));
	 }
	 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<WebServiceModel> updateRecord(@PathVariable int id,
			 @RequestBody WebServiceModel webServiceModel)
	 {
		 return ResponseEntity.ok(webSrvService.saveRecord(webServiceModel));
	 }


	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity deleteRecordById(@PathVariable int id)
	 {
		 webSrvService.deleteRecord(id);
		 return ResponseEntity.ok().build();
	 }

}
