package cn.tedu.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;

@Service
public interface ICartService {
	int DEFAULT_COUNT_PER_PAGE = 20;
	
	/**
	 * 向购物车添加商品
	 * @param cart
	 * @return	新增的数据对象
	 */
	Cart insert(Cart cart);
	
	/**
	 * 查询某个用户的购物车信息
	 * @param uid	用户id
	 * @param page	页码
	 * @return
	 */
	List<Cart> getListByUid(Integer uid, Integer page);
	
	/**
	 * 根据用户id商品id查询购物车信息
	 * @param uid	用户id
	 * @param goodsId	商品id
	 * @return	有则返回，无则返回null
	 */
	Cart getCartByUserAndGoods(Integer uid, Long goodsId);
	
	/**
	 * 修改购物车某商品的数量
	 * @param num
	 * @param id
	 * @param uid
	 * @return
	 */
	Integer changeNumber(Integer num, Integer id, Integer uid);
	
	/**
	 * 查询商品是否存在
	 * @param cart
	 * @return
	 */
	Integer addToCart(Cart cart);
}
