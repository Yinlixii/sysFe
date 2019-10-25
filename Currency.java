package Function;

public class Currency {
	private String type;
	private float amount;
	
	public Currency(String itype, float iamount) {
		type = itype;
		amount = iamount;
	}
	
	public String getType() {
		return type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float a) {
		amount = a;
	}
}
