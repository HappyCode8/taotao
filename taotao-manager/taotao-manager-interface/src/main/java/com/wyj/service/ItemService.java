package com.wyj.service;

import com.wyj.common.pojo.EasyUIDataGridResult;
import com.wyj.common.pojo.TaotaoResult;
import com.wyj.pojo.TbItem;
import com.wyj.pojo.TbItemDesc;

public interface ItemService {
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);
	TaotaoResult addItem(TbItem item,String desc);
	TbItemDesc getItemDesc(long itemId);
}
