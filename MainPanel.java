import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;;


public class MainPanel extends JPanel implements ActionListener{
	GridBagLayout gridbag = new GridBagLayout();
	JButton TJ ;
	JButton CZ;
	JTextField XH,XM,SJH,QQ,YX,XB,NL,SS;
	
	public MainPanel(){
		super();
		GridBagConstraints constraints;
		setLayout(gridbag);
		
		JLabel XHLabel = new JLabel("学号: ");
		XH = new JTextField();
		JLabel XMLabel = new JLabel("姓名: ");
		XM = new JTextField();
		JLabel SJHLabel = new JLabel("手机: ");
		SJH = new JTextField();
		JLabel QQLabel = new JLabel("QQ: ");
		QQ = new JTextField();
		JLabel YXLabel = new JLabel("邮箱: ");
		YX = new JTextField();
		JLabel SSLabel = new JLabel("宿舍: ");
		SS = new JTextField();
		JLabel NLLabel = new JLabel("年龄: ");
		NL = new JTextField();
		JLabel XBLabel = new JLabel("性别: ");
		XB = new JTextField();
		TJ =  new JButton("添加信息");
		CZ = new JButton("查找信息");
		TJ.addActionListener(this);
		CZ.addActionListener(this);
		TJ.setEnabled(true);
		CZ.setEnabled(true);
		
		
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
		addComponent(TJ, 2, 4, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		addComponent(CZ, 6, 4, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.WEST);
		//TJ.addActionListener(this);
		//CZ.addActionListener(this);
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
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if(source==CZ){
			found();
		}
		else if (source == TJ){
			insert();
		}
	}
	public void found(){
		int n=0,j=0;
		String[] s = new String[8];
		s[0]=XH.getText();
		s[1]=XM.getText();
		s[2]=XB.getText();
		s[3]=NL.getText();
		s[4]=SJH.getText();
		s[5]=QQ.getText();
		s[6]=YX.getText();
		s[7]=SS.getText();
		for(int i=0;i<8;i++){
			
			if(s[i].length()>0){
				j=i;
				n++;
			}
		}
		if(n>1){
			JOptionPane.showMessageDialog(null,"查询时只能输入一个量！","提醒！",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CLASSMATE";
		try{
			Class.forName(JDriver);
			}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
			} 
		try{
			String user="sa";
			String password="as3167678";
			Connection con=DriverManager.getConnection(connectDB,user,password);
			Statement stmt=con.createStatement();
		
			ResultSet rs = null;
			if(j==0)
				rs=stmt.executeQuery("SELECT * FROM student where XH="+s[0]);
			else if(j==1)
				rs=stmt.executeQuery("SELECT * FROM student where XM="+s[1]);
			else if(j==4)
				rs=stmt.executeQuery("SELECT * FROM student where SJ="+s[4]);
			while(rs.next()){
				s[0]=rs.getString("XH");
				s[1]=rs.getString("XM");
				s[2]=rs.getString("XB");
				s[3]=rs.getString("NL");
				s[4]=rs.getString("SJ");
				s[5]=rs.getString("QQ");
				s[6]=rs.getString("YX");
				s[7]=rs.getString("SS");
				}
			stmt.close();
			con.close();
			CzFrame a = new CzFrame(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
			}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"信息不存在，请确认输入是否正确。","提醒！",
					JOptionPane.WARNING_MESSAGE);
			
			}
		
		}
	
	public void insert(){
		int p=0,q=0;
		String[] s = new String[8];
		s[0]=XH.getText();
		s[1]=XM.getText();
		s[2]=XB.getText();
		s[3]=NL.getText();
		s[4]=SJH.getText();
		s[5]=QQ.getText();
		s[6]=YX.getText();
		s[7]=SS.getText();
		for(p=0;p<8;p++){
			if(s[p].length()<1)
				q++;
		}
		if(q>0){
			JOptionPane.showMessageDialog(null,"添加信息不符合要求，请核对后再添加！","提醒！",
				JOptionPane.WARNING_MESSAGE);
			return;
			}
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=CLASSMATE";
		try{
			Class.forName(JDriver);
			}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
			} 
		try{
			String user="sa";
			String password="as3167678";
			Connection con=DriverManager.getConnection(connectDB,user,password);
			Statement stmt=con.createStatement();
			stmt.execute("insert into student values("+s[0]+","+s[1]+","+s[2]+","+s[3]+","
					+s[4]+","+s[5]+","+s[6]+","+s[7]+")");
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null,"添加成功！","提醒！",
					JOptionPane.WARNING_MESSAGE);
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"信息已存在！","提醒！",
					JOptionPane.WARNING_MESSAGE);
			
			}
	}
}


