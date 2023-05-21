package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return String.format("%s $%.2f (Customs fee: $%.2f)", name, totalPrice(), customsFee);
	}

	public double totalPrice() {
		return super.price += customsFee;
	}
}
