package Model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MadMoney extends MailCard {

	public MadMoney(int money, String icon, String message, String choice) {
		super(money, icon, message, choice);
		// TODO Auto-generated constructor stub
	}

	public void action(Player p1, Player p2, MailCard mc, int who) {
		System.out.println("MPIKA PLHRWSE GEITONA 2");
		String[] op = { mc.getChoice() };
		JOptionPane.showOptionDialog(null, mc.getMessage(), "Pare Lefta apo ton geitona", JOptionPane.OK_OPTION,
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(mc.getIcon()), op, 0);
		if (who == 1) {
			p1.setEuros(p1.getEuros() + mc.getMoney());
			p2.setEuros(p2.getEuros() - mc.getMoney());
		} else {
			p1.setEuros(p1.getEuros() - mc.getMoney());
			p2.setEuros(p2.getEuros() + mc.getMoney());
		}
	}
}
