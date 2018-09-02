package com.wyj.sso.service;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.pojo.TbUser;

public interface UserRegisterService {
	TaotaoResult checkUserInfo(String param,int type);
	TaotaoResult createUser(TbUser user);
}
