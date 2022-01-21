package Model;

public class MailCardPosition extends Position{

	public MailCardPosition(int num, String day, String icon) {
		super(num, day, icon);
	}

	
	public void performAction(Player p1,Player p2,MailCard mc,int who,Jackpot j) {
		if(!(mc instanceof Charity)) {
			System.out.println(mc.getClass());
			mc.action(p1, p2, mc, who);
		}else {		
			System.out.println(mc.getClass());
			if(who==1) {
				mc.action(p1,mc, j);
			}else {
				mc.action(p2, mc, j);
			}
		}
	}
	

}
