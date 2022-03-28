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
	Card c = new Card();
	Jackpot j = new Jackpot();
	Player p1 = new Player(3500, "Player 1");
	Player p2 = new Player(3500, "Player 2");
	View v = new View(p1, p2, b, c);
	Position[] pos = new Position[32];
	DealCard[] dc = new DealCard[20];
	public int dcCount = 0, mcCount = 0;
	MailCard[] mc = new MailCard[48];
	String month;

	public Controller() {
		pos = b.getPosition();
		dc = b.getDealCards();
		mc = b.getMailCards();
		Random random = new Random();
		int t = random.nextInt(3 - 1) + 1;
		if (t == 1) {
			p1.setTurn(1);
			p2.setTurn(0);
			v.getRollDice(2).setEnabled(false);
			v.getEndTurn(2).setEnabled(false);
		} else {
			p1.setTurn(0);
			p2.setTurn(1);
			v.getRollDice(1).setEnabled(false);
			v.getEndTurn(1).setEnabled(false);
		}
		do {
			month = JOptionPane.showInputDialog("How many months do you want the game to last? Enter a number 1-3");
		} while (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 3);
		v.getRollDice(1).addActionListener(this);
		v.getRollDice(2).addActionListener(this);
		v.getEndTurn(1).addActionListener(this);
		v.getEndTurn(2).addActionListener(this);
		v.getDealCards(1).addActionListener(this);
		v.getDealCards(2).addActionListener(this);
		v.getLoan(1).addActionListener(this);
		v.getLoan(2).addActionListener(this);
	}

	public static void main(String[] args) {
		Controller c = new Controller();
	}

	public void actionPerformed(ActionEvent e) {
		String n1, n2;
		if((p2.getMonth()>Integer.parseInt(month) && p2.getPawnPos()==0) && (p1.getMonth()>Integer.parseInt(month) && p1.getPawnPos()==0)) {
			b.win(p1, p2);
			if(p1.getWin())
				JOptionPane.showMessageDialog(null, "Player "+p1.getName()+" Won!");
			else if(p2.getWin())
				JOptionPane.showMessageDialog(null, "Player "+p2.getName()+" Won!");
		}
		if (e.getSource() == v.getRollDice(1)) {
			if (p1.getMonth() <= Integer.parseInt(month)) {
				b.Roll_dice(p1);
				v.dice(b.getDice(), 1);
				if (b.getDice() == 6 && j.getAvailableEuro() != 0) {
					JOptionPane.showMessageDialog(null,
							"Congratulations! You got the Jackpot: " + j.getAvailableEuro() + " Euros added.");
					p1.setEuros(p1.getEuros() + j.getAvailableEuro());
					v.setEuros(p1, 1);
					j.setAvailableEuro(0);
					v.setJack(0);
				}
				p1.setPawnPos(p1.getPawnPos() + p1.getDice());
				if (p1.getPawnPos() <= 6) {
					v.setPawn1((p1.getPawnPos() % 7) * 85, 150);
				} else if (p1.getPawnPos() <= 13) {
					v.setPawn1((p1.getPawnPos() % 7) * 85, 265);
				} else if (p1.getPawnPos() <= 20) {
					v.setPawn1((p1.getPawnPos() % 7) * 85, 375);
				} else if (p1.getPawnPos() <= 27) {
					v.setPawn1((p1.getPawnPos() % 7) * 85, 485);
				} else if (p1.getPawnPos() < 31) {
					v.setPawn1((p1.getPawnPos() % 7) * 85, 595);
				} else if (p1.getPawnPos() <= 40) {
					v.setPawn1(3 * 85, 595);
					p1.setPawnPos(32);
				}
				if (p1.getPawnPos() >=31) {
					if(p1.getMonth()!= Integer.parseInt(month))
						JOptionPane.showMessageDialog(null, "You are going to the next month...");
					p1.setPawnPos(31);
					pos[p1.getPawnPos()].performAction(p1, p1.getDice());
					v.setBills(p1, 1);
					v.setLoan(p1, 1);
					v.setEuros(p1, 1);
					p1.setPawnPos(0);
				}
				if (pos[p1.getPawnPos()] instanceof Sweepstakes) {
					b.Roll_dice(p1);
					v.dice(b.getDice(), 1);
					JOptionPane.showMessageDialog(null,
							"Sweepstakes Position: The dice rolled automatically and got a " + b.getDice());
					pos[p1.getPawnPos()].performAction(p1, b.getDice());
					v.setEuros(p1, 1);
				} else if (pos[p1.getPawnPos()] instanceof Lottery) {
					do {
						n1 = JOptionPane.showInputDialog("PLAYER: " + p1.getName() + " Enter a number 1-6 ");
						n2 = JOptionPane.showInputDialog("PLAYER: " + p2.getName() + " Enter a number 1-6 ");

					} while ((Integer.parseInt(n1) < 1 || Integer.parseInt(n1) > 6)
							|| (Integer.parseInt(n2) < 1 || Integer.parseInt(n2) > 6)
							|| (Integer.parseInt(n1) == Integer.parseInt(n2)));
					do {
						b.Roll_dice(p1);
						v.dice(b.getDice(), 1);
						JOptionPane.showMessageDialog(null,
								"Lottery Position: The dice rolled automatically and got a " + b.getDice());
					} while (b.getDice() != Integer.valueOf(n1) && b.getDice() != Integer.valueOf(n2));
					if (b.getDice() == Integer.parseInt(n1)) {
						pos[p1.getPawnPos()].performAction(p1, b.getDice());
						v.setEuros(p1, 1);
					} else {
						pos[p1.getPawnPos()].performAction(p2, b.getDice());
						v.setEuros(p2, 2);
					}
				} else if (pos[p1.getPawnPos()] instanceof Radio) {
					b.Roll_dice(p1);
					b.Roll_dice(p2);
					do {
						JOptionPane.showMessageDialog(null,
								"Radio Position: The dice will roll automatically for each Player and the biggest roll wins the money!");
						b.Roll_dice(p1);
						JOptionPane.showMessageDialog(null, "The dice rolled automatically for Player " + p1.getName()
								+ " and got a " + p1.getDice());
						v.dice(p1.getDice(), 1);
						b.Roll_dice(p2);
						JOptionPane.showMessageDialog(null, "The dice rolled automatically for Player " + p2.getName()
								+ "and got a " + p2.getDice());
						v.dice(p2.getDice(), 2);
						pos[p1.getPawnPos()].performAction(p1, p2, b.getDice());
					} while (p1.getDice() == p2.getDice());
					v.setEuros(p1, 1);
					v.setEuros(p2, 2);
				} else if (pos[p1.getPawnPos()] instanceof FamilyCasinoNight) {
					if (b.getDice() % 2 == 1) {
						j.setAvailableEuro(j.getAvailableEuro() + 500);
						v.setJack(j.getAvailableEuro());
					}
					pos[p1.getPawnPos()].performAction(p1, b.getDice());
					JOptionPane.showMessageDialog(null,
							"Family Casino Night Position: If the dice you rolled to get in this position was odd you pay 500 euro to the jackpot, otherwise, you get paid 500 euros.");
					v.setEuros(p1, 1);
				} else if (pos[p1.getPawnPos()] instanceof DealCardPosition) {
					int a = p1.getDealCards();
					if(dcCount>dc.length) {
						b.shuffle(dc[0]);
						dcCount=0;
					}
					pos[p1.getPawnPos()].performAction(p1, dc[dcCount]);
					v.setEuros(p1, 1);
					dcCount++;
				} else if (pos[p1.getPawnPos()] instanceof Buyer) {
					String s;
					int tries = 0;
					if (p1.getDeal().size() > 0) {
						p1.showDealCards();
						do {
							s = JOptionPane.showInputDialog("Which Deal Card do you want to sell? (Enter the number)");
							if (tries > 0) {
								JOptionPane.showMessageDialog(null, "Wrong number! " + p1.getDeal().size());
							}
							tries++;
						} while (Integer.parseInt(s) > p1.getDeal().size());
						pos[p1.getPawnPos()].performAction(p1, Integer.parseInt(s));
						v.setEuros(p1, 1);
					} else {
						JOptionPane.showMessageDialog(null, "Den exeis kartes symfwnias gia na poulhseis :(.");
					}
				}else if(pos[p1.getPawnPos()] instanceof MailCardPosition) {
					if(mcCount>mc.length) {
						b.shuffle(mc[0]);
						mcCount=0;
					}
					if(pos[p1.getPawnPos()].getIcon().equals("images/mc1.png")) {
						pos[p1.getPawnPos()].performAction(p1,p2, mc[mcCount], 1,j);
						mcCount++;
					}else if(pos[p1.getPawnPos()].getIcon().equals("images/mc2.png")) {
						for(int i=0;i<2;i++) {
							pos[p1.getPawnPos()].performAction(p1, p2, mc[mcCount], 1, j);
							mcCount++;
						}
					}
					v.setEuros(p1, 1);
					v.setEuros(p2, 2);
					v.setJack(j.getAvailableEuro());
					v.setBills(p1, 1);
				}else if(pos[p1.getPawnPos()] instanceof YardSale) {
					b.Roll_dice(p1);
					if(dcCount>dc.length) {
						b.shuffle(dc[0]);
						dcCount=0;
					}
					JOptionPane.showMessageDialog(null, "YardSale Position: You pay 100* the dice that will roll automatically and pull the first card from the Deal Card stack");
					JOptionPane.showMessageDialog(null, "The dice rolled automatically and got a "+p1.getDice());
					v.dice(b.getDice(), 1);
					pos[p1.getPawnPos()].performAction(p1, p1.getDice());
					pos[p1.getPawnPos()].performAction(p1, dc[dcCount]);
					dcCount++;
					v.setEuros(p1, 1);
				}
				
				if (pos[p1.getPawnPos()].getDay().equals("Sunday")) {
					b.Roll_dice(p1);
					p1.SundayFootballDay(b.getDice(), p1, v, 1);
					v.dice(p1.getDice(), 1);
				}
				if (pos[p1.getPawnPos()].getDay().equals("Thursday")) {
					b.Roll_dice(p1);
					p1.Crypto(b.getDice(), p1, v, 1);
					v.dice(p1.getDice(), 1);
				}
				p1.checkLoan(p1.getEuros(), p1);
				v.setLoan(p1, 1);
				v.setEuros(p1, 1);
				if(p2.getMonth()<=Integer.parseInt(month))
					v.getRollDice(1).setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(null, "You finished!");
				v.getRollDice(1).setEnabled(false);
			}
			v.setLoan(p1,1);
		} else if (e.getSource() == v.getRollDice(2)) {
			if(p2.getMonth()<=Integer.parseInt(month)) {
			b.Roll_dice(p2);
			v.dice(b.getDice(), 2);
			if (b.getDice() == 6 && j.getAvailableEuro() != 0) {
				JOptionPane.showMessageDialog(null,
						"Congratulations! You got the Jackpot: " + j.getAvailableEuro() + " Euros added.");
				p2.setEuros(p2.getEuros() + j.getAvailableEuro());
				v.setEuros(p2, 2);
				j.setAvailableEuro(0);
				v.setJack(0);
			}
			p2.setPawnPos(p2.getPawnPos() + p2.getDice());
			if (p2.getPawnPos() <= 6) {
				v.setPawn2((p2.getPawnPos() % 7) * 85, 200);
			} else if (p2.getPawnPos() <= 13) {
				v.setPawn2((p2.getPawnPos() % 7) * 85, 315);
			} else if (p2.getPawnPos() <= 20) {
				v.setPawn2((p2.getPawnPos() % 7) * 85, 430);
			} else if (p2.getPawnPos() <= 27) {
				v.setPawn2((p2.getPawnPos() % 7) * 85, 545);
			} else if (p2.getPawnPos() < 31) {
				v.setPawn2((p2.getPawnPos() % 7) * 85, 660);
			} else if (p2.getPawnPos() <= 37) {
				v.setPawn2(3 * 85, 660);
				p2.setPawnPos(32);
			}
			if (p2.getPawnPos() >= 31) {
				if(p2.getMonth()!= Integer.parseInt(month))
					JOptionPane.showMessageDialog(null, "You are going to the next month...");
				p2.setPawnPos(31);
				pos[p2.getPawnPos()].performAction(p2, p2.getDice());
				v.setBills(p2, 2);
				v.setLoan(p2, 2);
				v.setEuros(p2, 2);
				p2.setPawnPos(0);
			}
			if (pos[p2.getPawnPos()] instanceof Sweepstakes) {
				b.Roll_dice(p2);
				v.dice(b.getDice(), 2);
				JOptionPane.showMessageDialog(null,
						"Sweepstakes Position: The dice rolled automatically and got a " + b.getDice());
				pos[p2.getPawnPos()].performAction(p2, b.getDice());
				v.setEuros(p2, 2);
			} else if (pos[p2.getPawnPos()] instanceof Lottery) {
				do {
					n2 = JOptionPane.showInputDialog("PLAYER: " + p2.getName() + " Enter a number 1-6 ");
					n1 = JOptionPane.showInputDialog("PLAYER: " + p1.getName() + " Enter a number 1-6 ");

				} while ((Integer.parseInt(n1) < 1 || Integer.parseInt(n1) > 6)
						|| (Integer.parseInt(n2) < 1 || Integer.parseInt(n2) > 6)
						|| (Integer.parseInt(n1) == Integer.parseInt(n2)));
				do {
					b.Roll_dice(p2);
					v.dice(b.getDice(), 2);
					JOptionPane.showMessageDialog(null,
							"Lottery Position: The dice rolled automatically and got a " + b.getDice());
				} while (b.getDice() != Integer.valueOf(n1) && b.getDice() != Integer.valueOf(n2));
				if (b.getDice() == Integer.parseInt(n1)) {
					pos[p2.getPawnPos()].performAction(p1, b.getDice());
					v.setEuros(p1, 1);
				} else {
					pos[p2.getPawnPos()].performAction(p2, b.getDice());
					v.setEuros(p2, 2);
				}
			} else if (pos[p2.getPawnPos()] instanceof Radio) {
				b.Roll_dice(p1);
				b.Roll_dice(p2);
				do {
					JOptionPane.showMessageDialog(null,
							"Radio Position: The dice will roll automatically for each Player and the biggest roll wins the money!");
					b.Roll_dice(p2);
					JOptionPane.showMessageDialog(null,
							"The dice rolled automatically for Player " + p2.getName() + " and got a " + p2.getDice());
					v.dice(p2.getDice(), 2);
					b.Roll_dice(p1);
					JOptionPane.showMessageDialog(null,
							"The dice rolled automatically for Player " + p1.getName() + "and got a " + p1.getDice());
					v.dice(p1.getDice(), 1);
					pos[p2.getPawnPos()].performAction(p1, p2, b.getDice());
				} while (p1.getDice() == p2.getDice());
				v.setEuros(p1, 1);
				v.setEuros(p2, 2);
			} else if (pos[p2.getPawnPos()] instanceof FamilyCasinoNight) {
				if (b.getDice() % 2 == 1) {
					j.setAvailableEuro(j.getAvailableEuro() + 500);
					v.setJack(j.getAvailableEuro());
				}
				pos[p2.getPawnPos()].performAction(p2, b.getDice());
				JOptionPane.showMessageDialog(null,
						"Family Casino Night Position: If the dice you rolled to get in this position was odd you pay 500 euro to the jackpot, otherwise, you get paid 500 euros.");
				v.setEuros(p2, 2);
			} else if (pos[p2.getPawnPos()] instanceof DealCardPosition) {
				int a = p2.getDealCards();
				if(dcCount>dc.length) {
					b.shuffle(dc[0]);
					dcCount=0;
				}
				pos[p2.getPawnPos()].performAction(p2, dc[dcCount]);
				dcCount++;
				v.setEuros(p2, 2);
			} else if (pos[p2.getPawnPos()] instanceof Buyer) {
				String s;
				int tries = 0;
				if (p2.getDeal().size() > 0) {
					p2.showDealCards();
					do {
						s = JOptionPane.showInputDialog("Which Deal Card do you want to sell? (Enter the number)");
						if (tries > 0) {
							JOptionPane.showMessageDialog(null, "Wrong number! " + p2.getDeal().size());
						}
						tries++;
					} while (Integer.parseInt(s) > p2.getDeal().size());
					pos[p2.getPawnPos()].performAction(p2, Integer.parseInt(s));
					v.setEuros(p2, 2);
				} else {
					JOptionPane.showMessageDialog(null, "Den exeis kartes symfwnias gia na poulhseis :(.");
				}
			}else if(pos[p2.getPawnPos()] instanceof MailCardPosition) {
				if(mcCount>mc.length) {
					b.shuffle(mc[0]);
					mcCount=0;
				}
				if (pos[p2.getPawnPos()].getIcon().equals("images/mc1.png")) {
					pos[p2.getPawnPos()].performAction(p1, p2, mc[mcCount], 2, j);
					mcCount++;
				}else if(pos[p2.getPawnPos()].getIcon().equals("images/mc2.png")) {
					for(int i=0;i<2;i++) {
						pos[p2.getPawnPos()].performAction(p1, p2, mc[mcCount], 2, j);
						mcCount++;
					}
				}
				v.setEuros(p1, 1);
				v.setEuros(p2, 2);
				v.setJack(j.getAvailableEuro());
				v.setBills(p2, 2);
			}else if(pos[p2.getPawnPos()] instanceof YardSale){
				if(dcCount>dc.length) {
					b.shuffle(dc[0]);
					dcCount=0;
				}
				JOptionPane.showMessageDialog(null, "YardSale Position: You pay 100* the dice that will roll automatically and pull the first card from the Deal Card stack");
				JOptionPane.showMessageDialog(null, "The dice rolled automatically and got a "+p2.getDice());
				v.dice(b.getDice(), 2);
				pos[p2.getPawnPos()].performAction(p2, p2.getDice());
				pos[p2.getPawnPos()].performAction(p2, dc[dcCount]);
				dcCount++;
				v.setEuros(p2, 2);
				
			}
			if (pos[p2.getPawnPos()].getDay().equals("Sunday")) {
				b.Roll_dice(p2);
				p2.SundayFootballDay(b.getDice(), p2, v, 2);
				v.dice(p2.getDice(), 2);
			}
			if (pos[p2.getPawnPos()].getDay().equals("Thursday")) {
				b.Roll_dice(p2);
				p2.Crypto(b.getDice(), p2, v, 2);
				v.dice(p2.getDice(), 2);
			}
			p2.checkLoan(p2.getEuros(), p2);
			v.setLoan(p2, 2);
			v.setEuros(p2, 2);
			if(p1.getMonth()<=Integer.parseInt(month))
				v.getRollDice(2).setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(null, "You finished");
			}
			v.setLoan(p2,2);
		} else if (e.getSource() == v.getEndTurn(1)) {
			p1.setTurn(0);
			p2.setTurn(1);
			v.getRollDice(2).setEnabled(true);
			v.getRollDice(1).setEnabled(false);
			v.getEndTurn(1).setEnabled(false);
			v.getEndTurn(2).setEnabled(true);
		} else if (e.getSource() == v.getEndTurn(2)) {
			p1.setTurn(1);
			p2.setTurn(0);
			v.getEndTurn(2).setEnabled(false);
			v.getRollDice(1).setEnabled(true);
			v.getRollDice(2).setEnabled(false);
			v.getEndTurn(1).setEnabled(true);
		}else if(e.getSource() == v.getDealCards(1)) {
			p1.showDealCards();
		}else if(e.getSource()==v.getDealCards(2)) {
			p2.showDealCards();
		}else if(e.getSource()==v.getLoan(1)) {
			p1.setLoan(p1.getLoan()+Integer.parseInt(JOptionPane.showInputDialog("How much money do you want to loan?")));
			v.setLoan(p1, 1);
			p1.setEuros(p1.getEuros()+p1.getLoan());
			v.setEuros(p1, 1);
		}else if(e.getSource()==v.getLoan(2)) {
			p2.setLoan(p2.getLoan()+Integer.parseInt(JOptionPane.showInputDialog("How much money do you want to loan?")));
			v.setLoan(p2, 2);
			p2.setEuros(p2.getEuros()+p2.getLoan());
			v.setEuros(p2, 2);
		}

	}

}
