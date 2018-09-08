package cn.tedu.store.mapper;

import cn.tedu.store.entity.Cart;

public interface CartMapper {

	/**
	 * 添加购物车商品
	 * @param cart
	 * @return
	 */
	Integer insert(Cart cart);
}
