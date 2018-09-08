package cn.tedu.store.service;

import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;

@Service
public interface ICartService {
	
	/**
	 * 向购物车添加商品
	 * @param cart
	 * @return	新增的数据对象
	 */
	Cart insert(Cart cart);
}
