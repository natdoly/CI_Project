package test;

public class Transactions {

  public String create(String name) {
		System.out.println("----------- create receives: " + name);
		return "Transaction created for " + name;
	}
}
