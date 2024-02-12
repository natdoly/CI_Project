package test.tp;

public class MyAccount {
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

  @Override
	public String toString() {
		return "MyAccount [name=" + name + ", number=" + number + ", amount=" + amount + "]";
	}
}
