package com.wyj.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wyj.common.pojo.SearchResult;
import com.wyj.search.service.SearchService;

@Controller
public class SearchController {
	@Autowired
    private SearchService searchService;

    @Value("${ITEM_ROWS}")
    private Integer ITEM_ROWS;

    @RequestMapping("/search")
    public String searchItem(@RequestParam("q") String queryString, 
            @RequestParam(defaultValue="1") Integer page, Model model) throws Exception {
    	queryString=new String(queryString.getBytes("ISO8859-1"),"UTF-8");
    	// 调用服务搜索商品信息
        SearchResult searchResult = searchService.search(queryString, page, ITEM_ROWS);        
        // 使用Model向页面传递参数
        model.addAttribute("query", queryString);
        model.addAttribute("totalPages", searchResult.getTotalPage());
        model.addAttribute("itemList", searchResult.getItemList());
        model.addAttribute("page", page);
        // 返回逻辑视图
        //int i=1/0;//人为抛出异常
        return "search";
    }
}
