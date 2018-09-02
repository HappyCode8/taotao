package com.wyj.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.common.utils.CookieUtils;
import com.wyj.common.utils.JsonUtils;
import com.wyj.pojo.TbUser;
import com.wyj.sso.service.UserLoginService;
import com.wyj.sso.service.UserRegisterService;

@Controller
public class UserController {
	@Autowired
    private UserRegisterService userRegisterService;

	@Autowired
    private UserLoginService userLoginService;

    @Value("${COOKIE_TOKEN_KEY}")
    private String COOKIE_TOKEN_KEY;
    
    @RequestMapping(value="/user/check/{param}/{type}", method=RequestMethod.GET)
    @ResponseBody
    public TaotaoResult checkUserInfo(@PathVariable String param, @PathVariable Integer type) {
        TaotaoResult result = userRegisterService.checkUserInfo(param, type);
        return result;
    }
    
    @RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult regitsterUser(TbUser user) {
		TaotaoResult result = userRegisterService.createUser(user);
	    return result;
	}
    
    @RequestMapping(value="/user/login", method=RequestMethod.POST)
    @ResponseBody
    public TaotaoResult userLogin(String username, String password,
            HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult taotaoResult = userLoginService.login(username, password);
        // 取出token
        if(taotaoResult.getStatus()==200){
        String token = taotaoResult.getData().toString();
        // 在返回结果之前，设置cookie(即将token写入cookie)
        // 1.cookie怎么跨域？
        // 2.如何设置cookie的有效期？
        CookieUtils.setCookie(request, response, COOKIE_TOKEN_KEY, token);
        // 返回结果
        }
        return taotaoResult;
    }
    
    @RequestMapping(value="/user/token/{token}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getUserByToken(@PathVariable String token, String callback) {
		TaotaoResult result = userLoginService.getUserByToken(token);
		if (StringUtils.isNotBlank(callback)) {
	        // 客户端为jsonp请求，需要返回js代码
	        String jsonResult = callback + "(" + JsonUtils.objectToJson(result) + ");";
	        return jsonResult; // 统一返回字符串
	    }
	    return JsonUtils.objectToJson(result); // 统一返回字符串
	}
    
    @RequestMapping(value="/user/logout/{token}")
	@ResponseBody
	public TaotaoResult logout(@PathVariable String token) {
		TaotaoResult result = userLoginService.logout(token);
		return result;
	}
}
