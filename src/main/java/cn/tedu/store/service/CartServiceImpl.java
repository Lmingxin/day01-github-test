package cn.tedu.store.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;

@Service("cartService")
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartMapper cartMapper;

	public Cart insert(Cart cart) {
		// 保存日志信息
		Date now = new Date();
		cart.setCreatedUser("System");
		cart.setCreatedTime(now);
		cart.setModifiedUser("System");
		cart.setModifiedTime(now);

		cartMapper.insert(cart);
		return cart;
	}

	public List<Cart> getListByUid(Integer uid, Integer page) {
		// 判断page
		if (page == null || page < 1) {
			page = 1;
		}
		// 确定每页显示多少条数据
		Integer countPerPage = DEFAULT_COUNT_PER_PAGE;
		// 跳过多少条数据
		Integer offset = (page - 1) * countPerPage;
		// 执行查询，并返回结果
		return cartMapper.getListByUid(uid, offset, countPerPage);
	}

	public Cart getCartByUserAndGoods(Integer uid, Long goodsId) {
		return cartMapper.getCartByUserAndGoods(uid, goodsId);
	}

	public Integer changeNumber(Integer num, Integer id, Integer uid) {
		return cartMapper.changeNumber(num, id, uid);
	}

	public Integer addToCart(Cart cart) {
		// 查询用户id与商品id同时匹配的记录是否存在
		Integer uid = cart.getUid();
		Long goodsId = cart.getGoodsId();
		Cart data = getCartByUserAndGoods(uid, goodsId);
		if (data != null) {
			// 存在：修改数量
			Integer id = data.getId();
			Integer num = data.getNum() + cart.getNum(); // 1 + 3
			return changeNumber(num, id, uid);
		} else {
			// 不存在：添加数据
			insert(cart); 
			return 1;
		}
	}

}
