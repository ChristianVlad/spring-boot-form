package com.bolsaideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsaideas.springboot.form.app.domain.Usuario;



@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario de usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Validated Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {

			return "form";
		}
				
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}