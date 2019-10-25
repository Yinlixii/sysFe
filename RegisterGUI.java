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

public class RegisterGUI extends JPanel{
	private final String reg = "^([0-9]+)";
	private ATM data;
	private int type;
    private JLabel lUsername = new JLabel("Username");
    private	JTextField tUsername = new JTextField();//max 18
    private JLabel lPwd = new JLabel("password");
    private	JPasswordField tPwd = new JPasswordField(18);//max 18
    private JLabel lPhone = new JLabel("Phone");
    private	JTextField tPhone = new JTextField();//max 18
    private JButton bRegister = new JButton("Register"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Account Register");
    private JLabel jError = new JLabel("");
    
    public RegisterGUI(GUI GUI, int iType) {
    	data = GUI.data;
    	type = iType;
    	this.setLayout(null);
    	this.setBackground(Color.white);
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(220,0,600,80);
        lUsername.setBounds(180,90,70,40);
        tUsername.setBounds(250,90,200,40);
        lPwd.setBounds(180,140,70,40);
        tPwd.setBounds(250,140,200,40);
        lPhone.setBounds(180,190,70,40);
        tPhone.setBounds(250,190,200,40);
        bRegister.setBounds(280,260,100,60);
        jError.setBounds(290, 310, 150, 50);
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        bRegister.setFont(new Font("Arial",Font.BOLD, 10));
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bRegister.setBackground(new Color(0,115,207));
        bRegister.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.add(lUsername);
        this.add(tUsername);
        this.add(lPwd);
        this.add(tPwd);
        this.add(lPhone);
        this.add(tPhone);
        this.add(bRegister);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jError);
        jError.setVisible(false);
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String username = tUsername.getText();
            	String pwd = String.valueOf(tPwd.getPassword());
            	String phone = tPhone.getText();
            	if(!String.valueOf(tPwd.getPassword()).equals("")&&!tPhone.getText().equals("")||!tUsername.getText().equals(""))
            	{
            		if(username.length()<=10&&username.matches(reg)&&phone.length()<=10&&phone.matches(reg))
            		{
            			if(!GUI.data.sameID(username)) 
            			{
            				if(type == 1) {
            					data.createNewCheckingAccount(username, pwd, phone);
            					GUI.cl.show(GUI.cards, "checkingLogin");
            				}else {
            					data.createNewSavingAccount(username, pwd,phone);
            					GUI.cl.show(GUI.cards, "savingLogin");
            				}
            			}else {
            				jError.setText("username is occupied");
            				jError.setVisible(true);
            			}
            		}else {
            	        jError.setBounds(150, 310, 350, 50);
            			jError.setText("username and phone should be numbers less than 10 digit");
        				jError.setVisible(true);
            		}
            	}else {
            		jError.setText("all lines are required");
        			jError.setVisible(true);
            	}
            }
        });
        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(getType()==1) {
                	GUI.cl.show(GUI.cards, "checkingLogin");
            	}
            	else {
                	GUI.cl.show(GUI.cards, "savingLogin");
            	}
            }
        });
        bHome.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");
            }
        });
}
    
    public int getType() {
    	return type;
    }
}
