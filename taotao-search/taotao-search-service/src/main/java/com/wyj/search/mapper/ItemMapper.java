package com.wyj.search.mapper;

import java.util.List;

import com.wyj.common.pojo.SearchItem;

public interface ItemMapper {
	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);
}
