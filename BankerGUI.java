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

public class BankerGUI extends JPanel {
	private ATM data;
	private JPanel p1;
    private JLabel lPwd = new JLabel("password");
    private	JPasswordField tPwd = new JPasswordField(18);//max 18
    private JButton bLogin = new JButton("Login"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Banker Account Login");
    private JLabel jErrorLogin = new JLabel("password error!");
    
    public BankerGUI(GUI GUI) {
    	data = GUI.data;
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(180,50,600,150);
        lPwd.setBounds(180,200,70,30);
        tPwd.setBounds(250,200,200,30);
        bLogin.setBounds(280,250,100,60);
        jErrorLogin.setBounds(290, 310, 100, 50);
        bLogin.setFont(new Font("Arial",Font.BOLD, 10));
        jErrorLogin.setVisible(false);
        jErrorLogin.setForeground(Color.red);
        jErrorLogin.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bLogin.setBackground(new Color(0,115,207));
        bLogin.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lPwd);
        this.add(tPwd);
        this.add(bLogin);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jErrorLogin);
        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p1=new BankerManagementGUI(GUI);
                GUI.cards.add(p1,"bankerManagement");

            	String pwd = String.valueOf(tPwd.getPassword());
            	if(data.bankerLogin(pwd)) {
            		GUI.cl.show(GUI.cards, "bankerManagement");
                }else {
                	jErrorLogin.setVisible(true);
                }
            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");;
            }
        });
        bHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");;
            }
        });
}
    

}
