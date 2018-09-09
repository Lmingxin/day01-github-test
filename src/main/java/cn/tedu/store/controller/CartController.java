package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.ServiceException;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{

	@Autowired
	private ICartService cartService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public ResponseResult<Void> handleAddToCart(Cart cart,HttpSession session){
		ResponseResult<Void> rr;
		
		Integer id = getUidFromSession(session);
		cart.setUid(id);;
		
		// 执行添加到购物车
	    cartService.addToCart(cart);
		
		rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
		
		return rr;
	}
	
	@RequestMapping("/list.do")
	public String showList(Integer page, HttpSession session, ModelMap modelMap) {
		if (page == null || page < 1) {
			page = 1;
		}
		Integer uid = getUidFromSession(session);
		List<Cart> carts = cartService.getListByUid(uid, page);
		modelMap.addAttribute("carts", carts);
		return "cart_list";
	}
	
	@RequestMapping("/change_number.do")
	@ResponseBody
	public ResponseResult<Void> handleChangeNumber(Integer num, Integer id, HttpSession session) {
		// 声明返回值
		ResponseResult<Void> rr;
		// 获取uid
		Integer uid = getUidFromSession(session);
		// 执行修改
		try {
			cartService.changeNumber(num, id, uid);
			rr = new ResponseResult<Void>(ResponseResult.STATE_OK);
		} catch(ServiceException e) {
			rr = new ResponseResult<Void>(e);
		}
		// 执行返回
		return rr;
	}

}
