package com.wyj.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wyj.common.pojo.TaotaoResult;
import com.wyj.common.utils.JsonUtils;
import com.wyj.content.jedis.JedisClient;
import com.wyj.content.service.ContentService;
import com.wyj.mapper.TbContentMapper;
import com.wyj.pojo.TbContent;
import com.wyj.pojo.TbContentExample.Criteria;
import com.wyj.pojo.TbContentExample;

@Service
public class ContentServiceImpl implements ContentService{
	
	@Autowired
    private TbContentMapper contentMapper;

	@Autowired
    private JedisClient jedisClient;

    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY; 
    
    @Override
    public TaotaoResult insertContent(TbContent content) {
        // 补全pojo的属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        // 向内容表中插入数据
        contentMapper.insert(content);
     // 做缓存同步，清除redis中内容分类id对应的缓存信息
        jedisClient.hdel(CONTENT_KEY, content.getCategoryId().toString());
        return TaotaoResult.ok();
    }

	@Override
	public List<TbContent> getContentList(long cid) {
		// 查询数据库之前，先查询缓存，并且添加缓存不能影响正常业务逻辑
	    try {
	        String json = jedisClient.hget(CONTENT_KEY, cid + "");
	        // 判断是否命中缓存，判断json字符串是否为null或""
	        if (StringUtils.isNotBlank(json)) {
	            // 把这个json转换成List集合
	            List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
	            return list;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
		TbContentExample example=new TbContentExample();
		Criteria criteria=example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list=contentMapper.selectByExample(example);
		// 向缓存中保存结果，并且添加缓存不能影响正常业务逻辑
	    try {
	        jedisClient.hset(CONTENT_KEY, cid + "", JsonUtils.objectToJson(list));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return list;
	}

}
