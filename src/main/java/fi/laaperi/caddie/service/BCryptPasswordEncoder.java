package fi.laaperi.caddie.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("passwordEncoder")
public class BCryptPasswordEncoder implements PasswordEncoder{

	private static final Logger logger = LoggerFactory.getLogger(BCryptPasswordEncoder.class);
	
	@Override
	public String encode(CharSequence rawPass) {
		logger.info("Encoding password.");
        return BCrypt.hashpw(rawPass.toString(), BCrypt.gensalt());
	}

	@Override
	public boolean matches(CharSequence rawPass, String encPass) {
		logger.info("Validating password.");
        return BCrypt.checkpw(rawPass.toString(), encPass);
	}

}
