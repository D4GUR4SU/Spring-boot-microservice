package com.dagurasu.padroesapi.service;

import org.springframework.stereotype.Service;

import com.dagurasu.padroesapi.entity.UserEntity;
import com.dagurasu.padroesapi.exception.InvalidNameException;

@Service
public class UserService {

	public void createUser(UserEntity user) {
		if (user.getName().length() > 10) {
			throw new InvalidNameException();
		}
	}

}
