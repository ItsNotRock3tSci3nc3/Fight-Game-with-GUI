import java.util.*;
import java.lang.*;
import java.util.List;
import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class game extends Fight {
	// shift windows to different classes and use multithreading in order to shift
	// between windows with better control

	JFrame window;
	Container con;
	JPanel title, startButtonPanel, Fight, mainTextPanel, optionPanel, gameInfo;
	JLabel titleName, p1HLabel, p1HNumber, p2HLabel, p2HNumber;
	Font titleFont = new Font("Times New Roman", Font.BOLD, 90);
	JButton startButton, choice1, choice2;
	Font normal = new Font("Times New Roman", Font.PLAIN, 30);
	JTextArea mainTextArea;
	int pos = 1;
	int step = 1;

	TitleScreenHandler tsHandler = new TitleScreenHandler();
	choiceHandler cHandler = new choiceHandler();

	public static void main(String[] args) {
		new game();

	}

	public game() {
		window = new JFrame();
		window.setSize(800, 600); // sets frame size (length, height)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes when X is pressed
		window.getContentPane().setBackground(Color.black); // sets background color
		window.setLayout(null);
		con = window.getContentPane();

		title = new JPanel();
		title.setBounds(100, 100, 600, 150);// sets location and size for the panel where the text will be
		title.setBackground(Color.black);
		titleName = new JLabel("FIGHT CLUB");
		titleName.setForeground(Color.red);
		titleName.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 300, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("Fight");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.red);
		startButton.setFont(normal);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);

		startButtonPanel.add(startButton);
		title.add(titleName);

		con.add(title);
		con.add(startButtonPanel);
		window.setVisible(true);

	}

	public void createGameScreen() {

		title.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea("Are you sure you want to fight? \nYou could just peacefully negociate...?");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.red);
		mainTextArea.setFont(normal);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		optionPanel = new JPanel();
		optionPanel.setBounds(250, 350, 300, 150);
		optionPanel.setBackground(Color.black);
		optionPanel.setLayout(new GridLayout(2, 1));
		con.add(optionPanel);

		choice1 = new JButton();
		choice1.setText("VIOLENCE!!!");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.red);
		choice1.setFont(normal);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		optionPanel.add(choice1);

		choice2 = new JButton();
		choice2.setText("World Peace!");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.red);
		choice2.setFont(normal);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		optionPanel.add(choice2);

		gameInfo = new JPanel();
		gameInfo.setBounds(100, 15, 600, 50);
		gameInfo.setBackground(Color.black);
		gameInfo.setLayout(new GridLayout(1, 4));
		con.add(gameInfo);

		p1HLabel = new JLabel("P1 Health: ");
		p1HLabel.setFont(normal);
		p1HLabel.setForeground(Color.white);
		gameInfo.add(p1HLabel);
		p1HNumber = new JLabel();
		p1HNumber.setFont(normal);
		p1HNumber.setForeground(Color.green);
		gameInfo.add(p1HNumber);

		p2HLabel = new JLabel("P2 Health: ");
		p2HLabel.setFont(normal);
		p2HLabel.setForeground(Color.white);
		gameInfo.add(p2HLabel);
		p2HNumber = new JLabel();
		p2HNumber.setFont(normal);
		p2HNumber.setForeground(Color.green);
		gameInfo.add(p2HNumber);

		step++;
	}

	public void playerSetup() {
		p1HNumber.setText("" + P1.Health);
		p2HNumber.setText("" + P2.Health);
	}

	public void firstMove() {
		//step = 2;
		EndGameCheck();
		playerSetup();
		mainTextArea.setText("P1, make your move");

		choice1.setText("Punch");
		choice1.setActionCommand("c1");

		choice2.setText("Block");
		choice2.setActionCommand("c2");

		step++;
		actionListen();
		
	}

	public void secondMove() {
		step = 3;
		EndGameCheck();
		playerSetup();
		mainTextArea.setText("P2, make your move");
		choice1.setText("Punch");
		choice2.setText("Block");
		actionListen();
		//step = 2;
	}

	public void EndGameCheck(){
		if(P1.Health == 0 || P2.Health == 0){
			result();
		}
	}

	public void result() {
		step = 4;
		fight();
		mainTextArea.setText(P1.react + "\n" + P2.react);
		choice1.setText("");
		choice2.setText("");
		step = 2;

	}

	public void end() {
		step = 5;
		mainTextArea.setText(winner() + " wins!");

	}

	public void peace() {
		playerSetup();
		mainTextArea.setText("Good for you!");
		choice1.setText("");
		choice2.setText("");
		window.dispose();
	}

	public void actionListen() {
		choice1.addActionListener(cHandler);
		choice2.addActionListener(cHandler);
	}

	public class choiceHandler implements ActionListener { // choice control
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			switch (step) {
				case (1):
					switch (yourChoice) {
						case ("c1"):
							firstMove();
							break;
						case ("c2"):
							peace();
							break;
					}
					break;
				case (2):	
					System.out.println("in case 2");
					switch (yourChoice) {
						case ("c1"):
							p1Move(1);
							secondMove();
							break;
						case ("c2"):
							p1Move(2);
							secondMove();							
							break;
					}
					break;
				case (3):
				System.out.println("in case 3");

					switch (yourChoice) {
						case ("c1"):
							p2Move(1);
							firstMove();
							break;
						case ("c2"):
							p2Move(2);
							firstMove();
							break;
					}
					break;
				case (4):
					result();
			}
			
		}
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}

	}

}
