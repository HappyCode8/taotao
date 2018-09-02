package com.wyj.content.service;

import java.util.List;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.pojo.TbContent;

public interface ContentService {
	TaotaoResult insertContent(TbContent content);
	List<TbContent> getContentList(long cid);
}
