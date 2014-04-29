import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{

	public MainFrame(){
		super("���������ͨѶ¼   SQL��");
		setSize(700, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		MainPanel mPanel = new MainPanel();
		add(mPanel);
		
		setVisible(true);

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
	
	
	public static void main (String[] args) throws Exception{
		MainFrame frame = new MainFrame();
		
	}

}