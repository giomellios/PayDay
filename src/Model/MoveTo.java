package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MoveTo extends MailCard{

	public MoveTo(int money, String icon, String message, String choice) {
		super(money, icon, message, choice);
	}
	
	public void action(Player p1,Player p2,MailCard mc,int who) {
		
		String[] op= {mc.getChoice()};
		JOptionPane.showOptionDialog(null, mc.getMessage(), "Move to buyer/deal cards position (not implemented)", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), op,0);
		
	}
}
