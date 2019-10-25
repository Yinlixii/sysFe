package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

import Function.ATM;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JPanel{
	private ATM data;
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
    private JButton jb1 = new JButton("Checking Account");
    private JButton jb2 = new JButton("Saving Account");
    private JButton jb3 = new JButton("Close Account");
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Please choose the type of the account you want to operate");
    
    public CustomerGUI(GUI GUI) {
    	data = GUI.data;
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 16));
        jl.setBounds(50,90,600,50);
        jb1.setBounds(50,170,160,100);
        jb2.setBounds(225,170,160,100);
        jb3.setBounds(400,170,160,100);

        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        jb1.setBackground(new Color(0,115,207));
        jb1.setForeground(Color.white);
        jb2.setBackground(new Color(0,115,207));
        jb2.setForeground(Color.white);
        jb3.setBackground(new Color(0,115,207));
        jb3.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);

        this.add(bBack);
        this.add(bHome);
        this.add(jl);


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jp1 = new CheckingLoginGUI(GUI);
                GUI.cards.add(jp1,"checkingLogin");

            	GUI.cl.show(GUI.cards, "checkingLogin");
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jp2 = new SavingLoginGUI(GUI);
                GUI.cards.add(jp2,"savingLogin");
            	GUI.cl.show(GUI.cards, "savingLogin");
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jp3 = new CloseAccountGUI(GUI);
                GUI.cards.add(jp3,"closeAccount");
            	GUI.cl.show(GUI.cards, "closeAccount");
            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");
            }
        });
        bHome.addActionListener(new ActionListener() {        // 监听器，用于监听点击事件
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "home");
            }
        });
    }
    
}
