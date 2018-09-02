package com.wyj.sso.service;

import com.wyj.common.pojo.TaotaoResult;

public interface UserLoginService {
	TaotaoResult login(String username,String password);
	TaotaoResult getUserByToken(String token);
	TaotaoResult logout(String token);
}
