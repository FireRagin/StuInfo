import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class CzPanel extends JPanel{
	GridBagLayout gridbag = new GridBagLayout();
	JButton GB;
	public CzPanel(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8){
		super();
		GridBagConstraints constraints;
		setLayout(gridbag);
		
		JLabel XHLabel = new JLabel("学号: ");
		JLabel XH = new JLabel(s1);
		JLabel XMLabel = new JLabel("姓名: ");
		JLabel XM = new JLabel(s2);
		JLabel SJHLabel = new JLabel("手机: ");
		JLabel SJH = new JLabel(s5);
		JLabel QQLabel = new JLabel("QQ: ");
		JLabel QQ = new JLabel(s6);
		JLabel YXLabel = new JLabel("邮箱: ");
		JLabel YX = new JLabel(s7);
		JLabel SSLabel = new JLabel("宿舍: ");
		JLabel SS = new JLabel(s8);
		JLabel NLLabel = new JLabel("年龄: ");
		JLabel NL = new JLabel(s4);
		JLabel XBLabel = new JLabel("性别: ");
		JLabel XB = new JLabel(s3);
		GB = new JButton("关闭");
		GB.setEnabled(true);
		
		addComponent(XHLabel, 0, 0, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(XH, 1, 0, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(XMLabel, 5, 0, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(XM, 6, 0, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(XBLabel, 0, 1, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(XB, 1, 1, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(NLLabel, 5, 1, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(NL, 6, 1, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(SJHLabel, 0, 2, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(SJH, 1, 2, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(QQLabel, 5, 2, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(QQ, 6, 2, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(YXLabel, 0, 3, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(YX, 1, 3, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(SSLabel, 5, 3, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(SS, 6, 3, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		addComponent(GB, 4, 4, 7, 1, 10, 100, 
				GridBagConstraints.NONE, GridBagConstraints.CENTER);
		
		
	}
	
	
	private void addComponent(Component component, int gridx, int gridy, int gridwidth, 
			int gridheight, int weightx, int weighty, int fill, int anchor){
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridheight = gridheight;
		constraints.gridwidth = gridwidth;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		gridbag.setConstraints(component, constraints);
		add(component);
		
	}

}