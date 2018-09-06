package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IGoodsCategoryService goodsCategoryService;
	
	@RequestMapping("/list.do")
	public String showList(
	        @RequestParam("category_id") Long categoryId,
	        @RequestParam(value="age", required=false, defaultValue="1") Integer page,
	        ModelMap modelMap) {
	    // 判断page是否有效
	    if(page == null || page < 0) {
	        page = 1;
	    }
	    
	    // 通过业务层获取数据
	    // 1. 商品列表
	    Integer offset =
	         (page - 1) * IGoodsService.DEFAULT_COUNT_PER_PAGE;
	    List<Goods> goodsList = 
	            goodsService.getGoodsListByCategory(
	                categoryId, offset,
	                IGoodsService.DEFAULT_COUNT_PER_PAGE);
	    // 2. 商品分类数据
	    GoodsCategory goodsCategory
	    	= goodsCategoryService.getGoodsCategoryById(categoryId);
	    
	    // 将数据封装，准备转发
	    modelMap.addAttribute("goodsList", goodsList);
	    modelMap.addAttribute("goodsCategory", goodsCategory);
	    
	    // 执行转发
	    return "goods_list";
	}
	
}
