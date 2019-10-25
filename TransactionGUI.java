package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.ATM;
import Function.ManagerAccount;
import Function.SavingAccount;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class TransactionGUI extends JPanel{
	private final String reg = "^[0-9]+(\\.[0-9]{1,4})?$";
    private JLabel lType = new JLabel("currency");
    private JComboBox cType = new JComboBox();
    private JLabel lAmount = new JLabel("amount");
    private	JTextField tAmount = new JTextField(); 
    private JButton bDeposit = new JButton("Deposit"); 
    private JButton bWithdraw = new JButton("Withdraw"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Transaction Page");
    private JLabel jError = new JLabel("");
    
    public TransactionGUI(GUI GUI) {
    	cType.addItem("Dollar");
    	cType.addItem("Euro");
    	cType.addItem("CNY");
    	this.setLayout(null);
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(180,50,600,150);
        lType.setBounds(180,170,70,30);
        cType.setBounds(250,170,200,30);
        lAmount.setBounds(180,200,70,30);
        tAmount.setBounds(250,200,200,30);
        bDeposit.setBounds(230,250,100,60);
        bWithdraw.setBounds(340,250,100,60);
        jError.setBounds(290, 310, 100, 50);
        bDeposit.setFont(new Font("Arial",Font.BOLD, 10));
        bWithdraw.setFont(new Font("Arial",Font.BOLD, 10));
        jError.setVisible(false);
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bDeposit.setBackground(new Color(0,115,207));
        bDeposit.setForeground(Color.white);
        bWithdraw.setBackground(new Color(0,115,207));
        bWithdraw.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lType);
        this.add(cType);
        this.add(lAmount);
        this.add(tAmount);
        this.add(bDeposit);
        this.add(bWithdraw);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jError);
        bDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tAmount.getText().length()>0&&tAmount.getText().length()<=7&&tAmount.getText().matches(reg))
            	{
            		float amount = Float.valueOf(tAmount.getText());
            		String currency = (String)cType.getSelectedItem();
            		GUI.data.deposit(currency,amount);
            		jError.setVisible(false);

            	}else {
        	        jError.setBounds(180, 310, 350, 50);
            		jError.setText("should enter number less than 10000000");
            		jError.setVisible(true);
            	}
            }
        });
        bWithdraw.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(GUI.data.getCurrentAccount().getAccountType().equals("saving"))
            	{
        			SavingAccount op = (SavingAccount)GUI.data.getCurrentAccount();//Forced
        			if(!op.haveTimes()) {
        				jError.setBounds(210, 310, 420, 50);
                		jError.setText("Do not have withdraw times");
                		jError.setVisible(true);
                		return;
        			}
        			if(tAmount.getText().length()>0&&tAmount.getText().length()<=7&&tAmount.getText().matches(reg)&&Float.valueOf(tAmount.getText())<=GUI.data.getCurrentAccount().getBalance().get((String)cType.getSelectedItem()) - ManagerAccount.getWithdrawalFee())
                	{
                		float amount = Float.valueOf(tAmount.getText());
                		String currency = (String)cType.getSelectedItem();
                		GUI.data.withdraw(currency,amount);
                		jError.setVisible(false);

                	}else {
            	        jError.setBounds(120, 310, 420, 50);
                		jError.setText("should enter 0<= number <10000000 and have enough money");
                		jError.setVisible(true);
                	}
            	}
            	else {
            	if(tAmount.getText().length()>0&&tAmount.getText().length()<=7&&tAmount.getText().matches(reg)&&Float.valueOf(tAmount.getText())<=GUI.data.getCurrentAccount().getBalance().get((String)cType.getSelectedItem()) - ManagerAccount.getWithdrawalFee())
            	{
            		float amount = Float.valueOf(tAmount.getText());
            		String currency = (String)cType.getSelectedItem();
            		GUI.data.withdraw(currency,amount);
            		jError.setVisible(false);

            	}else {
        	        jError.setBounds(120, 310, 420, 50);
            		jError.setText("should enter 0<= number <10000000 and have enough money");
            		jError.setVisible(true);
            	}
            	}
            }
        });
        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(GUI.data.getCurrentAccount().getAccountType().contentEquals("checking"))
            	GUI.cl.show(GUI.cards, "checking");
            	else
            		GUI.cl.show(GUI.cards, "saving");
            }
        });
        bHome.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");
            }
        });
}
    
    
}
