package Model;

import java.util.Random;

public class Player implements PlayerInterface{

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
	private int bill_cnt;//counter for bills, the bills in euros will be caclulated with a method
	public Player(int euros,String name) {
		this.loanNum=0;
		this.month=1;
		this.name=name;
		this.pawn_pos=0;
		this.dealCards=0;
		this.euros=euros;
		this.win=false;
	}
	public void setTurn(int turn) {
		this.turn=turn;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public int getMonth() {
		return this.month;
	}
	public void setDice(int dice) {
		this.dice=dice;
	}
	public int getDice() {
		return this.dice;
	}
	public void setPawnPos(int pawn) {
		this.pawn_pos=pawn;
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
		this.win=win;
	}
	public boolean getWin() {
		return this.win;
	}
	public void setEuros(int euros) {
		this.euros=euros;
	}
	public int getEuros() {
		return this.euros;
	}
	public int getLoan() {
		return this.loanNum;
	}
	public void setLoan(int loan) {
		this.loanNum=loan;
	}
	public int getDealCards() {
		return this.dealCards;
	}
	public void setDealCards(int deal) {
		this.dealCards=deal;
	}
	
}
