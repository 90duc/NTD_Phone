package com.mk.url;

public class URL {
	private URL() {

	}

	public static interface Person {
		String base = "";
		String info = base + "/info";
		String login = base + "/login";
		String register = base + "/register";
		String logout = base + "/logout";
		String checkLogin= base + "/checkLogin";
		String userInfo =base +  "/userInfo";
		String modifyPassword =base +  "/password";
		String modifyEmail =base +  "/email";

	}

	public static interface Phone {
		String base = "";
		String search = base + "/search";
		String hobby = base + "/hobby";
		String typeList = base + "/new";
		String searchBy = base + "/searchBy";
		String detail = base + "/detail";
		String company = base + "/company";
		String images = base + "/images";
	}

}
