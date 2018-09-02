package com.wyj.service;

import java.util.List;

import com.wyj.common.pojo.EasyUITreeNode;

public interface ItemCatService {
List<EasyUITreeNode> getItemCatList(long parentId);
}
