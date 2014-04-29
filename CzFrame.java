import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CzFrame extends JFrame implements ActionListener{
	CzPanel mPanel;
	public CzFrame(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8){
		super("²éÑ¯½á¹û");
		setSize(380, 140);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLookAndFeel();
		mPanel = new CzPanel(s1,s2,s3,s4,s5,s6,s7,s8);
		add(mPanel);
		mPanel.GB.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt){
		Object source = evt.getSource();
		if(source==mPanel.GB){
			this.dispose();
		}
	}
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			System.err.println("Could't use the system" + 
		"Look And Feel" + e);
		}
	}

}