package com.pp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.repositary.WebServiceModel;
import com.pp.repositary.WebServiceRepository;

@Service
public class WebSrvService {
	@Autowired
	private WebServiceRepository webServiceRepository;

	public WebServiceModel saveRecord(WebServiceModel webServiceModel) {
		return webServiceRepository.save(webServiceModel);
	}

	public List<WebServiceModel> getAllRecords() {
		List<WebServiceModel> list = webServiceRepository.findAll();
		return list;
	}

	public Optional<WebServiceModel> getRecordById(int id) {
		return webServiceRepository.findById(id);
	}

	public void deleteRecord(int id) {
		webServiceRepository.deleteById(id);
	}
}
