package test.tp;

public class Account {
	private String name;
	private int number;
	private int amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String create(String name) {
		System.out.println("----------- create receives: " + name);
		return "Account created for " + name;
	}
}
