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

public class CloseAccountGUI extends JPanel {
	private final String reg = "^([0-9]+)";

	private ATM data;
	private JPanel p1;
    private JLabel lUsername = new JLabel("Username");
    private	JTextField tUsername = new JTextField();
    private JButton bClose = new JButton("Close"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel(" Account Close");
    private JLabel jError = new JLabel("plase make sure the username is correct and have enought close fee");
    
    public CloseAccountGUI(GUI GUI) {
    	data = GUI.data;
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));        jl.setBounds(240,50,600,150);
        lUsername.setBounds(180,200,70,30);
        tUsername.setBounds(250,200,200,30);
        bClose.setBounds(280,250,100,60);
        jError.setBounds(120, 310, 400, 50);
        bClose.setFont(new Font("Arial",Font.BOLD, 10));
        jError.setVisible(false);
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bClose.setBackground(new Color(0,115,207));
        bClose.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(lUsername);
        this.add(tUsername);
        this.add(bClose);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jError);
        bClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		if(tUsername.getText().length()>0&&tUsername.getText().length()<=10&&tUsername.getText().matches(reg)&&GUI.data.sameID(tUsername.getText()))
        		{
        			String username = tUsername.getText();
        			if(GUI.data.closeAccount(username)) {
        				GUI.cl.show(GUI.cards, "customer");
        				jError.setVisible(false);
        			}else {
        				jError.setVisible(true);
        			}
                }else {
                	jError.setVisible(true);
                }
            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "customer");;
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
