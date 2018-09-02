package com.wyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.content.service.ContentService;
import com.wyj.pojo.TbContent;

@Controller
public class ContentController {
	@Autowired
	private ContentService ContentService;
	
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent content){
		TaotaoResult result=ContentService.insertContent(content);
		return result;
	}
}
