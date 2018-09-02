package com.wyj.content.service;

import java.util.List;

import com.wyj.common.pojo.EasyUITreeNode;
import com.wyj.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	List<EasyUITreeNode> getContentCatList(long parentId);
	TaotaoResult insertContentCat(long parentId,String name);
}
