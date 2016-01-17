
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class LoserWindow extends JDialog {
	
	JLabel lossLabel;
	
	public LoserWindow(JFrame frame) {
		super(frame , "YOU LOSE", true);
		setLayout(new FlowLayout());
		
		lossLabel = new JLabel("YOU LOST TO THE DEALER!");
		add(lossLabel);
		
	
	}
	
	
}
