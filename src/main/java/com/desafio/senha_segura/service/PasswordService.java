package com.desafio.senha_segura.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.senha_segura.entity.PasswordEntity;

@Service
public class PasswordService {
	
	ArrayList<String> verify = new ArrayList<>();

	public boolean eight_caracter_min(PasswordEntity p) {
		int c = 0;
		for (int i = 0; i < p.getPassword().length(); i++) {
			c++;
		}
		if (c >= 8) {
			return true;
		}
		verify.add("A senha tem que possuir pelo menos 8 caracteres");
		return false;
	}

	public boolean letter_upp_min(PasswordEntity p) {
		int c = 0;
		for (int i = 0; i < p.getPassword().length(); i++) {
			char upp = p.getPassword().charAt(i);
			if (upp >= 'A' && upp <= 'Z') {
				c++;
			}
		}
		if (c >= 1) {
			return true;
		}
		verify.add("A senha tem que possuir pelo menos uma letra maiúscula");
		return false;
	}

	public boolean letter_low_min(PasswordEntity p) {
		int c = 0;
		for (int i = 0; i < p.getPassword().length(); i++) {
			char low = p.getPassword().charAt(i);
			if (low >= 'a' && low <= 'z') {
				c++;
			}
		}
		if (c >= 1) {
			return true;
		}
		verify.add("A senha tem que possuir pelo menos uma letra minúscula");
		return false;
	}

	public boolean num_min(PasswordEntity p) {
		int c = 0;
		for (int i = 0; i < p.getPassword().length(); i++) {
			char num = p.getPassword().charAt(i);

			if (Character.isDigit(num)) {
				c++;
			}
		}
		if (c >= 1) {
			return true;
		}
		verify.add("A senha tem que possuir pelo menos um número");
		return false;
	}

	public boolean special_character_min(PasswordEntity p) {
		int c = 0;
		for (int i = 0; i <  p.getPassword().length(); i++) {
			char spe = p.getPassword().charAt(i);
			if (!Character.isLetterOrDigit(spe)) {
				c++;
			}
		}
		if (c >= 1) {
			return true;
		}
		verify.add("A senha tem que possuir pelo menos uma caractere especial");
		return false;
	}
	
	public List<String> getArrayInfos(){
		return verify;
	}
}
