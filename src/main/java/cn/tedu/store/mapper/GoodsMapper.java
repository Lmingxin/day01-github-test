package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Goods;

public interface GoodsMapper {

	/**
	 * 获取所有商品的数据
	 * @return 所有商品的数据的List集合
	 */
	@Deprecated
	List<Goods> getGoodsList();
	
	/**
	 * 根据商品分类id获取商品列表
	 * @param categoryId 商品分类id
	 * @param offset 跳过多少条记录
	 * @param countPerPage 最多获取多少条记录
	 * @return 商品列表的List集合，在每一个商品信息中，只包括id、图片、标题、价格
	 */
	List<Goods> getGoodsListByCategory(
			@Param("categoryId") Long categoryId, 
			@Param("offset") Integer offset, 
			@Param("countPerPage") Integer countPerPage);
	
	/**
	 * 根据商品分类id获取商品数量
	 * @param categoryId	商品id
	 * @return	返回某个分类下的商品数量
	 */
	Integer getGoodsCountByCategory(Long categoryId);
	
	Goods getGoodsById(Long id);
	
	/**
	 * 根据商品型号获取商品
	 * @param itemType	商品型号
	 * @return	返回同型号的商品的列表
	 */
	List<Goods> getGoodsListByItemType(String itemType);
}
