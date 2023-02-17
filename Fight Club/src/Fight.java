import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Fight {	
	
	public Scanner s = new Scanner (System.in);
	public String p1, p2;
	public Fighters P1= new Fighters(p1); 
	public Fighters P2= new Fighters(p2);
	public int option;
	
	public void p1Move(int option) {
		//option = s.nextInt();
		switch(option) {
		case 1:
			P1.nextPunch = true;
			P1.nextBlock = false;
			break;
		case 2:				
			P1.nextBlock = true;
			P1.nextPunch = false;
			P1.arr.add(P1.nextBlock);
			break;
		
		}
	}
	
	public void p2Move(int option){
		switch(option) {
		case 1:
			P2.nextPunch = true;
			P2.nextBlock = false;
			break;
		case 2:				
			P2.nextBlock = true;
			P2.nextPunch = false;
			P2.arr.add(P2.nextBlock);
			break;
		
		}
	}
	
	public void fight(){
		
	    P1.action(P2);
	    P2.action(P1);
	    
	       
		
	}
	
	public String winner() {
		String player = "";
		if(P1.Health <= 0) {
			player = "Player 2";
		}
		else {
			player = "Player 1";
		}
		return player;
	}
	
	
	
}
