package com.bolsaideas.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("/form")
	//El objeto model es para pasarlo a la vista.
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario de usuario");
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(Model model,
			/*Con este @RequestParam recibe los datos
			 Porque los extrae los campos que hicimos 
			 en el file: form.html*/
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String email) {
		
		
		//El primero es el objeto/atributo, el segundo es el valor.
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		
		return "resultado";
	}
}