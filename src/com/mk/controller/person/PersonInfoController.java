package com.mk.controller.person;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mk.entity.UserInfo;
import com.mk.info.MsgInfo.UserName;
import com.mk.info.NameInfo;
import com.mk.info.MsgInfo.Email;
import com.mk.info.MsgInfo.Login;
import com.mk.info.UserDetail;
import com.mk.info.status.Status;
import com.mk.service.impl.UserService;
import com.mk.url.URL;
import com.mk.util.Utils;

@Controller
public class PersonInfoController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(URL.Person.userInfo)
	public UserInfo getUserInfo() {

		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		return userService.getUserInfo(id);

	}

	@ResponseBody
	@RequestMapping(URL.Person.icon)
	public Map<String, Object> uploadFile(MultipartFile icon,String imageURL) {

		boolean hasImage=!Utils.isNullOrSpaceWhite(imageURL);
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		String path = session.getServletContext().getRealPath("");
	
		Map<String, Object> map = new HashMap<>();
		try {
            if(!hasImage)
			  imageURL = "icon/" + id + ".jpg";
            
			File file = new File(new File(path), imageURL);
			file.getParentFile().mkdirs();

			if (Utils.getSuffix(icon.getOriginalFilename()).matches("[jJ][pP][eE]?[gG]"))
				icon.transferTo(file);
			else {
				BufferedImage bImage = ImageIO.read(icon.getInputStream());
				ImageIO.write(bImage, "jpg", file);
			}
			
			if(!hasImage)
			    userService.save(id, imageURL);
			
			 map.put("url", imageURL);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return map;

	}

	@ResponseBody
	@RequestMapping(URL.Person.nickName)
	public Map<String, Object> modifyNickname(String oldName, String newName) {

		Map<String, Object> map = null;
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null) {
			// 未登录
			map = new HashMap<>();
			Status status = Status.error(Login.noLogin);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		} else if (Objects.equals(oldName, newName)) {
			map = new HashMap<>();
			Status status = Status.error(UserName.newOldNameSame);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		} else
			map = userService.modifyNickName(id, oldName, newName);

		return map;

	}

	@ResponseBody
	@RequestMapping(URL.Person.modifyInfo)
	public Map<String, Object> modifyInfo(String sex, String birthday,
			String info) {

		Map<String, Object> map = null;
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null) {
			// 未登录
			map = new HashMap<>();
			Status status = Status.error(Login.noLogin);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		} else {
			map = userService.modifyInfo(id, sex, birthday, info);
		}

		return map;

	}

	@ResponseBody
	@RequestMapping(URL.Person.modifyDetail)
	public Map<String, Object> modifyDetail(UserDetail userDetail) {

		Map<String, Object> map = null;
		Integer id = (Integer) session.getAttribute(NameInfo.userId);
		if (id == null) {
			// 未登录
			map = new HashMap<>();
			Status status = Status.error(Login.noLogin);
			map.put(NameInfo.status, status.isSuccess());
			map.put(NameInfo.msg, status.getValue());
		} else {
			map = userService.modifyDetail(id, userDetail);
		}

		return map;

	}

}
