package com.lezhi.supermarket.dao.service.impl;

import org.springframework.stereotype.Repository;
import com.lezhi.supermarket.dao.service.LoginDao;
import com.lezhi.supermarket.model.validation.User;

@Repository
public class LoginDaoImpl extends BaseDaoImpl<User,String> implements LoginDao{
	
	public User findUser(String userName) {
		return sqlTemplate.selectOne("com.lezhi.demo.dao.mapper.UserMapper.findUser",userName);
	}
}
