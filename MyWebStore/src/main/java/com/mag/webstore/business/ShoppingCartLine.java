package com.mag.webstore.business;


public class ShoppingCartLine {

	private Article article;
	private int quantity;
	
	public ShoppingCartLine ( Article article, int quantity ) {
		setArticle(article);
		setQuantity(quantity);
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void increaseQuantity() {
		this.quantity++;
	}
}
