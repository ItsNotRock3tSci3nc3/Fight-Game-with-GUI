
public class Thread1 extends Thread{
	public void run() {
		for(int i=0; i<5; i++)
			System.out.println("Player 1 option interation " + i);
	}
}
