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

public class SavingGUI extends JPanel{
	private JPanel p2;
	private JPanel p3;
    private JButton jb2 = new JButton("Transaction");
    private JButton jb3 = new JButton("Loan");
    private JButton jb4 = new JButton("Report");
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jID;
    private JLabel jl = new JLabel("Please choose the operation");
    
    public SavingGUI(GUI GUI) {
    	this.setLayout(null);
    	jID = new JLabel("USERNAME: " + GUI.data.getCurrentAccount().getID());
        jID.setFont(new Font("Arial",Font.BOLD, 20));
        jID.setBounds(200,0,400,75);
        jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(180,90,600,50);
        jb2.setBounds(50,170,140,75);
        jb3.setBounds(230,170,140,75);
        jb4.setBounds(410,170,140,75);
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);

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
        this.add(jb2);
        this.add(jb3);
        this.add(jb4);
        this.add(bBack);
        this.add(bHome);
        this.add(jl);
        this.add(jID);


        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p2 = new TransactionGUI(GUI);
                GUI.cards.add(p2,"stransaction");
            	GUI.cl.show(GUI.cards, "stransaction");
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
