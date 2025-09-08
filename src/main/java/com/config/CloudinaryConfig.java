package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Bean // class -> spring -> memory -> singleton
	Cloudinary getCloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dzko8yjs6", "api_key", "812235955324293", "api_secret",
				"myUUXHnsXifcK0DyinTVjQKan_U"));
	}

}
