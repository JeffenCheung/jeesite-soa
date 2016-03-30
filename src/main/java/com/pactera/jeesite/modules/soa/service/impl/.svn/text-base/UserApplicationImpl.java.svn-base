package com.pactera.jeesite.modules.soa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pactera.jeesite.modules.soa.entity.UserVO;
import com.pactera.jeesite.modules.soa.service.UserApplication;

@Component("userApplication")
@Transactional
public class UserApplicationImpl implements UserApplication {

	public String sayHello(String name) {
		UserVO userVO = new UserVO();
		userVO.setName(name);
		userVO.setAge(23);
		return userVO.getUserVO();
	}

	public List<UserVO> findList(UserVO user) {
		List<UserVO> userList = new ArrayList<UserVO>();
		UserVO userVO = new UserVO();
		userVO.setName(user.getName());
		userVO.setAge(23);
		userList.add(userVO);
		return userList;
	}

	public void save(UserVO user) {
		System.out.println("save succes!");
	}

	public void delete(UserVO user) {
		System.out.println("delete succes!");
	}
}