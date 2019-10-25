package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.ATM;
import Function.Loan;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class LoanGUI extends JPanel{
	private final String reg = "^[0-9]+(\\.[0-9]{1,4})?$";

	private JPanel p1;
    private JLabel lType = new JLabel("currency");
    private JComboBox cType = new JComboBox();
    private JLabel lRate = new JLabel("rate");
    private	JTextField tRate = new JTextField(); 
    private JLabel lAmount = new JLabel("amount");
    private	JTextField tAmount = new JTextField(); 
    private JButton bRequestLoan = new JButton("RequestLoan"); 
    private JButton bPayLoan = new JButton("PayLoan"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JButton bCollateral = new JButton("collateral");
    private JLabel jl = new JLabel("Loan Page");
    private JLabel jError = new JLabel("");
    
    public LoanGUI(GUI GUI) {
    	cType.addItem("Dollar");
    	cType.addItem("Euro");
    	cType.addItem("CNY");
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));        jl.setBounds(240,10,600,100);
        lRate.setBounds(180,140,70,30);
        tRate.setBounds(250,140,200,30);
        lType.setBounds(180,170,70,30);
        cType.setBounds(250,170,200,30);
        lAmount.setBounds(180,200,70,30);
        tAmount.setBounds(250,200,200,30);
        bRequestLoan.setBounds(230,250,100,60);
        bPayLoan.setBounds(340,250,100,60);
        jError.setBounds(290, 310, 150, 50);
        bRequestLoan.setFont(new Font("Arial",Font.BOLD, 10));
        bPayLoan.setFont(new Font("Arial",Font.BOLD, 10));
        jError.setVisible(false);
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bCollateral.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bCollateral.setBounds(400,10,100,60);
        bRequestLoan.setBackground(new Color(0,115,207));
        bRequestLoan.setForeground(Color.white);
        bPayLoan.setBackground(new Color(0,115,207));
        bPayLoan.setForeground(Color.white);
        bCollateral.setBackground(new Color(0,115,207));
        bCollateral.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lType);
        this.add(cType);
        this.add(lRate);
        this.add(tRate);
        this.add(lAmount);
        this.add(tAmount);
        this.add(bRequestLoan);
        this.add(bPayLoan);
        this.add(bBack);
        this.add(bHome);
        this.add(bCollateral);
        this.add(jl);
        this.add(jError);

        bRequestLoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(GUI.data.getCurrentAccount().getCollateral() == true) {
                	if(tAmount.getText().length()>0&&tAmount.getText().length()<=7&&tAmount.getText().matches(reg)&&tRate.getText().length()>0&&tRate.getText().length()<=7&&tRate.getText().matches(reg)&&Float.valueOf(tRate.getText())>0.01F&&Float.valueOf(tRate.getText())<1F)
                	{
            	float amount = Float.valueOf(tAmount.getText());
            	float rate = Float.valueOf(tRate.getText());
            	String currency = (String)cType.getSelectedItem();
        		jError.setVisible(false);

            	GUI.data.Loan(new Loan(currency,amount,rate));
            	}else {
        	        jError.setBounds(100, 310, 500, 50);
            		jError.setText("enter amount less than 10000000 and rate should more than 1% less than 1");
            		jError.setVisible(true);
            	}
            	}else {
            		jError.setText("Do not have collateral");
            		jError.setVisible(true);
            	}
            }
        });
        bPayLoan.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	p1 = new PayLoanGUI(GUI);
                GUI.cards.add(p1,"payLoan");

            	GUI.cl.show(GUI.cards, "payLoan");
            }
        });
        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(GUI.data.getCurrentAccount().getAccountType().contentEquals("checking"))
            	GUI.cl.show(GUI.cards, "checking");
            	else
            		GUI.cl.show(GUI.cards, "saving");            }
        });
        bHome.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");
            }
        });
        bCollateral.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.data.getCurrentAccount().setCollateral(true);
            }
        });
}
    
    
}
