package cn.tedu.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;

@Service("cartService")
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartMapper cartMapper;
	
	public Cart insert(Cart cart) {
		//TODO	添加的商品如果在购物车中已经存在怎么办？
		cartMapper.insert(cart);
		return cart;
	}

}
