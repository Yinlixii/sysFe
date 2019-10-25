package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Function.ATM;

public class ReportGUI extends JPanel{
	 JFrame frame=new JFrame("Report");
     JPanel jp=new JPanel();
     JTextArea jta;
     String text;
     public ReportGUI(String report) {
    	 text = report;
    	 jta =new JTextArea(report,18,40);
    	 frame.setSize(600,400);
    	 jta.setEditable(false);
    	 jta.setLineWrap(true);
         jta.setForeground(Color.WHITE);
         jta.setFont(new Font("Arial",Font.BOLD,16));
         jta.setBackground(Color.BLACK);
         JScrollPane jsp=new JScrollPane(jta);
         Dimension size=jta.getPreferredSize();
         jsp.setBounds(110,90,size.width,size.height);
         jp.add(jsp);
         jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         frame.add(jp);
         frame.setBackground(Color.LIGHT_GRAY);
         frame.setVisible(true);
 }
}
