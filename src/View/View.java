package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Board;
import Model.Card;
import Model.Jackpot;
import Model.Player;
import Model.Position;


public class View{

	/**
	 * Here I will make the GUI of the game using the images that are given to us
	 * I will make a method dice(int dice) that will visualize the dice depending on the argument
	 */
	
	/*
	 * The Main board GUI
	 */
	JLabel pawn1,pawn2,dice1=new JLabel(),dice2=new JLabel();
	JLabel euros1,euros2,loan1,loan2,bills1,bills2;
	JLabel text;
	//na balw to zari
	JButton rolldice1,rolldice2;
	JButton myDealCards1,myDealCards2;
	JButton GetLoan1,GetLoan2;
	JLabel jack;
	JButton EndTurn1,EndTurn2;
	JLabel dealCard,mailCard;
	public JPanel Player1(Player p1,int xcord,int ycord,Color c) {
		
		JPanel p=new JPanel();
		JLabel name=new JLabel(p1.getName());
		this.euros1=new JLabel("Money: "+Integer.toString(p1.getEuros())+" Euros");
		this.loan1=new JLabel("Loan: "+Integer.toString(p1.getLoan())+" Euros");
		this.rolldice1=new JButton("Roll Dice");
		this.myDealCards1=new JButton("My Deal Cards");
		this.GetLoan1=new JButton("Get Loan");
		this.EndTurn1=new JButton("End Turn");
		this.bills1=new JLabel("Bills: "+p1.getBills()+" Euros");
		//600,50 gia to p1
		p.setBounds(xcord,ycord,250,250);
		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(c));
		name.setBounds(10,0,100,50);
		this.euros1.setBounds(10, 30,150, 90);
		this.loan1.setBounds(10,60,150,90);
		this.bills1.setBounds(10,90,150,90);
		this.rolldice1.setBounds(10,170,120,20);
		this.myDealCards1.setBounds(10,195,120,20);
		this.GetLoan1.setBounds(10,220, 115, 20);
		this.EndTurn1.setBounds(130,220,115,20);
		
		
		p.add(name);
		p.add(euros1);
		p.add(loan1);
		p.add(rolldice1);
		p.add(myDealCards1);
		p.add(GetLoan1);
		p.add(EndTurn1);
		p.add(bills1);
		
		return p;
	}
	
	public JPanel text(Player pl) {
		JPanel p=new JPanel();
		p.setBounds(600,400,200,100);
		//p.add(text);
		
		return p;
	}
	
	
	public JPanel Player2(Player p1, int xcord, int ycord, Color c) {
		JPanel p=new JPanel();
		JLabel name=new JLabel(p1.getName());
		
		this.euros2 = new JLabel("Money: " + Integer.toString(p1.getEuros()) + " Euros");
		this.loan2 = new JLabel("Loan: " + Integer.toString(p1.getLoan()) + " Euros");
		this.rolldice2 = new JButton("Roll Dice");
		this.myDealCards2 = new JButton("My Deal Cards");
		this.GetLoan2 = new JButton("Get Loan");
		this.EndTurn2 = new JButton("End Turn");
		this.bills2=new JLabel("Bills: "+p1.getBills()+" Euros");
		p.setBounds(xcord, ycord, 250, 250);
		p.setLayout(null);
		p.setBorder(BorderFactory.createLineBorder(c));
		name.setBounds(10, 0, 100, 50);
		this.euros2.setBounds(10, 30, 150, 90);
		this.loan2.setBounds(10, 60, 150, 90);
		this.bills2.setBounds(10,90,150,90);
		this.rolldice2.setBounds(10, 170, 120, 20);
		this.myDealCards2.setBounds(10, 195, 120, 20);
		this.GetLoan2.setBounds(10, 220, 115, 20);
		this.EndTurn2.setBounds(130, 220, 115, 20);

		p.add(name);
		p.add(euros2);
		//p.add(dice2);
		p.add(bills2);
		p.add(loan2);
		p.add(rolldice2);
		p.add(myDealCards2);
		p.add(GetLoan2);
		p.add(EndTurn2);
		
		return p;
	}
	public JPanel Positions(Board b) {
		Position[] p=new Position[32];
		JPanel panel=new JPanel();
		JLabel label=new JLabel();
		ImageIcon icon;
		p=b.getPosition();
		String[] icons=new String[32];
		
		for(int i=0;i<p.length;i++) {
			icons[i]=p[i].getIcon();
		}
		panel.setLayout(new GridLayout(5,7));
		panel.setBounds(0,150,560,560);
		
		for(int i=0;i<p.length;i++) {
			icon=new ImageIcon(icons[i]);
			icon=this.getScaledImage(icon.getDescription(),85,100);
			label=new JLabel(icon);
			if(i>0) {
				label.setForeground(Color.RED);
				label.setBackground(Color.YELLOW);
				label.setText(p[i].getDay()+" "+p[i].getNum());
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.TOP);
			}else {
				label.setText(" ");
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.TOP);
			}
			panel.setBackground(Color.DARK_GRAY);
			panel.add(label);
		}
		return panel;
	}
	public JLabel Pawn1(ImageIcon icon) {
		icon=getScaledImage(icon.getDescription(),50, 50);
		pawn1=new JLabel(icon);
		this.setPawn1(0, 150);
		return pawn1;
	}
	public void setBills(Player p,int who) {
		if(who==1) 
			this.bills1.setText("Bills: "+p.getBills()+" Euros");
		else
			this.bills2.setText("Bills: "+p.getBills()+" Euros");
			
	}
	
	public JLabel Pawn2(ImageIcon icon) {
		icon=getScaledImage(icon.getDescription(),50, 50);
		pawn2=new JLabel(icon);
		this.setPawn2(0, 200);
		return pawn2;
	}
	
	public void setPawn2(int x,int y) {
		pawn2.setBounds(x, y, 50, 50);
	}
	
	public void dice(int num,int who) {
		ImageIcon i;
		if(who==2) {
			i = new ImageIcon("images/dice-"+num+".jpg");
			i = this.getScaledImage(i.getDescription(), 80, 50);
			dice2.setIcon(i);	
			dice2.setBounds(740, 665, 80, 50);
		}else {
			i = new ImageIcon("images/dice-"+num+".jpg");
			i = this.getScaledImage(i.getDescription(), 80, 50);
			dice1.setIcon(i);	
			dice1.setBounds(740, 215, 80, 50);
		}
	}
	
	
	public JLabel getPawn1() {
		return this.pawn1;
	}

	
	
	public void setPawn1(int x,int y) {
		pawn1.setBounds(x, y, 50, 50);
	}

	
	public void setEuros(Player p,int who) {
		if(who==1)
			this.euros1.setText("Money: "+Integer.toString(p.getEuros()));
		else
			this.euros2.setText("Money: "+Integer.toString(p.getEuros()));
	}
	
	
	public void setLoan(Player p,int who) {
		if(who==1)
			this.loan1.setText("Loan: "+Integer.toString(p.getLoan())+" Euros");
		else
			this.loan2.setText("Loan: "+Integer.toString(p.getLoan())+" Euros");
	}
	
	
	public JLabel getPawn2() {
		return this.pawn2;
	}
	public JButton getRollDice(int who) {
		if(who==1)
			return this.rolldice1;
		else
			return this.rolldice2;
	}
	public JButton getLoan(int who) {
		if(who==1)
			return this.GetLoan1;
		else
			return this.GetLoan2;
	}
	public JButton getEndTurn(int who) {
		if(who==1) 
			return this.EndTurn1;
		else
			return this.EndTurn2;
	}
	public JButton getDealCards(int who) {
		if(who==1)
			return this.myDealCards1;
		else
			return this.myDealCards2;
	}
	public JLabel getDice(int who) {
		if(who==1)
			return this.dice1;
		else
			return this.dice2;
	}
	public JLabel getJack() {
		return this.jack;
	}
	public void setJack(int eur) {
		this.jack.setText("Jackpot: "+Integer.toString(eur)+" Euros");
	}
	public View(Player p1,Player p2,Board b,Card c) {
		JLabel backg;
		JLabel logo;
		Jackpot j=new Jackpot();
		JFrame frame=new JFrame();
		JPanel p=new JPanel();
		JPanel player1=new JPanel();
		JPanel player2=new JPanel();
		JPanel info=new JPanel();
		info=this.text(p1);
		
		
		/* Pawns */
		ImageIcon icon=new ImageIcon("images/pawn_blue.png");
		pawn1=this.Pawn1(icon);
		
		
		ImageIcon ic=new ImageIcon("images/pawn_yellow.png");
		pawn2=this.Pawn2(ic);
				
		/* Background */
		ImageIcon back=new ImageIcon("images/bg_green.png");
		back=this.getScaledImage(back.getDescription(), 1000, 1000);
		backg=new JLabel(back);
		backg.setBounds(0, 0, 1000, 1000);
		//pawn2 ,jackpot
		
		/* Logo */
		ImageIcon l=new ImageIcon("images/logo.png");
		l=this.getScaledImage(l.getDescription(),560,150);
		logo=new JLabel(l);
		logo.setBounds(0,0, 560, 150);
		
		/* Jackpot */
		icon=new ImageIcon("images/jackpot.png");
		icon=this.getScaledImage(icon.getDescription(), 200, 80);
		jack=new JLabel(icon);
		jack.setText("Jackpot: "+ j.getAvailableEuro()+" Euros");
		jack.setHorizontalTextPosition(JLabel.CENTER);
		jack.setVerticalTextPosition(JLabel.BOTTOM);
		jack.setForeground(Color.blue);
		jack.setBounds(350, 610, 200, 100);
		
		/* DealCard label*/
		icon=new ImageIcon("images/dealCard.png");
		icon=this.getScaledImage(icon.getDescription(), 100, 50);
		dealCard=new JLabel(icon);
		dealCard.setBounds(600, 425, 100, 50);
		
		icon=new ImageIcon("images/mailCard.png");
		icon=this.getScaledImage(icon.getDescription(), 100, 50);
		mailCard=new JLabel(icon);
		mailCard.setBounds(720, 425, 100, 50);
		
		/* Players and Board initialization*/
		player1=this.Player1(p1, 600, 50,Color.RED);
		player2=this.Player2(p2,600 ,500,Color.YELLOW);
		b.initialize(p1, p2,c);
		p=this.Positions(b);
		frame.setSize(900,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(logo);
		frame.add(dice1);
		//frame.add(info);
		frame.add(dice2);
		frame.add(dealCard);
		frame.add(mailCard);
		frame.add(pawn1);
		frame.add(pawn2);
		frame.add(jack);
		frame.add(p);
		frame.add(player2);
		frame.add(player1);
		frame.add(backg);
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}

	public ImageIcon getScaledImage(String img, int w, int h){
		ImageIcon imageIcon = new ImageIcon(img);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
	}
	
}
