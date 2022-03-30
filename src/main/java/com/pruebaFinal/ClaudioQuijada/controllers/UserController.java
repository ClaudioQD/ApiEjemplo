package com.pruebaFinal.ClaudioQuijada.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pruebaFinal.ClaudioQuijada.Validator.UserValidator;
import com.pruebaFinal.ClaudioQuijada.models.User;
import com.pruebaFinal.ClaudioQuijada.service.UserService;

@Controller
public class UserController {

	//inyeccion de validador de los atributos del usuario
	@Autowired
	private UserValidator userValidator;
//inysccion de servicios de usuario para manejar los mismos 
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@Valid @ModelAttribute("user") User user, BindingResult result) {

		if (error != null) {
			model.addAttribute("errorMessage", "Invalid credentials, please try again.");
		}
		if (logout != null) {
			model.addAttribute("LogoutMessage", "Logout Successful!");
		}

		return "login";
	}

	@GetMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registration";
	}

	// metodo que valida los datos ingresados y si los datos son errorneos redirige al registro
	//de caso opuesto guarda al usuario asociado a su role
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return "registration";
		} else {
			userService.saveWithUserRole(user);
			userService.saveWithAdminRole(user);
			return "redirect:/login";

		}

	}
	
	// metodo para redirigir las consultas de los endpoint sin usuarios registrados "bloqueo de seguridad"
	@RequestMapping(value= {"/", "/home"})
	public String home(Principal principal) {
		return "redirect:/shows";
	}
	
	

	////////////////////////
}
