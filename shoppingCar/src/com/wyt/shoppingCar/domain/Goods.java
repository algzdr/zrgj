package com.wyt.shoppingCar.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable{
	
	// 商品id
		private Integer goodsId;
		// 商品名称
		private String goodsName;
		// 商品种类
		private String category;
		// 商品单价
		private Double goodsPrice;
		public Integer getGoodsId() {
			return goodsId;
		}
		public void setGoodsId(Integer goodsId) {
			this.goodsId = goodsId;
		}
		public String getGoodsName() {
			return goodsName;
		}
		public void setGoodsName(String goodsName) {
			this.goodsName = goodsName;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Double getGoodsPrice() {
			return goodsPrice;
		}
		public void setGoodsPrice(Double goodsPrice) {
			this.goodsPrice = goodsPrice;
		}
		@Override
		public String toString() {
			return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", category=" + category + ", goodsPrice="
					+ goodsPrice + "]";
		}
		public Goods() {
			
		}
		public Goods(Integer goodsId, String goodsName, String category, Double goodsPrice) {
			super();
			this.goodsId = goodsId;
			this.goodsName = goodsName;
			this.category = category;
			this.goodsPrice = goodsPrice;
		}
		@Override
		public int hashCode() {
			return super.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
		
		
}
