package com.java8.predicate;

public class Product {
	
	private String name;
	private Double price;
	private String category;
	private String grade;
	
	public Product(Builder builder) {
		this.name = builder.name;
		this.price = builder.price;
		this.category = builder.category;
		this.grade = builder.grade;
	}
	
	public static class Builder{
		private String name;
		private Double price;
		private String category;
		private String grade;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setPrice(Double price) {
			this.price = price;
			return this;
		}
		public Builder setCategory(String category) {
			this.category = category;
			return this;
		}
		
		public Builder setGrade(String grade) {
			this.grade = grade;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nname "+name).append("\nprice "+price).append("\ncategory "+category).append("\ngrade "+grade);
		return builder.toString();
	}

}
