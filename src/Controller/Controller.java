package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.*;
import View.View;

public class Controller implements ActionListener {
	/**
	 * Here I will combinate the Model and the View in order to make my program
	 * work(also, here I will make the main method of the program).
	 */
	Board b = new Board();
	Jackpot j = new Jackpot();
	Player p1 = new Player(3500, "Player1");
	Player p2 = new Player(3500, "Player2");
	View v = new View(p1, p2, b);
	Position[] pos = new Position[32];
	boolean move = true;

	public Controller() {
		pos = b.getPosition();
		Random random = new Random();
		int t = random.nextInt(3 - 1) + 1;
		if (t == 1) {
			p1.setTurn(1);
			p2.setTurn(0);
			v.getRollDice(2).setEnabled(false);
		} else {
			p1.setTurn(0);
			p2.setTurn(1);
			v.getRollDice(1).setEnabled(false);
		}
		String m;
		do {
			m=JOptionPane.showInputDialog("How many months do you want the game to last? Enter a number 1-3");
		}while(Integer.parseInt(m)<1 || Integer.parseInt(m)>3);
		v.getRollDice(1).addActionListener(this);
		v.getRollDice(2).addActionListener(this);
		v.getEndTurn(1).addActionListener(this);
		v.getEndTurn(2).addActionListener(this);
		/// edw tha bazw ston xrhsth na dialeksei tous mhnes
		while (p1.getWin() != true && p2.getWin() != true) {
			// se auto to loop mporw na balw oti thelw na ekteleitai kata th diarkeia tou
			// game
			// System.out.println(p1.getTurn()+" "+p2.getTurn());
			
			if (p1.getMonth() == 3 /*&&p1.getPawnPos() == 31*/) {
				System.out.println("AINTES AMAN");
			}
/*			if (p2.getTurn() == 1) {
				if (b.getDice() == 6) {
					p2.setEuros(p2.getEuros() + j.getAvailableEuro());
					v.setEuros(p2,2);
					j.setAvailableEuro(0);
				}
			}*/

		}

	}

	public static void main(String[] args) {
		Controller c = new Controller();
	}

	public void actionPerformed(ActionEvent e) {
		String n1,n2;
		if (e.getSource() == v.getRollDice(1)) {
			b.Roll_dice(p1);
			v.dice(b.getDice(), 1); // visual apeikonisi
			// actions ...
			if (b.getDice() == 6 && j.getAvailableEuro()!=0) {
				JOptionPane.showMessageDialog(null, "Congratulations! You got the Jackpot: "+j.getAvailableEuro()+" Euros added.");
				p1.setEuros(p1.getEuros() + j.getAvailableEuro());
				v.setEuros(p1,1);
				System.out.println(p1.getEuros());
				j.setAvailableEuro(0);
				v.setJack(0);
			}
			p1.setPawnPos(p1.getPawnPos() + p1.getDice());
			if(p1.getPawnPos()<=6) {
				v.setPawn1((p1.getPawnPos()%7)*85, 150);
				System.out.println("EPIPEDO 1");
			}else if(p1.getPawnPos()<=13) {
				v.setPawn1((p1.getPawnPos()%7)*85, 265);
				System.out.println("EPIPEDO 2");
			}else if(p1.getPawnPos()<=20) {
				v.setPawn1((p1.getPawnPos()%7)*85, 375);
				System.out.println("EPIPEDO 3");
			}else if(p1.getPawnPos()<=27) {
				v.setPawn1((p1.getPawnPos()%7)*85, 485);
				System.out.println("EPIPEDO 4");
			}else if(p1.getPawnPos()<31) {
				v.setPawn1((p1.getPawnPos()%7)*85, 595);
				System.out.println("EPIPEDO 5");
			}else if(p1.getPawnPos()<=37){
				v.setPawn1(3*85, 595);
				p1.setPawnPos(0);
			}
			System.out.println("THESI: "+p1.getPawnPos()+" ZARIA: "+b.getDice()+" MHNAS: "+p1.getMonth());
			if (p1.getPawnPos() > 31) {
				p1.setEuros(p1.getEuros() + 3500);
				p1.setPawnPos(0);
				p1.setMonth(p1.getMonth()+1);
				v.setEuros(p1,1);
				//v.setPawn1(x, y);
			}
			if (pos[p1.getPawnPos()] instanceof Sweepstakes) {
				b.Roll_dice(p1);
				v.dice(b.getDice(), 1);
				JOptionPane.showMessageDialog(null,
						"Sweepstakes Position: The dice rolled automatically and got a "+b.getDice());
				pos[p1.getPawnPos()].performAction(p1, b.getDice());
				v.setEuros(p1,1);
			} else if (pos[p1.getPawnPos()] instanceof Lottery) {
				do {
					n1=JOptionPane.showInputDialog("PLAYER: "+p1.getName()+" Enter a number 1-6 ");
					n2=JOptionPane.showInputDialog("PLAYER: "+p2.getName()+" Enter a number 1-6 ");
					
				}while((Integer.parseInt(n1)<1 || Integer.parseInt(n1)>6) || (Integer.parseInt(n2)<1 || Integer.parseInt(n2)>6) || (Integer.parseInt(n1)==Integer.parseInt(n2)));
				do {
					System.out.println(Integer.parseInt(n1)+" "+Integer.parseInt(n2)+" "+b.getDice());
					b.Roll_dice(p1);
					v.dice(b.getDice(), 1);
					JOptionPane.showMessageDialog(null, "Lottery Position: The dice rolled automatically and got a "+b.getDice());	
				}while(b.getDice()!=Integer.valueOf(n1) && b.getDice()!=Integer.valueOf(n2));
				if(b.getDice()==Integer.parseInt(n1)) {
					pos[p1.getPawnPos()].performAction(p1, b.getDice());
					v.setEuros(p1,1);
				}else {
					pos[p1.getPawnPos()].performAction(p2, b.getDice());
					v.setEuros(p2,2);
				}
			}else if(pos[p1.getPawnPos()] instanceof Radio) {
				b.Roll_dice(p1);
				b.Roll_dice(p2);
				do {
					JOptionPane.showMessageDialog(null,"Radio Position: The dice will roll automatically for each Player and the biggest roll wins the money!");
					b.Roll_dice(p1);
					JOptionPane.showMessageDialog(null,
							"The dice rolled automatically for Player " + p1.getName() + " and got a " + p1.getDice());
					v.dice(p1.getDice(), 1);
					b.Roll_dice(p2);
					JOptionPane.showMessageDialog(null,
							"The dice rolled automatically for Player " + p2.getName() + "and got a " + p2.getDice());
					v.dice(p2.getDice(), 2);
					pos[p1.getPawnPos()].performAction(p1, p2, b.getDice());
				} while (p1.getDice() == p2.getDice());
				v.setEuros(p1, 1);
				v.setEuros(p2, 2);
			}else if (pos[p1.getPawnPos()] instanceof FamilyCasinoNight) {
				if(b.getDice()%2==1) {
					j.setAvailableEuro(j.getAvailableEuro()+500);
					v.setJack(j.getAvailableEuro());
				}
				pos[p1.getPawnPos()].performAction(p1, b.getDice());
				JOptionPane.showMessageDialog(null, "FAMILYCASINONIGHT");
				v.setEuros(p1, 1);
			}
		} else if (e.getSource() == v.getRollDice(2)) {
			b.Roll_dice(p2);
			v.dice(b.getDice(), 2); // visual apeikonisi
			// actions ...
			if (p2.getPawnPos() > 31) {
				p2.setPawnPos(31);
				p2.setEuros(p2.getEuros() + 3500);
				p2.setPawnPos(0);
				v.setEuros(p2,2);
			}
			// v.getRollDice(1).setEnabled(false);
			System.out.println(p2.getPawnPos());
		} else if (e.getSource() == v.getEndTurn(1)) {
			p1.setTurn(0);
			p2.setTurn(1);
			v.getRollDice(2).setEnabled(true);
			v.getRollDice(1).setEnabled(false);
		} else if (e.getSource() == v.getEndTurn(2)) {
			p1.setTurn(1);
			p2.setTurn(0);
			v.getRollDice(1).setEnabled(true);
			v.getRollDice(2).setEnabled(false);
		}

	}

}
