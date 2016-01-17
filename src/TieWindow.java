
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class TieWindow extends JDialog {
	 
	JLabel tieLabel;
	 
	 public TieWindow(JFrame frame) {
		 
		super(frame , "TIE", true);
		setLayout(new FlowLayout());
		
		tieLabel = new JLabel("YOU TIED WITH THE DEALER");
		add(tieLabel);
		
		
		
	}
}
