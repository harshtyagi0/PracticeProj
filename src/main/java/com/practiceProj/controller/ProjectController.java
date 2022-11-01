package com.practiceProj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiceProj.model.ModelClass;
import com.practiceProj.service.ProjService;

@RestController
@RequestMapping("/practice")
public class ProjectController {
	final private ProjService pServ;

	public ProjectController(ProjService pServ) {
		this.pServ = pServ;
	}

	@GetMapping
	private ResponseEntity<List<ModelClass>> getAllData() {
		return ResponseEntity.ok().body(pServ.getAll());
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<ModelClass> getById(@PathVariable("id") int id){
		return ResponseEntity.ok().body(pServ.getOneById(id));
	}

}
