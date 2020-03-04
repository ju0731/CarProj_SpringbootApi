package com.crbs.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoding implements PasswordEncoder{
	private PasswordEncoder passwordEncoder;

	//실제로 암호화를 해주는 메서드
	//암호화를 할때마다 새로운 값을 생성해서 보안 수준을 높여준다.
	public PasswordEncoding() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public PasswordEncoding(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	//평문문자와 암호화된 비밀번호를 서로 비교해준다.
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
