package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dao.UserDao;
import com.service.MailerService;
import com.service.OtpGeneratorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@Autowired
	JdbcTemplate stmt;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	MailerService mailerService;

	@Autowired
	UserDao userDao;

	@Autowired
	OtpGeneratorService otpService;

	@Autowired
	Cloudinary cloudinary;

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
	public String register(UserBean userBean, MultipartFile profilePic) {
		// read data -- done
		// validation --done
		// encrypt

		System.out.println(profilePic.getOriginalFilename());
		System.out.println(profilePic.getContentType());
		System.out.println(profilePic.getSize());

		try {
			// upload profilePic to cloudinary server ->
			Map uploadResult  = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
			
			String path = uploadResult.get("secure_url").toString();
			System.out.println(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String ePwd = passwordEncoder.encode(userBean.getPassword());
		userBean.setPassword(ePwd);
		// db insertion
		// query
//		stmt.update("insert into users (firstName,lastName,email,password,gender,city) values (?,?,?,?,?,?)",
//				userBean.getFirstName(), userBean.getLastName(), userBean.getEmail(), userBean.getPassword(),
//				userBean.getGender(), userBean.getCity());

		// send welcome mail
//		mailerService.sendWelcomeMail(userBean.getFirstName(), userBean.getEmail());

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

	@GetMapping("forgetpassword")
	public String forgetpassword() {
		return "ForgetPassword";
	}

	@PostMapping("sendotp")
	public String sendOtp(String email, Model model, HttpSession session) {

		// email check db
		UserBean userBean = userDao.findByEmail(email);

		if (userBean == null) {
			model.addAttribute("error", "Invalid Email");
			return "ForgetPassword";
		} else {
			// otp generate
			String otp = otpService.generateOtp(6);

			// session
			session.setAttribute("otp", otp);
			session.setAttribute("email", email);

			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					// send mail
					mailerService.sendOtpForForgetPassword(otp, email);
				}
			});
			t.start();

			return "ChangePassword"; // new password , otp -> submit ->

		}
	}

	@PostMapping("changepassword")
	public String changePassword(String otp, String password, HttpSession session) {
		// email
		String email = (String) session.getAttribute("email");

		// input otp
		// input password

		// origin otp
		String originalOtp = (String) session.getAttribute("otp");

		if (originalOtp.equals(otp)) {
			// change password in db using update query
			return "Login";
		} else {
			return "ForgetPassword";
		}
	}

}
