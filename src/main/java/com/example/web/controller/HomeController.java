package com.example.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.exception.AlreadyRegisteredEmailException;
import com.example.exception.AlreadyRegisteredUserIdException;
import com.example.service.UserService;
import com.example.web.request.UserRegisterForm;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	// 홈화면 요청
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 회원가입 화면 요청
	@GetMapping("/register")
	public String registerform(Model model) {
		// 입력폼의 입력값을 저장할 Form 객체를 미리 생성해서 Model객체에 저장시키고, 입력폼 화면으로 내부이동한다.
		UserRegisterForm form = new UserRegisterForm();
		model.addAttribute("userRegisterForm", form);
		
		return "register-form";
	}
	
	// 회원가입 요청
	@PostMapping("/register")
	// BindingResult는 유효성 검사 결과가 저장되는 객체이다. 
	public String register(@ModelAttribute("userRegisterForm") @Valid UserRegisterForm userRegisterForm, BindingResult errors) {
		if (errors.hasErrors()) {
			return "register-form";
		}
		
		try {
			userService.registerUser(userRegisterForm);
		} catch (AlreadyRegisteredUserIdException ex) { 
			errors.rejectValue("id", null, "이미 사용중인 아이디입니다.");  // id는 jsp의 path name이랑 같아야 한다. 
			return "register-form";
		} catch (AlreadyRegisteredEmailException ex) {
			errors.rejectValue("email", null, "이미 사용중인 이메일입니다.");
			return "register-form";
		}
		
		return "redirect:registered";
	}
	
	// 회원가입 완료 화면 요청
	@GetMapping("/registered")
	public String success() {
		return "success";
	}
	
	// 로그인 화면 요청
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "/error/denied";
	}
}
