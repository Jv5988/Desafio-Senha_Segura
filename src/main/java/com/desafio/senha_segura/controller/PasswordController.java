package com.desafio.senha_segura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.senha_segura.entity.PasswordEntity;
import com.desafio.senha_segura.service.PasswordService;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {
	
	@Autowired
	PasswordService passwordService;
	
	@PostMapping
	public ResponseEntity<?> validate_password(@RequestBody PasswordEntity p){
		
		passwordService.getArrayInfos().clear(); //Limpar os registros antigos
		
		boolean v1 = passwordService.eight_caracter_min(p);
		boolean v2 = passwordService.letter_low_min(p);
		boolean v3 = passwordService.letter_upp_min(p);
		boolean v4 = passwordService.num_min(p);
		boolean v5 = passwordService.special_character_min(p);
		
		if(v1 && v2 && v3 && v4  && v5) {
			return ResponseEntity.ok().body("A senha atende a todos os requistos");
		} else {
			return ResponseEntity.badRequest().body(passwordService.getArrayInfos());
		}
	}
}
