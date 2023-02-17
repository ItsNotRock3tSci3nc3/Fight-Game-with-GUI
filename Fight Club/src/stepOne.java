
public class stepOne {

public class step1 extends Thread {
		
		public void run() {
			
		}
		public void firstMove() {
			//step = 2;
			playerSetup();
			mainTextArea.setText("P1, make your move");
			choice1.setText("Punch");
			choice2.setText("Block");
			actionListen();
			//step++;
		}
	}

}
