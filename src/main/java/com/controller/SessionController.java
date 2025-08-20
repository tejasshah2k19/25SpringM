package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	@Autowired
	JdbcTemplate stmt;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String welcome() {
		return "Login";
	}

	@GetMapping("signup")
	public String signup() {
		return "Signup"; // jsp name
	}

	@GetMapping("login")
	public String login() {
		return "Login";
	}

	@PostMapping("register")
	public String register(UserBean userBean) {
		// read data -- done
		// validation --done
		// encrypt
		String ePwd = passwordEncoder.encode(userBean.getPassword());
		userBean.setPassword(ePwd);
		// db insertion
		// query
		stmt.update("insert into users (firstName,lastName,email,password,gender,city) values (?,?,?,?,?,?)",
				userBean.getFirstName(), userBean.getLastName(), userBean.getEmail(), userBean.getPassword(),
				userBean.getGender(), userBean.getCity());
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model) {

		try {
			UserBean userBean = stmt.queryForObject("select * from users where email = ? ",
					new BeanPropertyRowMapper<>(UserBean.class), new Object[] { email });

			System.out.println("email valid");
			// password check

			if (passwordEncoder.matches(password, userBean.getPassword())) {
				System.out.println("Email password valid");
				return "Welcome";

			}
		} catch (Exception e) {

		}
		model.addAttribute("error", "Invalid Credentials");
		return "Login";
	}

}
