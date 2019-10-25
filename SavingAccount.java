package Function;

import java.util.Map;

public class SavingAccount extends CustomerAccount{
	private int withdrawTimes;
	
	public SavingAccount(String iID,String ipwd,String iphone,String iaccountType) {
		super(iID,ipwd, iphone, iaccountType);
		withdrawTimes = 0;
	}
	
	public void interestPaid(int threshold,float rate) {
			for (Map.Entry<String, Float> entry : balance.entrySet()) {
				if(entry.getValue()>= threshold) {
					report.add(new Record(ID,entry.getValue()*rate,"paid by interest rate " + rate,entry.getKey()));

					balance.put(entry.getKey(),entry.getValue()*(1+rate));
				}
			}
	}
	public int addTimes() {
		return ++withdrawTimes;
	}
	public boolean haveTimes() {
		return withdrawTimes < ManagerAccount.getWithdrawLimitation();
	}
}
