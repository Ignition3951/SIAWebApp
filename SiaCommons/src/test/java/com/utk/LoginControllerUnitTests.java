package com.utk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.utk.controller.LoginController;
import com.utk.service.LoginProcessor;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

	@Mock
	private Model model;

	@Mock
	private LoginProcessor loginProcessor;

	@InjectMocks
	private LoginController loginController;

	@Test
	public void loginPostloginFailsTest() {
		given(loginProcessor.login()).willReturn(false);
		String result = loginController.loginPost("message", "message", model);
		assertEquals("login.html", result);
		verify(model).addAttribute("message", "Login Failed!!!!!!!!!!");

	}

}
