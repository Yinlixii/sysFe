package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.ATM;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class TransferGUI extends JPanel{
	private final String reg = "^[0-9]+(\\.[0-9]{1,4})?$";

    private JLabel lType = new JLabel("currency");
    private JComboBox cType = new JComboBox();
    private JLabel lID = new JLabel("ID");
    private	JTextField tID = new JTextField(); 
    private JLabel lAmount = new JLabel("amount");
    private	JTextField tAmount = new JTextField(); 
    private JButton bTransfer = new JButton("Transfer"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Transfer Page");
    private JLabel jError = new JLabel("");
    
    public TransferGUI(GUI GUI) {
    	cType.addItem("Dollar");
    	cType.addItem("Euro");
    	cType.addItem("CNY");
    	this.setLayout(null);
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(220,50,600,150);
        lType.setBounds(180,200,70,30);
        cType.setBounds(250,200,200,30);
        lAmount.setBounds(180,230,70,30);
        tAmount.setBounds(250,230,200,30);
        lID.setBounds(180,170,70,30);
        tID.setBounds(250,170,200,30);
        bTransfer.setBounds(250,260,100,60);
        bTransfer.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        jError.setVisible(false);
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        bTransfer.setBackground(new Color(0,115,207));
        bTransfer.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lType);
        this.add(cType);
        this.add(lID);
        this.add(tID);
        this.add(lAmount);
        this.add(tAmount);
        this.add(bTransfer);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jError);
        

        bTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tAmount.getText().length()>0&&tAmount.getText().length()<=10&&tAmount.getText().matches(reg)&&tAmount.getText().length()>0&&tAmount.getText().length()<=7&&tAmount.getText().matches(reg)&&GUI.data.sameID(tID.getText())&&Float.valueOf(tAmount.getText())<=GUI.data.getCurrentAccount().getBalance().get((String)cType.getSelectedItem()))
            	{
            		float amount = Float.valueOf(tAmount.getText());
            		String currency = (String)cType.getSelectedItem();
            		String ID = tID.getText();
            		GUI.data.transfer(ID,currency,amount);
            		GUI.cl.show(GUI.cards, "checking");
            	}else {
        	        jError.setBounds(50, 310, 500, 50);
            		jError.setText("should enter proper account and number less than 10000000 and have enough money");
            		jError.setVisible(true);
            	}
            }
        });

        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "checking");
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
