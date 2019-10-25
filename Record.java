package Function;

public class Record {
	private String user;
	private float amount;
	private String typeOfOperation;
	private String currencyType;
	
	public Record(String iUser,float iAmount,String iTypeOfOpearation, String icurrencyType) {
		user = iUser;
		amount = iAmount;
		typeOfOperation = iTypeOfOpearation;
		currencyType = icurrencyType;
	}
	public String getUser() {
		return user;
	}
	public float getAmount() {
		return amount;
	}
	public String getTypeOfOperation() {
		return typeOfOperation;
	}
	public String getCurrencyType() {
		return currencyType;
	}
}
