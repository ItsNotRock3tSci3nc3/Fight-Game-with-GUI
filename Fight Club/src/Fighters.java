import java.util.*;
public class Fighters {
	String name;
	double Health = 100.0;
	//public int option;

	public ArrayList<Boolean> arr = new ArrayList();
	
	boolean nextPunch;
	boolean nextBlock;
	
	int hitsTaken = 0;
	int punchCounter = 0;
	//int blockCounter = 0;
	double punchDamage = 10.0;
	
	boolean tired;
	
	public String react = "";
	
	Fighters(String name) {
		this.name = name;
		tired = false;
	}
	
	
	
	public void isTired() {
		if(punchCounter > 5) {
			tired = true;
		}
		else {
			tired = false;
		}
	}
	
	
	
	public void action(Fighters f) {
		this.isTired();
		
		
		
		if(this.blockCounter(arr)) {
			double rand = Math.random();
			if(rand<0.5) {
				this.nextBlock = false;
				react = "'s block failed because they are tired!";
			}
		}
		
		if(f.nextPunch && !this.nextBlock && this.nextPunch) {
			Health = Health - f.punch();
			react = " took a hit! Health is now at " + Health;
	
		}
		else if(this.nextPunch && f.nextBlock) {
			////System.out.println(f.name + " blocked the attack! The attack was ineffective! " + name + "'s health is now at " + Health);
		}
		else if(!this.nextPunch && !this.nextBlock && f.nextPunch) {
			Health = Health - f.punch();
			react = "I can't protect you if you don't protect yourself...\n" + name + "'s health is now at " + Health;
		}
		else {
			react = " blocked the attack! Health is now at " + Health;
		}
		
		if(this.tired) {
			react = " is fategued!";
		}
		
		
		
		
	}
	
	
	
	public boolean blockCounter(ArrayList <Boolean> s) {
		//int i = s.size();
		boolean temp1,temp2,temp3;
		
		for(int i = 0; i < s.size()-3; i++) {
			if(s.size() >= 3) {
				temp1 = s.get(i);
				temp2 = s.get(i+1);
				temp3 = s.get(i+2);
				if(temp1 && temp2 && temp3) {
					return true;
				}
			}
		}
		return false;		
	}
	
	
	
	public double punch() {
		double damage;
		punchCounter++;
		nextPunch = true;
		if(tired) {
			 damage = (punchDamage)*(((double)punchCounter)*0.1);
			 return damage;
		}
		else {
			return punchDamage;
		}
		
	}

	public double GetHealth(){
		return Health;
	}
	
}
