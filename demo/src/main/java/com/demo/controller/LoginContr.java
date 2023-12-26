package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.controller.global.GlobalData;
import com.demo.controller.model.Role;
import com.demo.controller.model.User;
import com.demo.controller.repository.RoleRepositry;
import com.demo.controller.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginContr {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepositry roleRepositry;
	
	@GetMapping("/login")
		public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	@GetMapping("/registor")
	public String signup() {
	return "registor";
}
	@PostMapping("/registor")
	public String registorPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException{
		String password=user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role>roles=new ArrayList<>();
		roles.add(roleRepositry.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
		
	}
	
}
