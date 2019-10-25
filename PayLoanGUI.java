package GUI;
import Function.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Function.ATM;

public class PayLoanGUI extends JPanel{
	private final String reg = "^[0-9]+(\\.[0-9]{1,4})?$";

    private JTextArea jta;
    private JLabel lID = new JLabel("ID for paying");
    private	JTextField tID = new JTextField(); 
    private JButton bPayLoan = new JButton("PayLoan"); 
    private JButton bBack = new JButton("Back");
    private JButton bHome = new JButton("Home");
    private JLabel jError = new JLabel("");

    public PayLoanGUI(GUI GUI) {
    	this.setLayout(null);
   	 	jta =new JTextArea(GUI.data.getCurrentAccount().getLoanReport(),5,30);
   	 	jta.setSize(400, 100);
   	 	jta.setEditable(false);
   	 	jta.setLineWrap(true);
        jta.setForeground(Color.WHITE);
        jta.setFont(new Font("Arial",Font.BOLD,16));
        jta.setBackground(Color.BLACK);
        jError.setVisible(false);
        jError.setForeground(Color.red);
        jError.setFont(new Font("Arial",Font.BOLD, 12));
        JScrollPane jsp=new JScrollPane(jta);
        jsp.setBounds(110,90,400,100);
        lID.setBounds(120,200,100,30);
        tID.setBounds(250,200,200,30);
        bPayLoan.setBounds(340,250,100,60);
        bPayLoan.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setFont(new Font("Arial",Font.BOLD, 10));
        bHome.setFont(new Font("Arial",Font.BOLD, 10));
        bBack.setBounds(10,10,70,60);
        bHome.setBounds(100,10,70,60);
        bPayLoan.setBackground(new Color(0,115,207));
        bPayLoan.setForeground(Color.white);
        bBack.setBackground(new Color(0,115,207));
        bBack.setForeground(Color.white);
        bHome.setBackground(new Color(0,115,207));
        bHome.setForeground(Color.white);
        this.add(jsp);
        this.add(lID);
        this.add(tID);
        this.add(bPayLoan);
        this.add(bBack);
        this.add(bHome);
        this.add(jError);

        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bPayLoan.addActionListener(new ActionListener() {       
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(tID.getText().length()>0&&tID.getText().length()<=7&&tID.getText().matches(reg)&&GUI.data.getCurrentAccount().haveLoan(Integer.valueOf(tID.getText()))&&GUI.data.getCurrentAccount().getLoanByID(Integer.valueOf(tID.getText())).getMoney().getAmount()<=GUI.data.getCurrentAccount().getBalance().get(GUI.data.getCurrentAccount().getLoanByID(Integer.valueOf(tID.getText())).getMoney().getType()))
            	{
            	jError.setVisible(false);

            	int ID = Integer.valueOf(tID.getText());
            	GUI.data.PayLoan(ID);
            	GUI.cl.show(GUI.cards, "loan");

            	}else {
        	        jError.setBounds(170, 310, 500, 50);
            		jError.setText("please enter corresponding Loan ID");
            		jError.setVisible(true);
            	}
            }
        });
        bBack.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent e) {
            	GUI.cl.show(GUI.cards, "loan");

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
