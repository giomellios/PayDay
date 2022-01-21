package Model;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import View.View;

public class Player implements PlayerInterface {

	private int euros;
	private Card c;
	private int dealCards;
	private int loanNum;
	private boolean win;
	private int pawn_pos;
	private int turn;
	private int month;
	private int dice;
	private String name;
	private int bills;// counter for bills, the bills in euros will be caclulated with a method
	private ArrayList<DealCard> deal=new ArrayList<DealCard>();
	private ArrayList<MailCard> mail=new ArrayList <MailCard>();
	
	public Player(int euros, String name) {
		this.loanNum = 0;
		this.month = 1;
		this.name = name;
		this.pawn_pos = 0;
		this.dealCards = 0;
		this.euros = euros;
		this.bills=0;
		this.win = false;
	}

	public ArrayList<DealCard> getDeal(){
		return this.deal;
	}
	public ArrayList<MailCard> getMail(){
		return this.mail;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void setBills(int bills) {
		this.bills=bills;
	}
	public int getBills() {
		return this.bills;
	}
	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return this.month;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public int getDice() {
		return this.dice;
	}

	public void setPawnPos(int pawn) {
		this.pawn_pos = pawn;
	}

	public int getPawnPos() {
		return this.pawn_pos;
	}

	public String getName() {
		return this.name;
	}

	public int getTurn() {
		return this.turn;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean getWin() {
		return this.win;
	}

	public void setEuros(int euros) {
		this.euros = euros;
	}

	public int getEuros() {
		return this.euros;
	}

	public int getLoan() {
		return this.loanNum;
	}

	public void setLoan(int loan) {
		this.loanNum = loan;
	}

	public int getDealCards() {
		return this.dealCards;
	}

	public void setDealCards(int deal) {
		this.dealCards = deal;
	}

	public void SundayFootballDay(int diceNumber, Player p, View v, int who) {
		String[] options = { "Nikh Barcelona", "Isopalia", "Nikh Real", "Den thelw na kanw problepsi" };
		ImageIcon icon = new ImageIcon("images/Barcelona_Real.jpg");
		int a = JOptionPane.showOptionDialog(null, "Stoiximatise 500 euro gia to derby Barcelona-Real",
				"Podosfairikos agwnas Kyriakhs", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				icon, options, 0);
		if (a != 3) {
			if (a == 0 && (diceNumber == 1 || diceNumber == 2)) {
				p.setEuros(p.getEuros() + 500);
				v.setEuros(p, who);
				JOptionPane.showMessageDialog(null, "Swsth Problepsi!!! Barcelona-Real 2-0. Kerdises 1000 euro!",
						"Podosfairikos agwnas Kyriakhs", JOptionPane.INFORMATION_MESSAGE, icon);
			} else if (a == 1 && (diceNumber == 3 || diceNumber == 4)) {
				p.setEuros(p.getEuros() + 500);
				v.setEuros(p, who);
				JOptionPane.showMessageDialog(null, "Swsth Problepsi!!! Barcelona-Real 2-2. Kerdises 1000 euro!",
						"Podosfairikos agwnas Kyriakhs", JOptionPane.INFORMATION_MESSAGE, icon);

			} else if (a == 2 && (diceNumber == 5 || diceNumber == 6)) {
				p.setEuros(p.getEuros() + 500);
				v.setEuros(p, who);
				JOptionPane.showMessageDialog(null, "Swsth Problepsi!!! Barcelona-Real 0-2. Kerdises 1000 euro!",
						"Podosfairikos agwnas Kyriakhs", JOptionPane.INFORMATION_MESSAGE, icon);
			} else {
				p.setEuros(p.getEuros() - 500);
				v.setEuros(p, who);
				JOptionPane.showMessageDialog(null, "Lathos Problepsi :(.To zari efere "+diceNumber+" Exases 500 euro :(",
						"Podosfairikos agwnas Kyriakhs", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}else {
			JOptionPane.showMessageDialog(null, "OK, To paixnidi tha synexistei kanonika",
					"Podosfairikos agwnas Kyriakhs",
					JOptionPane.INFORMATION_MESSAGE,
					icon);
		}
	}
	public void showDealCards() {
		System.out.println("MPIKA");
		for(int i=0;i<this.deal.size();i++) {
			JOptionPane.showMessageDialog(null, this.deal.get(i).getMessage()+"\n"+this.deal.get(i).getCost()+"\n"+this.deal.get(i).getValue(), "Oi kartes symfwnias sou", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.deal.get(i).getIcon()));
		}
	}
	
	public void Crypto(int diceNumber, Player p, View v, int who) {
		String[] options= {"Pontare sto kryptonomisma","Parablepse to kryptonomisma"};
		ImageIcon icon=new ImageIcon("images/crypto.jpeg");
		int a=JOptionPane.showOptionDialog(null,
				"Pontarisma se cryptonomismata",
				"Crypto Thursday",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				icon,
				options, 
				0);
		if(a==0 && (diceNumber==1 || diceNumber==2)) {
			p.setEuros(p.getEuros() - 300);
			v.setEuros(p, who);
			JOptionPane.showMessageDialog(null, "To bitcoin epese 2% :(. Xaneis 300 euro", "Pontarisma se cryptonomismata",JOptionPane.INFORMATION_MESSAGE, icon);
		}else if(a==0 && (diceNumber==3 || diceNumber==4)) {
			JOptionPane.showMessageDialog(null, "To ethereum emeine stathero, pairneis to pontarisma pisw", "Pontarisma se cryptonomismata",JOptionPane.INFORMATION_MESSAGE, icon);
		}else if(a==0 && (diceNumber==5 || diceNumber==6)) {
			p.setEuros(p.getEuros() + 300);
			v.setEuros(p, who);
			JOptionPane.showMessageDialog(null, "To dogecoin anebike 14.2%. Kerdizeis ta dipla!", "Pontarisma se cryptonomismata",JOptionPane.INFORMATION_MESSAGE, icon);
		}else if(a==1) {
			JOptionPane.showMessageDialog(null, "OK, to paixnidi tha synexistei kanonika", "Pontarisma se cryptonomismata", JOptionPane.INFORMATION_MESSAGE, icon);
		}
	}


}
