package Model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board implements BoardInterface {

	private int dice;
	private String[] week= {
			"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"
	};
	private Position[] pos=new Position[32];//gemizw ton pinaka sthn initialize kai analoga tou ti position einai to kathena bazw to antistoixo icon,(randomize mhn ksexasw)
	private String[][] tempDeal,tempMail;
	private DealCard[] dc=new DealCard[20];
	private MailCard[] mc=new MailCard[48];
	public int whose_turn(Player p1,Player p2) {
		return 0;
	}
	public void Roll_dice(Player p){
		Random r=new Random();
		
		 this.dice=r.nextInt(7 - 1) + 1;
		 p.setDice(dice);
	}
	
	
	public Position[] getPosition() {
		return this.pos;
	}
	public DealCard[] getDealCards() {
		return this.dc;
	}
	public MailCard[] getMailCards() {
		return this.mc;
	}
	public void initialize(Player p1,Player p2,Card c) {
		this.tempDeal=c.getDealCards();
		this.tempMail=c.getMailCards();
		pos[0]=new Position(0,"0","images/start.png");
		for(int i=0;i<8;i++) {
			if(i<4) {
				pos[i+1]=new MailCardPosition(i+1,week[i%7],"images/mc1.png");
			}else {
				pos[i+1]=new MailCardPosition(i+1,week[i%7],"images/mc2.png");
			}	
		}
		for(int i=8;i<13;i++) {
			pos[i+1]=new DealCardPosition(i+1,week[i%7],"images/deal.png");
		}
		pos[14]=new Sweepstakes(14,week[13%7],"images/sweep.png");
		pos[15]=new Sweepstakes(15,week[14%7],"images/sweep.png");
		pos[16]=new Lottery(16,week[15%7],"images/lottery.png");
		pos[17]=new Lottery(17,week[16%7],"images/lottery.png");
		pos[18]=new Lottery(18,week[17%7],"images/lottery.png");
		pos[19]=new Radio(19,week[18%7],"images/radio.png");
		pos[20]=new Radio(20,week[19%7],"images/radio.png");
		for(int i=20;i<26;i++) {
			pos[i+1]=new Buyer(i+1,week[i%7],"images/buyer.png");
		}
		pos[27]=new FamilyCasinoNight(27,week[26%7],"images/casino.png");
		pos[28]=new FamilyCasinoNight(28,week[27%7],"images/casino.png");
		pos[29]=new YardSale(29,week[28%7],"images/yard.png");
		pos[30]=new YardSale(30,week[29%7],"images/yard.png");
		pos[31]=new PayDayPosition(31,week[30%7],"images/pay.png");
		for (int i = 1; i <pos.length-1; i++) {
			int randomIndexToSwap = ThreadLocalRandom.current().nextInt(1,30 + 1);
				Position temp = pos[randomIndexToSwap];
				pos[randomIndexToSwap] = pos[i];
				pos[i] = temp;
		}
		for(int i=1;i<pos.length;i++) {
			pos[i].setNum(i);
			pos[i].setDay(week[(i-1)%7]);
		}
		
		for(int i=0;i<this.tempDeal.length;i++) {
			//System.out.println("MPIKA");
			dc[i]=new DealCard(Integer.parseInt(this.tempDeal[i][3]),Integer.parseInt(this.tempDeal[i][4]),this.tempDeal[i][2],"images/"+this.tempDeal[i][5]);
			//System.out.println(dc[i]);
		}
		for(int i=0;i<this.tempMail.length;i++) {
			if(i<8)
				mc[i]=new Advertisement(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			else if(i<16)
				mc[i]=new Bill(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			else if(i<24)
				mc[i]=new Charity(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			else if(i<32)
				mc[i]=new PayTheNeighbor(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			else if(i<40)
				mc[i]=new MadMoney(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			else
				mc[i]=new MoveTo(Integer.parseInt(this.tempMail[i][4]),"images/"+this.tempMail[i][5],this.tempMail[i][2],this.tempMail[i][3]);
			
		}
		/* Shuffle */
		for(int i=0;i<dc.length;i++) {
			int rand=ThreadLocalRandom.current().nextInt(0,19);
			DealCard temp= dc[rand];
			dc[rand]=dc[i];
			dc[i]=temp;
		}
		for(int i=0;i<mc.length;i++) {
			int rand=ThreadLocalRandom.current().nextInt(0,39);
			MailCard temp= mc[rand];
			mc[rand]=mc[i];
			mc[i]=temp;
		}
		
		
	}
	public void shuffle(Card c) {
		if(c instanceof MailCard) {
			for(int i=0;i<mc.length;i++) {
				int rand=ThreadLocalRandom.current().nextInt(0,39);
				MailCard temp= mc[rand];
				mc[rand]=mc[i];
				mc[i]=temp;
			}
		}else if(c instanceof DealCard) {
			for(int i=0;i<dc.length;i++) {
				int rand=ThreadLocalRandom.current().nextInt(0,19);
				DealCard temp= dc[rand];
				dc[rand]=dc[i];
				dc[i]=temp;
			}
		}
		
	}

	public int getDice() {
		return this.dice;
	}
	public void win(Player p1, Player p2) {
		if(p1.getEuros()>p2.getEuros()) {
			p1.setWin(true);
		}else if(p1.getEuros()<p2.getEuros()) {
			p2.setWin(true);
		}else {
			
		}
	}

	
}
