package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable{
	private static final long serialVersionUID = -7770814704376183344L;

	private Integer id;
	private Integer uid;
	private Long goods;
	private Integer num;
	private String goodsImage;
	private String goodsTitle;
	private Long goodsPrice;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	
	
	public Cart() {
		super();
	}
	public Cart(Integer id, Integer uid, Long goods, Integer num, String goodsImage, String goodsTitle, Long goodsPrice,
			Date createdTime, Date modifiedTime, String createdUser, String modifiedUser) {
		super();
		this.id = id;
		this.uid = uid;
		this.goods = goods;
		this.num = num;
		this.goodsImage = goodsImage;
		this.goodsTitle = goodsTitle;
		this.goodsPrice = goodsPrice;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
	}
	public Integer getId() {
		return id;
	}
	public Integer getUid() {
		return uid;
	}
	public Long getGoods() {
		return goods;
	}
	public Integer getNum() {
		return num;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public Long getGoodsPrice() {
		return goodsPrice;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setGoods(Long goods) {
		this.goods = goods;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public void setGoodsPrice(Long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", goods=" + goods + ", num=" + num + ", goodsImage=" + goodsImage
				+ ", goodsTitle=" + goodsTitle + ", goodsPrice=" + goodsPrice + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ "]";
	}
	
	
}
