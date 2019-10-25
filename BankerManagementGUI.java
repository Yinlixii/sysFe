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

public class BankerManagementGUI extends JPanel {
	private ATM data;
    private JButton jb1 = new JButton("Charge interest");
    private JButton jb2 = new JButton("Pay interest");
    private JButton jb3 = new JButton("New Report");
    private JButton jb4 = new JButton("Daily Report");
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jl = new JLabel("Please choose the operation");
    
    public BankerManagementGUI(GUI GUI) {
    	data = GUI.data;
    	data.managerGetReport();
    	this.setLayout(null);
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(180,90,600,50);
        jb1.setBounds(100,170,140,75);
        jb2.setBounds(100,260,140,75);
        jb3.setBounds(360,170,140,75);
        jb4.setBounds(360,260,140,75);
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        jb1.setBackground(new Color(0,115,207));
        jb1.setForeground(Color.white);
        jb2.setBackground(new Color(0,115,207));
        jb2.setForeground(Color.white);
        jb3.setBackground(new Color(0,115,207));
        jb3.setForeground(Color.white);
        jb4.setBackground(new Color(0,115,207));
        jb4.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	data.chargeInterest();
            	GUI.cl.show(GUI.cards, "bankerLogin");;
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	data.payInterest();
            	GUI.cl.show(GUI.cards, "bankerLogin");;
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ReportGUI a1 = new ReportGUI(data.managerViewNewReport());
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ReportGUI a1 = new ReportGUI(data.managerViewReport());
            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "bankerLogin");;
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
