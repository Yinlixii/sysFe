package Function;

public class Loan {
	public static int AllID;
	private int thisID;
	private Currency money;
	private float interest;
	
	public Loan(int ID) {
		thisID = ID;
	}
	public Loan(String type, float amount, float iInterest) {
		AllID++;
		thisID = AllID;
		money = new Currency(type,amount);
		interest = iInterest;
	}
	
	public int getThisID() {
		return thisID;
	}
	public Currency getMoney() {
		return money;
	}
	public float getInterest() {
		return interest;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Loan) {
			Loan loan = (Loan)obj;
			return thisID == loan.getThisID();
		}
		return false;
	}
	@Override
	public int hashCode() {
	     int result = 17;
	     result = 31 * result + (thisID == 0? 1 :0);
	     return result;
	    }
}
