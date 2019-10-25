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

public class CheckingLoginGUI extends JPanel{
	private JPanel p1;
	private JPanel p2;
    private JLabel lUsername = new JLabel("Username");
    private	JTextField tUsername = new JTextField();
    private JLabel lPwd = new JLabel("password");
    private	JPasswordField tPwd = new JPasswordField(18);//max 18
    private JButton bLogin = new JButton("Login"); 
    private JButton bRegister = new JButton("Register"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Checking Account Login");
    private JLabel jErrorLogin = new JLabel("password error!");
    
    public CheckingLoginGUI(GUI GUI) {
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));        jl.setBounds(180,50,600,150);
        lUsername.setBounds(180,170,70,30);
        tUsername.setBounds(250,170,200,30);
        lPwd.setBounds(180,200,70,30);
        tPwd.setBounds(250,200,200,30);
        bLogin.setBounds(230,250,100,60);
        bRegister.setBounds(340,250,100,60);
        jErrorLogin.setBounds(290, 310, 100, 50);
        bLogin.setFont(new Font("Arial",Font.BOLD, 10));
        bRegister.setFont(new Font("Arial",Font.BOLD, 10));
        jErrorLogin.setVisible(false);
        jErrorLogin.setForeground(Color.red);
        jErrorLogin.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bLogin.setBackground(new Color(0,115,207));
        bLogin.setForeground(Color.white);
        bRegister.setBackground(new Color(0,115,207));
        bRegister.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lUsername);
        this.add(tUsername);
        this.add(lPwd);
        this.add(tPwd);
        this.add(bLogin);
        this.add(bRegister);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jErrorLogin);

        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!String.valueOf(tPwd.getPassword()).equals("")&&!tUsername.getText().equals(""))
            	{
            		String pwd = String.valueOf(tPwd.getPassword());
            		String username = tUsername.getText();
            		if(!GUI.data.getCustomerAccounts().isEmpty()&&GUI.data.CustomerLogin(username,pwd,"checking")) {
            			p1 = new CheckingGUI(GUI);
            			GUI.cards.add(p1,"checking");
            			GUI.cl.show(GUI.cards, "checking");
            		}else {
            			jErrorLogin.setText("password error!");
            			jErrorLogin.setVisible(true);
            		}
            	}
            	else {
            		jErrorLogin.setText("Please enter");
                	jErrorLogin.setVisible(true);

            	}
            }
        });
        bRegister.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	p2 = new RegisterGUI(GUI,1);
                GUI.cards.add(p2,"register");
            	GUI.cl.show(GUI.cards, "register");
            }
        });
        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "customer");
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
