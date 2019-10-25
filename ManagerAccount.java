package Function;
import java.util.ArrayList;

public class ManagerAccount {
	private int thresholdOfPay;// pay for saving bank 1000$ 
	private static float closeFee;
	private static int withdrawLimitation;
	private float interest;
	private int index;//report operation
	private ArrayList<Record> report;
	private static float withdrawalFee;
	private String password;
	
	public ManagerAccount(String myPassword) {
		thresholdOfPay = 1000;// change for other currency
		index = 0;
		closeFee = 10F;
		withdrawLimitation = 6;
		interest = 0.1F;
		withdrawalFee = 10F;
		password = myPassword;
		report = new ArrayList<Record>();
	}
	public String viewNewReport() {
		String text = "";
		Record i;
		for(int num = index ; num < report.size();num++) {
			i=report.get(num);
			text = text + String.valueOf(num+1) + " ID:"  + i.getUser() + " " + i.getTypeOfOperation() + " " + String.valueOf(i.getAmount()) + " " + i.getCurrencyType() +  "\n";
		}
		index = report.size();
		return text;
	}
	public String viewReport() {
		String text = "";
		int num = 0;
		for(Record i : report) {
			num++;
			text = text + String.valueOf(num) + " ID:"  + i.getUser() + " " + i.getTypeOfOperation() + " " + String.valueOf(i.getAmount()) + " " + i.getCurrencyType() +  "\n";
		}
		index = report.size();
		return text;
	}

	public static float getWithdrawalFee() {
		return withdrawalFee;
	}
	public String getPassword() {
		return password;
	}
	public ArrayList<Record> getReport(){
		return report;
	}
	public float getInterest() {
		return interest;
	}
	public static int getWithdrawLimitation() {
		return withdrawLimitation;
	}
	public static float getCloseFee() {
		return closeFee;
	}
	public int getThresholdOfPay() {
		return thresholdOfPay;
	}
	public void setReport(ArrayList<Record> a) {
		report = a;
	}
}
