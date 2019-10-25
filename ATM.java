package Function;
import java.util.ArrayList;
import java.util.Map;

public class ATM {
	private ArrayList<CustomerAccount> customerAccounts;
	private ManagerAccount manager;
	private CustomerAccount currentAccount;
	
	public ATM() {
		customerAccounts = new ArrayList<CustomerAccount>();
		manager = new ManagerAccount("123456");
	}
	public void createNewCheckingAccount(String iID,String ipwd,String iphone){
		customerAccounts.add(new CheckingAccount(iID,ipwd, iphone, "checking"));
	}
	
	public void createNewSavingAccount(String iID,String ipwd,String iphone) {
		customerAccounts.add(new SavingAccount(iID,ipwd, iphone, "saving"));
	}
	public boolean closeAccount(String username) {//rewrite customerAccount.equal() to find same username account
		CustomerAccount test = new CustomerAccount(username,"0");
		int index = customerAccounts.indexOf(test);
		if(customerAccounts.get(index).canClose()) {
			customerAccounts.remove(index);
			return true;
		}else {
			return false;
		}
	}
	public float deposit(String type, float amount) {
		return currentAccount.depositMoney(type,amount);
	}
	
	public float withdraw(String type, float amount) {
		if(currentAccount.getAccountType().equals("saving")) {
			SavingAccount op = (SavingAccount)currentAccount;//Forced
			op.addTimes();
		}
			
		return currentAccount.withdrawMoney(type,amount);
	}
	public void Loan(Loan newloan) {//request loan
		currentAccount.requestLoan(newloan);
	}
	public void PayLoan(int ID) {
		currentAccount.payLoan(ID);
	}
	public void managerGetReport() {
		manager.getReport().clear();
		ArrayList<Record> a = manager.getReport();
		for( CustomerAccount i : customerAccounts) {
			a.addAll(i.getReport());
		}
		manager.setReport(a);
	}
	public String managerViewNewReport() {
		String text = "";
		for(CustomerAccount i : customerAccounts) {
			text = text + "USERNAME "+ i.getID() + ":\n" ;
			for (Map.Entry<String, Float> entry : i.getBalance().entrySet()) {
				text = text + entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n";
			}
		}
		return text + manager.viewNewReport();
	}
	public String managerViewReport() {
		String text = "";
		for(CustomerAccount i : customerAccounts) {
			text = text +  "USERNAME "+ i.getID() + ":\n" ;
			for (Map.Entry<String, Float> entry : i.getBalance().entrySet()) {
				text = text + entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n";
			}
		}
		return text + manager.viewReport();
	}
	public String customerViewReport() {//used by customer to view
		return currentAccount.viewReport();
	}
	public boolean bankerLogin(String pwd) {
		if(pwd.equals(manager.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean CustomerLogin(String ID,String pwd,String type) {
		CustomerAccount test = new CustomerAccount(ID,pwd);
		int index = customerAccounts.indexOf(test);
		if(!sameID(ID))
			return false;
		if(pwd.equals(customerAccounts.get(index).getPassword())&&customerAccounts.get(index).getAccountType().equals(type)) {
	        currentAccount = customerAccounts.get(index);// maybe we should not store this here?
			return true;
		}else {
			return false;
		}
	}
	public boolean sameID(String ID) {// have same ID?
		for(CustomerAccount i : customerAccounts) {
			if(i.getID().equals(ID))
				return true;
		}
		return false;
	}
	public void transfer(String ID,String moneyType, float amount) {
		CustomerAccount test = new CustomerAccount(ID,"0");
		System.out.println(ID);
		int index = customerAccounts.indexOf(test);
		if(customerAccounts.get(index).getAccountType().equals("checking")) {
			CustomerAccount transfer = customerAccounts.get(index);
			currentAccount.transfer(transfer, moneyType, amount);
		}
	}
	public void chargeInterest() {
		for(CustomerAccount i : customerAccounts) {
			i.increaseLoan();
		}
	}
	public void payInterest() {
		for(CustomerAccount i : customerAccounts) {
			if(i.getAccountType() == "saving") {
				SavingAccount op = (SavingAccount)i;//Forced
				op.interestPaid(manager.getThresholdOfPay(), manager.getInterest());
			}
		}
	}
	public void setCurrentAccount(CustomerAccount a) {
		currentAccount = a;
	}
	public CustomerAccount getCurrentAccount() {
		return currentAccount;
	}
	public ArrayList<CustomerAccount> getCustomerAccounts() {
		return customerAccounts;
	}
	
}
