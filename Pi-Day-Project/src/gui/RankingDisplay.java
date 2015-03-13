package gui;

import java.util.TreeMap;

import javax.swing.JList;
import javax.swing.JPanel;

import performance.UserAttempt;

@SuppressWarnings("serial")
public class RankingDisplay extends JPanel {

	private TreeMap<UserAttempt, String> attempts;
	
	private JList listings;
	
	public RankingDisplay() {
		super();
		
		//create the set to contain the attempts
		attempts = new TreeMap<UserAttempt, String>();
		
		
		//create the area for displaying the leader board
		addListComponent();
		
		
		
	}
	
	private void addListComponent() {
		listings = new JList();
		add(listings);
		updateDisplay();
		
	}
	
	public void addAttempt(UserAttempt newAttempt) {
		attempts.put(newAttempt, getAttemptLabel(newAttempt));
		updateDisplay();
	}
	
	private static String getAttemptLabel(UserAttempt attempt) {
		String label = attempt.getUsername() + " - " + attempt.getDigitsCorrect();
		return label;
	}
	
	private void updateDisplay() {
		listings.setListData(attempts.values().toArray());
	}

}
