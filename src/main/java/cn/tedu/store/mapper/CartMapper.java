package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;

public interface CartMapper {

	/**
	 * 添加购物车商品
	 * @param cart
	 * @return
	 */
	Integer insert(Cart cart);
	
	/**
	 * 查询某用户的购物车信息
	 * @param uid
	 * @param offset
	 * @param countPerPage
	 * @return
	 */
	List<Cart> getListByUid(@Param("uid")Integer uid,@Param("offset") Integer offset,@Param("countPerPage") Integer countPerPage);

	/**
	 * 根据用户id商品id查询购物车信息
	 * @param uid	用户id
	 * @param goodsId	商品id
	 * @return	有则返回，无则返回null
	 */
	Cart getCartByUserAndGoods(@Param("uid") Integer uid, @Param("goodsId") Long goodsId);
	
	/**
	 * 修改购物车某商品的数量
	 * @param num
	 * @param id
	 * @param uid
	 * @return
	 */
	Integer changeNumber(@Param("num") Integer num, @Param("id") Integer id, @Param("uid") Integer uid);
}
