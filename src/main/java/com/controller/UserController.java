package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class UserController {

	@Autowired
	JdbcTemplate stmt;

	@GetMapping("listusers")
	public String getAllUsers(Model model) {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper(UserBean.class));
		model.addAttribute("users", users);
		return "ListUsers";// jsp
	}

	@GetMapping("inputuserid")
	public String inputUserId() {
		return "InputDeleteId";
	}

	@GetMapping("deleteuser")
	@PostMapping("deleteuser")
	public String deleteUser(int userId) {
		System.out.println(userId);
		stmt.update("delete from users where userId = ? ", userId);
		return "redirect:/listusers";
	}

	@GetMapping("search")
	public String search() {
		return "SearchUser";
	}

	@PostMapping("search")
	public String userSearch(String firstName, Model model) {
		List<UserBean> users = stmt.query("select * from users where firstName like  ? ",
				new BeanPropertyRowMapper(UserBean.class), new Object[] { "%"+firstName+"%" });
		model.addAttribute("users", users);
		return "ListUsers";
	}

}
