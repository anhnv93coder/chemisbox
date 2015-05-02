package com.chemisbox.input;

import com.chemisbox.entity.User;

public class RegisterUserInputParam extends ChemisboxInputParam {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
