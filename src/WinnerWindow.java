
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class WinnerWindow extends JDialog {
	 
	JLabel winnerLabel;
	 
	 public WinnerWindow(JFrame frame) {
		 
		super(frame , "YOU WON", true);
		setLayout(new FlowLayout());
		
		winnerLabel = new JLabel("YOU BEAT THE DEALER, YOU WIN!");
		add(winnerLabel);
		
		
		
	}
}
