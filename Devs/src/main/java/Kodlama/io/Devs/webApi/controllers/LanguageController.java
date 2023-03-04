package Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LanguageService;

import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	
	private LanguageService languageService;
	

	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void add( @RequestBody Language language) throws Exception {
		languageService.add(language);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(Language language) throws Exception {
		languageService.delete(language);
	}
	
	
	@GetMapping("/getAll")
	public List<Language> getAll(){
		return languageService.getAll();
	} 
	
	@GetMapping("/getId")
	public Language getById(int id) {
		return languageService.getById(id);
		
	}
	
	
	
	


	

}
