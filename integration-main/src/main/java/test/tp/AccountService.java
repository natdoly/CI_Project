package test.tp;

public class AccountService {
  
  public MyAccount myService(MyAccount myAccount){
		System.out.println(myAccount);
		MyAccount ma = new MyAccount();
		ma.setAmount(myAccount.getAmount() + 200);
		ma.setName(myAccount.getName());
		ma.setNumber(myAccount.getNumber());
		return ma;
	}
}
