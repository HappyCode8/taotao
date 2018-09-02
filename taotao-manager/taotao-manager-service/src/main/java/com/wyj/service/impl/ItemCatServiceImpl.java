package com.wyj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyj.common.pojo.EasyUITreeNode;
import com.wyj.mapper.TbItemCatMapper;
import com.wyj.pojo.TbItemCat;
import com.wyj.pojo.TbItemCatExample;
import com.wyj.pojo.TbItemCatExample.Criteria;
import com.wyj.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		//根据父节点id查询子节点列表
		TbItemCatExample example=new TbItemCatExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);//查询条件：父节点id=parentId
		//执行查询（不需要分页）
		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		//转换为EasyUITreeNode列表
		List<EasyUITreeNode> resultList=new ArrayList<EasyUITreeNode>();
		for(TbItemCat tbItemCat:list){
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			/*判断它下面是不是有子节点，如果有子节点，它应该是“closed”
			如果没有子节点，它应该是“open”*/
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

}
