package Function;
import java.util.*;
public class CustomerAccount {
	protected String ID;
	protected String pwd;
	protected String phone;
	protected String accountType;
	protected Map<String,Float> balance;
	protected boolean collateral;
	protected ArrayList<Record> report;
	protected ArrayList<Loan> accountLoan;
	
	public CustomerAccount(String iID, String ipwd) {
		ID = iID;
		pwd = ipwd;
		report = new ArrayList<Record>();
		accountLoan = new ArrayList<Loan>();
	}
	public CustomerAccount() {
		ID = "0";
		pwd = "0";
		report = new ArrayList<Record>();
		accountLoan = new ArrayList<Loan>();
	}
	public CustomerAccount(String iID,String ipwd,String iphone,String iaccountType) {
		balance = new HashMap<String,Float>();
	    balance.put("Dollar", 0F);
	    balance.put("Euro", 0F);
	    balance.put("CNY", 0F);
		collateral = false;
		report = new ArrayList<Record>();
		accountLoan = new ArrayList<Loan>();
		ID = iID;
		pwd = ipwd;
		phone = iphone;
		accountType = iaccountType;
	}
	
	public float depositMoney(String type, float amount) {
		balance.put(type,balance.get(type) + amount);// first try
		report.add(new Record(ID,amount,"deposit",type));
		return amount;
	}
	public float withdrawMoney(String type, float amount) {
		balance.put(type,balance.get(type) - amount - ManagerAccount.getWithdrawalFee());
		report.add(new Record(ID,ManagerAccount.getWithdrawalFee(),"withdraw fee",type));
		report.add(new Record(ID,amount,"withdraw",type));
		return amount;
	}
	public void requestLoan(Loan newloan) {
		balance.put(newloan.getMoney().getType(),balance.get(newloan.getMoney().getType()) + newloan.getMoney().getAmount());
		accountLoan.add(newloan);
		report.add(new Record(ID,newloan.getMoney().getAmount(),"requestLoan",newloan.getMoney().getType()));
	}
	public void payLoan(int LoanID) {
		Loan find = new Loan(LoanID);
		int index = accountLoan.indexOf(find);
		balance.put(accountLoan.get(index).getMoney().getType(),balance.get(accountLoan.get(index).getMoney().getType()) - accountLoan.get(index).getMoney().getAmount());
		report.add(new Record(ID,accountLoan.get(index).getMoney().getAmount(),"payForLoan",accountLoan.get(index).getMoney().getType()));
		accountLoan.remove(index);
	}
	public boolean haveLoan(int LoanID) {//have ID loanID loan?
		for(Loan i : accountLoan) {
			if(i.getThisID()==LoanID)
				return true;
		}
		return false;
	}
	public Loan getLoanByID(int LoanID) {
		Loan find = new Loan(LoanID);
		int index = accountLoan.indexOf(find);
		Loan a = accountLoan.get(index);
		return a;
	}
	public void increaseLoan() {
		for(Loan i : accountLoan){
			i.getMoney().setAmount(i.getMoney().getAmount() * (1+i.getInterest()));
			report.add(new Record(ID,i.getMoney().getAmount(),"#"+i.getThisID()+" loan increases by interest rate " + i.getInterest() + " to ",i.getMoney().getType()));
		}
	}
	public void transfer(CustomerAccount trans,String type, float amount) {
		balance.put(type,balance.get(type) - amount);
		trans.getBalance().put(type,trans.getBalance().get(type) + amount);
		report.add(new Record(ID,amount,"transferOut",type));
		trans.getReport().add(new Record(trans.getID(),amount,"transferIn",type));
	}
	public String viewReport() {
		String text = "";
		text = text +   "USERNAME "+ ID + ":\n" ;
		for (Map.Entry<String, Float> entry : balance.entrySet()) {
			text = text + entry.getKey() + ": " + String.valueOf(entry.getValue()) + "\n";
		}
		int num = 0;
		for(Record i : report) {
			num++;
			text = text + String.valueOf(num) + " USERNAME:" + i.getUser() + " " + i.getTypeOfOperation() + " " + String.valueOf(i.getAmount()) + " " + i.getCurrencyType() +  "\n";
		}
		return text;
	}
	public boolean canClose() {// should have enough money then can close
		for (Map.Entry<String, Float> entry : balance.entrySet()) {
			if(entry.getValue()>= ManagerAccount.getCloseFee())
				return true;
		}
		return false;
	}
	public void setCollateral(boolean input) {
		collateral = input;
	}
	public Map<String,Float> getBalance() {
		return balance;
	}

	public String getPassword() {
		return pwd;
	}
	public String getID() {
		return ID;
	}
	public String getAccountType() {
		return accountType;
	}
	public boolean getCollateral() {
		return collateral;
	}
	public ArrayList<Loan> getAccountLoan(){
		return accountLoan;
	}
	public ArrayList<Record> getReport(){
		return report;
	}
	public String getLoanReport() {
		String text = "";
		for( Loan i : accountLoan)
		{
			text = text + i.getThisID() + " " + i.getInterest() + " " + i.getMoney().getAmount() + " " + i.getMoney().getType() + "\n";
		}
		return text;
	}
	//for login
	@Override
	public boolean equals(Object obj) {//rewrite for search
		if(obj instanceof CustomerAccount) {
			CustomerAccount account = (CustomerAccount)obj;
			return ID.equals(account.getID());
		}
		return false;
	}
	@Override
	public int hashCode() {
	     int result = 17;
	     result = 31 * result + (ID == null ? 0 : ID.hashCode());
	     return result;
	    }
	
	
}
