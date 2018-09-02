package com.wyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyj.common.pojo.EasyUIDataGridResult;
import com.wyj.common.pojo.TaotaoResult;
import com.wyj.pojo.TbItem;
import com.wyj.service.ItemService;

@Controller
public class ItemController {
    
	@Autowired
    public ItemService itemService;
    
	@RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long itemId){
    	return itemService.getItemById(itemId);
    }
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		EasyUIDataGridResult result=itemService.getItemList(page,rows);
		return result;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult addItem(TbItem item,String desc){
		TaotaoResult result=itemService.addItem(item, desc);
		return result;
	}
	
}
