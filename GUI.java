package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Function.*;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
	public ATM data = new ATM();
    private JFrame jf = new JFrame("Fancy Bank");
    public JPanel cards = new JPanel(new CardLayout());
    private JPanel jp = new JPanel();
    private BankerGUI p1;
    private CustomerGUI p2;
    private JButton jb1 = new JButton("Banker Account");
    private JButton jb2 = new JButton("Costumer Account");
    private JLabel jl = new JLabel("Fancy Bnak System");
    public CardLayout cl;
    
    public GUI() {
    	cl=(CardLayout)(cards.getLayout());
    	data = new ATM();
        jp.setLayout(null);
        jf.setSize(600,400);
        jl.setForeground(new Color(1,33,105));
        jl.setFont(new Font("Arial",Font.BOLD, 23));
        jl.setBounds(180,0,600,150);
        jb1.setBounds(50,200,200,100);
        jb2.setBounds(350,200,200,100);
        jp.setBackground(Color.white);
        jb1.setBackground(new Color(0,115,207));
        jb1.setForeground(Color.white);
        jb1.setFocusPainted(false);
        jb1.setFont(new Font("Arial",Font.BOLD, 16));
        jb2.setBackground(new Color(0,115,207));
        jb2.setForeground(Color.white);
        jb2.setFocusPainted(false);
        jb2.setFont(new Font("Arial",Font.BOLD, 16));
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jl);
        jf.add(cards);
        jf.setVisible(true);
        cards.add(jp,"home");

        cl.show(cards,"home");
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	p1 = new BankerGUI(update());

                cards.add(p1,"bankerLogin");

            	cl.show(cards, "bankerLogin");
            }
        });
        jb2.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
            	p2 = new CustomerGUI(update());

                cards.add(p2,"customer");

            	cl.show(cards, "customer");
            }
        });
    }
    public GUI update()
    {
    	return this;
    }
    

    
}