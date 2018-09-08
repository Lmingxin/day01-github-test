package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;

public interface IGoodsService {
	/**
	 * 默认每页显示的数据的数量
	 */
	int DEFAULT_COUNT_PER_PAGE = 20;

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
			Long categoryId, Integer offset, Integer countPerPage);
	
	/**
	 * 根据商品分类id获取商品列表
	 * @param categoryId 商品分类id
	 * @param count 最多获取多少条记录
	 * @return 商品列表的List集合，在每一个商品信息中，只包括id、图片、标题、价格
	 */
	List<Goods> getGoodsListByCategory(
			Long categoryId, Integer count);
	
	Integer getGoodsCountByCategory(Long categoryId);
	
	Goods getGoodsById(Long id);
	
	/**
	 * 根据item_type查询对应条件下的所有数据
	 * @param itemType	itemType属性的值
	 * @return	返回所有与item_type值相同的商品的集合
	 */
	List<Goods> getGoodsListByItemType(String itemType);
}
