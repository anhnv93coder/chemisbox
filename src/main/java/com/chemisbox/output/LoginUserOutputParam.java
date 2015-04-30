package com.chemisbox.output;

import com.chemisbox.entity.User;

public class LoginUserOutputParam extends ChemisboxOutputParam {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
