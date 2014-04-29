import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{

	public MainFrame(){
		super("威武大软三通讯录   SQL版");
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