package com.csscocean.wisdom.auth.authorizaionserver.controller;

import com.csscocean.wisdom.auth.authorizaionserver.entity.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jefferyhan
 */
@Controller
public class UserController {
	@CrossOrigin
	@RequestMapping("/api/userinfo")
	public ResponseEntity<UserInfo> getUserInfo(){
		User user = (User)SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String email = user.getUsername() + "@163.com";

		UserInfo userInfo = new UserInfo();
		userInfo.setName(user.getUsername());
		userInfo.setEmail(email);

		return ResponseEntity.ok(userInfo);
	}
}
