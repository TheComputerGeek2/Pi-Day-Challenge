package gui;

import java.util.TreeSet;

import javax.swing.JPanel;

import performance.UserAttempt;

@SuppressWarnings("serial")
public class RankingDisplay extends JPanel {

	private TreeSet<UserAttempt> attempts;
	
	public RankingDisplay() {
		super();
		
		//create the set to contain the attempts
		attempts = new TreeSet<UserAttempt>();
		
		
		//create the area for displaying the leader board
		
		
		
		
	}
	
	public void addAttempt(UserAttempt newAttempt) {
		attempts.add(newAttempt);
		updateDisplay();
	}

	//public void updateUser(String username, int digits) {
		// TODO make this work
	//}
	
	private void updateDisplay() {
		
	}

}
