package GUI;
import Function.*;
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

public class CheckingGUI extends JPanel{
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
    private JButton jb1 = new JButton("Transfer");
    private JButton jb2 = new JButton("Transaction");
    private JButton jb3 = new JButton("Loan");
    private JButton jb4 = new JButton("Report");
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jID;
    private JLabel jl = new JLabel("Please choose the operation");
    
    public CheckingGUI(GUI GUI) {
    	this.setLayout(null);
    	jID = new JLabel("USERNAME: " + GUI.data.getCurrentAccount().getID());
    	jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));        jID.setFont(new Font("Arial",Font.BOLD, 20));
        jl.setBounds(180,90,600,50);
        jID.setBounds(200,0,400,75);
        jb1.setBounds(100,260,140,75);
        jb2.setBounds(100,170,140,75);
        jb3.setBounds(360,170,140,75);
        jb4.setBounds(360,260,140,75);
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
        jb4.setBackground(new Color(0,115,207));
        jb4.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.setBackground(Color.white);
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jID);


        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p1 = new TransferGUI(GUI);
                GUI.cards.add(p1,"transfer");
            	GUI.cl.show(GUI.cards, "transfer");

            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p2 = new TransactionGUI(GUI);
                GUI.cards.add(p2,"transaction");
            	GUI.cl.show(GUI.cards, "transaction");
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p3 = new LoanGUI(GUI);
                GUI.cards.add(p3,"loan");
            	GUI.cl.show(GUI.cards, "loan");
            }
        });
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ReportGUI a1 = new ReportGUI(GUI.data.customerViewReport());
            }
        });
        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "checkingLogin");
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
