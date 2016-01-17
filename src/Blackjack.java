import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class Blackjack extends JFrame{
	
	private static final long serialVersionUID = 1L; //Ensures version of program remains constant
	
	//Card ImageIcon
	ImageIcon cardImage1, cardImage2, cardImage3, cardImage4, cardImage5, cardImage6, cardImage7, cardImage8, cardImage9, cardImage10, cardImage11, cardImage12, cardImage13, cardImage14, cardImage15, cardImage16, cardImage17, cardImage18, cardImage19, cardImage20, cardImage21, cardImage22, cardImage23, cardImage24, cardImage25, cardImage26, cardImage27, cardImage28, cardImage29, cardImage30, cardImage31, cardImage32, cardImage33, cardImage34, cardImage35, cardImage36, cardImage37, cardImage38, cardImage39, cardImage40, cardImage41, cardImage42, cardImage43, cardImage44, cardImage45, cardImage46, cardImage47, cardImage48, cardImage49, cardImage50, cardImage51, cardImage52;
	
	//Card JLabel
	JLabel  card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50, card51, card52;
	
	// JFrame elements used in the program: Images, Labels, Buttons, Menu bar components
	ImageIcon blackjackLogo, dealerImage, playerImage, cardBackImage1, cardBackImage2, backgroundImage;
	JLabel mainLogoImage, mainPlayLabel, dealerIcon, playerIcon, playerHandLabel, cardBackLabel1, cardBackLabel2, dealerHandLabel, backgroundLabel;
	JFrame frame;
	JButton yesButton, noButton, buttonHit,buttonStay, buttonStayValue21, buttonPlayAgain;
	JMenuBar topMenuBar;
	JMenu fileMenu;
	JMenuItem playPrompt, exitOption;
	
	//Declaration of global variables
	int playerHandValue =0, dealerHandValue=0; // Saves the hand values of each player
	int playerCardCounter = 0, dealerCardCounter=0; // Counts the cards to change positions for every addition of a card
	int[] usedValues = new int[52]; // An array to save indices of values that are used
	int usedCardIndex = 0; // Variable to store the values of the indices of used values
	//Default constructor 
	public Blackjack() {
		setLayout(null);
		//Sets background in which the game takes place
		backgroundImage = new ImageIcon(getClass().getResource("PokerBackground.jpg"));
		backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(-200,-300,1400,1500);
		
		// Menu bar throughout the program (does not change)
		topMenuBar = new JMenuBar();
		setJMenuBar(topMenuBar);
		
		fileMenu = new JMenu("File");
		topMenuBar.add(fileMenu);
		
		playPrompt = new JMenuItem("Play Again");
		fileMenu.add(playPrompt);
		
		exitOption = new JMenuItem("Exit");
		fileMenu.add(exitOption);
		//------------------------------------------------------------
		
		// Main screen constructor:
		blackjackLogo = new ImageIcon(getClass().getResource("BlackjackLogo.jpg"));
		mainLogoImage = new JLabel(blackjackLogo);
		mainLogoImage.setBounds(0,0,1050, 500);
		add(mainLogoImage);
		
		mainPlayLabel = new JLabel("Want to play Black Jack?",SwingConstants.CENTER);
		mainPlayLabel.setBounds(0,475,1000,100);
		mainPlayLabel.setFont(mainPlayLabel.getFont().deriveFont(32.0f));
		add(mainPlayLabel);
		
		yesButton = new JButton();
		yesButton.setText("YES");
		yesButton.setFont(new Font("Serif", Font.BOLD, 20));
		yesButton.setBounds(0,625,525,75);
		add(yesButton);
		
		noButton = new JButton();
		noButton.setText("NO");
		noButton.setFont(new Font("Serif", Font.BOLD, 20));
		noButton.setBounds(525,625,525,75);
		add(noButton);
		//--------------------------------------------------------------------------
		
		// Beginning screen import:
		cardBackImage1 = new ImageIcon(getClass().getResource("CardBack.jpg"));
		cardBackLabel1 = new JLabel(cardBackImage1);
		cardBackLabel1.setBounds(710,20,250,250);
		
		cardBackImage2 = new ImageIcon(getClass().getResource("CardBack2.jpg"));
		cardBackLabel2 = new JLabel(cardBackImage2);
		cardBackLabel2.setBounds(620,20,250,250);
		// --------------------------------------------------------------------------
		
		// Game Functions:
		buttonHit = new JButton();
		buttonHit.setText("Hit");
		buttonHit.setFont(new Font("Serif", Font.BOLD, 20));
		buttonHit.setBounds(965,0,75,350);
		
		buttonStay = new JButton();
		buttonStay.setText("Stay");
		buttonStay.setFont(new Font("Serif", Font.BOLD, 20));
		buttonStay.setBounds(965,350,75,350);
		
		buttonStayValue21 = new JButton();
		buttonStayValue21.setText("Stay");
		buttonStayValue21.setFont(new Font("Serif", Font.BOLD, 20));
		buttonStayValue21.setBounds(965,0,75,700);
		
		buttonPlayAgain = new JButton();
		buttonPlayAgain.setText("Click to play again");
		buttonPlayAgain.setFont(new Font("Serif", Font.BOLD, 20));
		buttonPlayAgain.setBounds(400,330, 200,30);
		//------------------------------------------------------------------------
		
		// Identification
		playerImage = new ImageIcon(getClass().getResource("PlayerButton.png"));
		playerIcon = new JLabel(playerImage);
		playerIcon.setBounds(760,250,200,250);
		
		playerHandLabel = new JLabel("");
		playerHandLabel.setBounds(575,250,300,250);
		playerHandLabel.setForeground(Color.white);
		
		dealerImage = new ImageIcon(getClass().getResource("DealerButton.png"));
		dealerIcon = new JLabel(dealerImage);
		dealerIcon.setBounds(760,183,200,250);
		
		dealerHandLabel = new JLabel("");
		dealerHandLabel.setBounds(575,183,300,250);
		dealerHandLabel.setForeground(Color.white);
		// -----------------------------------------------------------------------
		
		// Action that causes the game screen to close
		closeEvent closeFunction = new closeEvent();
		noButton.addActionListener(closeFunction);
		exitOption.addActionListener(closeFunction);
		
		// Action to start the game
		gameStart startFunction = new gameStart();
		yesButton.addActionListener(startFunction);
		playPrompt.addActionListener(startFunction);
		buttonPlayAgain.addActionListener(startFunction);
		
		// Action to hit
		cardHit hitFunction = new cardHit();
		buttonHit.addActionListener(hitFunction);
		
		// Action to stay
		cardStay stayFunction = new cardStay();
		buttonStay.addActionListener(stayFunction);
		buttonStayValue21.addActionListener(stayFunction);
		
		//Card importing
		cardImage1 = new ImageIcon(getClass().getResource("4.png"));
		card1 = new JLabel(cardImage1);

		cardImage2 = new ImageIcon(getClass().getResource("5.png"));
		card2 = new JLabel(cardImage2);

		cardImage3 = new ImageIcon(getClass().getResource("6.png"));
		card3 = new JLabel(cardImage3);

		cardImage4 = new ImageIcon(getClass().getResource("7.png"));
		card4 = new JLabel(cardImage4);

		cardImage5 = new ImageIcon(getClass().getResource("8.png"));
		card5 = new JLabel(cardImage5);

		cardImage6 = new ImageIcon(getClass().getResource("9.png"));
		card6 = new JLabel(cardImage6);

		cardImage7 = new ImageIcon(getClass().getResource("10.png"));
		card7 = new JLabel(cardImage7);

		cardImage8 = new ImageIcon(getClass().getResource("11.png"));
		card8 = new JLabel(cardImage8);

		cardImage9 = new ImageIcon(getClass().getResource("12.png"));
		card9 = new JLabel(cardImage9);

		cardImage10 = new ImageIcon(getClass().getResource("13.png"));
		card10 = new JLabel(cardImage10);

		cardImage11 = new ImageIcon(getClass().getResource("14.png"));
		card11 = new JLabel(cardImage11);

		cardImage12 = new ImageIcon(getClass().getResource("15.png"));
		card12 = new JLabel(cardImage12);

		cardImage13 = new ImageIcon(getClass().getResource("16.png"));
		card13 = new JLabel(cardImage13);

		cardImage14 = new ImageIcon(getClass().getResource("17.png"));
		card14 = new JLabel(cardImage14);

		cardImage15 = new ImageIcon(getClass().getResource("18.png"));
		card15 = new JLabel(cardImage15);

		cardImage16 = new ImageIcon(getClass().getResource("19.png"));
		card16 = new JLabel(cardImage16);

		cardImage17 = new ImageIcon(getClass().getResource("20.png"));
		card17 = new JLabel(cardImage17);

		cardImage18 = new ImageIcon(getClass().getResource("21.png"));
		card18 = new JLabel(cardImage18);

		cardImage19 = new ImageIcon(getClass().getResource("22.png"));
		card19 = new JLabel(cardImage19);

		cardImage20 = new ImageIcon(getClass().getResource("23.png"));
		card20 = new JLabel(cardImage20);

		cardImage21 = new ImageIcon(getClass().getResource("24.png"));
		card21 = new JLabel(cardImage21);

		cardImage22 = new ImageIcon(getClass().getResource("25.png"));
		card22 = new JLabel(cardImage22);

		cardImage23 = new ImageIcon(getClass().getResource("26.png"));
		card23 = new JLabel(cardImage23);

		cardImage24 = new ImageIcon(getClass().getResource("27.png"));
		card24 = new JLabel(cardImage24);

		cardImage25 = new ImageIcon(getClass().getResource("28.png"));
		card25 = new JLabel(cardImage25);

		cardImage26 = new ImageIcon(getClass().getResource("29.png"));
		card26 = new JLabel(cardImage26);

		cardImage27 = new ImageIcon(getClass().getResource("30.png"));
		card27 = new JLabel(cardImage27);

		cardImage28 = new ImageIcon(getClass().getResource("31.png"));
		card28 = new JLabel(cardImage28);

		cardImage29 = new ImageIcon(getClass().getResource("32.png"));
		card29 = new JLabel(cardImage29);

		cardImage30 = new ImageIcon(getClass().getResource("33.png"));
		card30 = new JLabel(cardImage30);

		cardImage31 = new ImageIcon(getClass().getResource("34.png"));
		card31 = new JLabel(cardImage31);

		cardImage32 = new ImageIcon(getClass().getResource("35.png"));
		card32 = new JLabel(cardImage32);

		cardImage33 = new ImageIcon(getClass().getResource("36.png"));
		card33 = new JLabel(cardImage33);

		cardImage34 = new ImageIcon(getClass().getResource("37.png"));
		card34 = new JLabel(cardImage34);

		cardImage35 = new ImageIcon(getClass().getResource("38.png"));
		card35 = new JLabel(cardImage35);

		cardImage36 = new ImageIcon(getClass().getResource("39.png"));
		card36 = new JLabel(cardImage36);

		cardImage37 = new ImageIcon(getClass().getResource("40.png"));
		card37 = new JLabel(cardImage37);

		cardImage38 = new ImageIcon(getClass().getResource("41.png"));
		card38 = new JLabel(cardImage38);

		cardImage39 = new ImageIcon(getClass().getResource("42.png"));
		card39 = new JLabel(cardImage39);

		cardImage40 = new ImageIcon(getClass().getResource("43.png"));
		card40 = new JLabel(cardImage40);

		cardImage41 = new ImageIcon(getClass().getResource("44.png"));
		card41 = new JLabel(cardImage41);

		cardImage42 = new ImageIcon(getClass().getResource("45.png"));
		card42 = new JLabel(cardImage42);

		cardImage43 = new ImageIcon(getClass().getResource("46.png"));
		card43 = new JLabel(cardImage43);

		cardImage44 = new ImageIcon(getClass().getResource("47.png"));
		card44 = new JLabel(cardImage44);

		cardImage45 = new ImageIcon(getClass().getResource("48.png"));
		card45 = new JLabel(cardImage45);

		cardImage46 = new ImageIcon(getClass().getResource("49.png"));
		card46 = new JLabel(cardImage46);

		cardImage47 = new ImageIcon(getClass().getResource("50.png"));
		card47 = new JLabel(cardImage47);

		cardImage48 = new ImageIcon(getClass().getResource("51.png"));
		card48 = new JLabel(cardImage48);

		cardImage49 = new ImageIcon(getClass().getResource("52.png"));
		card49 = new JLabel(cardImage49);

		cardImage50 = new ImageIcon(getClass().getResource("53.png"));
		card50 = new JLabel(cardImage50);

		cardImage51 = new ImageIcon(getClass().getResource("54.png"));
		card51 = new JLabel(cardImage51);

		cardImage52 = new ImageIcon(getClass().getResource("55.png"));
		card52 = new JLabel(cardImage52);
		//--------------------------------------------------------------------------------
	}

	// Event to close the program
	public class closeEvent implements ActionListener{
		public void actionPerformed(ActionEvent closeFunction){
			System.exit(0);
		}
	}
	
	// Event to direct the program to the main screen that the game will begin with
	public class gameStart implements ActionListener{
		public void actionPerformed(ActionEvent startFunction){
			
			getContentPane().removeAll();
			revalidate();
			repaint();

			// Initialization of variables in the case that the player plays again
			playerHandValue = 0; 
			dealerHandValue = 0;
			playerCardCounter = 0;
			dealerCardCounter = 0;
			usedCardIndex =0;
			// Components of the initial screen
			add(cardBackLabel1);
			add(cardBackLabel2);
			add(buttonHit);
			add(buttonStay);
			add(playerIcon);
			add(dealerIcon);
			add(backgroundLabel);
					
		}
	}
	
	// Event that the player decides to HIT
	public class cardHit implements ActionListener{
		public void actionPerformed(ActionEvent hitFunction){
			// Reinitializes the content allows the JFrame to be modified in this event
			revalidate();
			repaint();
			// Removes background and is re-added at the end to lower the priority of the background on the screen
			remove(backgroundLabel);
			
			Random randGen = new Random();
			
			int rand = 0; 
			int playerCardValue=0;
			
			rand = randGen.nextInt(52) + 1;
			
			// Ensure that no values are reused
			for(int i=0; i<52;i++){
				if( rand == usedValues[i]){
					rand = randGen.nextInt(52);
					i=-1;
				}
			}
			
			// Prints cards depending on random number generation of values
			if(rand ==1){
				 card1.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 1;
				 add(card1);
			}

			else if(rand ==2){
				 card2.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 1;
				 add(card2);
			}

			else if(rand ==3){
				 card3.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 1;
				 add(card3);
			}

			else if(rand ==4){
				 card4.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 1;
				 add(card4);
			}

			else if(rand ==5){
				 card5.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 2;
				 add(card5);
			}

			else if(rand ==6){
				 card6.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 2;
				 add(card6);
			}

			else if(rand ==7){
				 card7.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 2;
				 add(card7);
			}

			else if(rand ==8){
				 card8.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 2;
				 add(card8);
			}

			else if(rand ==9){
				 card9.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 3;
				 add(card9);
			}

			else if(rand ==10){
				 card10.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 3;
				 add(card10);
			}

			else if(rand ==11){
				 card11.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 3;
				 add(card11);
			}

			else if(rand ==12){
				 card12.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 3;
				 add(card12);
			}

			else if(rand ==13){
				 card13.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 4;
				 add(card13);
			}

			else if(rand ==14){
				 card14.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 4;
				 add(card14);
			}

			else if(rand ==15){
				 card15.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 4;
				 add(card15);
			}

			else if(rand ==16){
				 card16.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 4;
				 add(card16);
			}

			else if(rand ==17){
				 card17.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 5;
				 add(card17);
			}

			else if(rand ==18){
				 card18.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 5;
				 add(card18);
			}

			else if(rand ==19){
				 card19.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 5;
				 add(card19);
			}

			else if(rand ==20){
				 card20.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 5;
				 add(card20);
			}

			else if(rand ==21){
				 card21.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 6;
				 add(card21);
			}

			else if(rand ==22){
				 card22.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 6;
				 add(card22);
			}

			else if(rand ==23){
				 card23.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 6;
				 add(card23);
			}

			else if(rand ==24){
				 card24.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 6;
				 add(card24);
			}

			else if(rand ==25){
				 card25.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 7;
				 add(card25);
			}

			else if(rand ==26){
				 card26.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 7;
				 add(card26);
			}

			else if(rand ==27){
				 card27.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 7;
				 add(card27);
			}

			else if(rand ==28){
				 card28.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 7;
				 add(card28);
			}

			else if(rand ==29){
				 card29.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 8;
				 add(card29);
			}

			else if(rand ==30){
				 card30.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 8;
				 add(card30);
			}

			else if(rand ==31){
				 card31.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 8;
				 add(card31);
			}

			else if(rand ==32){
				 card32.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 8;
				 add(card32);
			}

			else if(rand ==33){
				 card33.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 9;
				 add(card33);
			}

			else if(rand ==34){
				 card34.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 9;
				 add(card34);
			}

			else if(rand ==35){
				 card35.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 9;
				 add(card35);
			}

			else if(rand ==36){
				 card36.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 9;
				 add(card36);
			}

			else if(rand ==37){
				 card37.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card37);
			}

			else if(rand ==38){
				 card38.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card38);
			}

			else if(rand ==39){
				 card39.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card39);
			}

			else if(rand ==40){
				 card40.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card40);
			}

			else if(rand ==41){
				 card41.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card41);
			}

			else if(rand ==42){
				 card42.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card42);
			}

			else if(rand ==43){
				 card43.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card43);
			}

			else if(rand ==44){
				 card44.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card44);
			}

			else if(rand ==45){
				 card45.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card45);
			}

			else if(rand ==46){
				 card46.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card46);
			}

			else if(rand ==47){
				 card47.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card47);
			}

			else if(rand ==48){
				 card48.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card48);
			}

			else if(rand ==49){
				 card49.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card49);
			}

			else if(rand ==50){
				 card50.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card50);
			}

			else if(rand ==51){
				 card51.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card51);
			}

			else if(rand ==52){
				 card52.setBounds( 710-playerCardCounter*90 ,400,250,300);
				 playerCardValue = 10;
				 add(card52);
			}
			
			playerCardCounter ++; //Increases the card count of the total number of cards in the hand of the user
			
			// Sets values in an array of used values
			usedValues[usedCardIndex] = rand;
			usedCardIndex++;
			
			playerHandValue = playerHandValue + playerCardValue;
			
			playerHandLabel.setText("Your current hand value is " + playerHandValue + ".");
			add(playerHandLabel);
			
			// In the case that the player loses, final output to prompt to play again to restart program or terminate program
			if(playerHandValue > 21){
				//Changes the priority of elements on the screen, and removes the hit and stay options
				remove(buttonHit);
				remove(buttonStay);
				remove(backgroundLabel);
				add(buttonPlayAgain);
				add(backgroundLabel);
				
				// Opens a new window in another class to tell the player if they have lost
				LoserWindow lossMatch = new LoserWindow(Blackjack.this);
				lossMatch.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				lossMatch.setSize(300,100);
				lossMatch.setVisible(true);
				lossMatch.setLocation(300,300);
			}
			// Removes the hit option in the case that the player's hand value is 21
			else if(playerHandValue == 21){
				remove(buttonHit);
				remove(buttonStay);
				add(buttonStayValue21);
			}
			add(backgroundLabel); //Re-adds the background label that was removed before so that it will be prioritized at the back
		}
	}
	
	// Event to STAY in Blackjack
	public class cardStay implements ActionListener{
		public void actionPerformed(ActionEvent stayFunction){
			// Revalidates the screen so that it can change
			revalidate();
			repaint();
			//Removes unused buttons and images that must be moved
			remove(buttonHit);
			remove(buttonStay);
			remove(buttonStayValue21);
			remove(cardBackLabel1);
			remove(cardBackLabel2);
			// Generation of random numbers to determine the dealer's cards
			Random randGen = new Random();
			
			int rand = 0; 
			int dealerCardValue=0;
			
			// Artificial intelligence that causes the dealer to hit until his hand is equal or greater than the player's.
			while(dealerHandValue < playerHandValue && dealerHandValue < 21){
				
				rand = randGen.nextInt(52) + 1;
				
				// Checks if random number value has been used already.
				for(int i=51; i>=0;i--){
					if( rand == usedValues[i]){
						rand = randGen.nextInt(52);
						i=52;
					}
				}
				// Prints out a card depending on the random number generation
				if(rand ==1){
					 card1.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 1;
					 add(card1);
				}

				else if(rand ==2){
					 card2.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 1;
					 add(card2);
				}

				else if(rand ==3){
					 card3.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 1;
					 add(card3);
				}

				else if(rand ==4){
					 card4.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 1;
					 add(card4);
				}

				else if(rand ==5){
					 card5.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 2;
					 add(card5);
				}

				else if(rand ==6){
					 card6.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 2;
					 add(card6);
				}

				else if(rand ==7){
					 card7.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 2;
					 add(card7);
				}

				else if(rand ==8){
					 card8.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 2;
					 add(card8);
				}

				else if(rand ==9){
					 card9.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 3;
					 add(card9);
				}

				else if(rand ==10){
					 card10.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 3;
					 add(card10);
				}

				else if(rand ==11){
					 card11.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 3;
					 add(card11);
				}

				else if(rand ==12){
					 card12.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 3;
					 add(card12);
				}

				else if(rand ==13){
					 card13.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 4;
					 add(card13);
				}

				else if(rand ==14){
					 card14.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 4;
					 add(card14);
				}

				else if(rand ==15){
					 card15.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 4;
					 add(card15);
				}

				else if(rand ==16){
					 card16.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 4;
					 add(card16);
				}

				else if(rand ==17){
					 card17.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 5;
					 add(card17);
				}

				else if(rand ==18){
					 card18.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 5;
					 add(card18);
				}

				else if(rand ==19){
					 card19.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 5;
					 add(card19);
				}

				else if(rand ==20){
					 card20.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 5;
					 add(card20);
				}

				else if(rand ==21){
					 card21.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 6;
					 add(card21);
				}

				else if(rand ==22){
					 card22.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 6;
					 add(card22);
				}

				else if(rand ==23){
					 card23.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 6;
					 add(card23);
				}

				else if(rand ==24){
					 card24.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 6;
					 add(card24);
				}

				else if(rand ==25){
					 card25.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 7;
					 add(card25);
				}

				else if(rand ==26){
					 card26.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 7;
					 add(card26);
				}

				else if(rand ==27){
					 card27.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 7;
					 add(card27);
				}

				else if(rand ==28){
					 card28.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 7;
					 add(card28);
				}

				else if(rand ==29){
					 card29.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 8;
					 add(card29);
				}

				else if(rand ==30){
					 card30.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 8;
					 add(card30);
				}

				else if(rand ==31){
					 card31.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 8;
					 add(card31);
				}

				else if(rand ==32){
					 card32.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 8;
					 add(card32);
				}

				else if(rand ==33){
					 card33.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 9;
					 add(card33);
				}

				else if(rand ==34){
					 card34.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 9;
					 add(card34);
				}

				else if(rand ==35){
					 card35.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 9;
					 add(card35);
				}

				else if(rand ==36){
					 card36.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 9;
					 add(card36);
				}

				else if(rand ==37){
					 card37.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card37);
				}

				else if(rand ==38){
					 card38.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card38);
				}

				else if(rand ==39){
					 card39.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card39);
				}

				else if(rand ==40){
					 card40.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card40);
				}

				else if(rand ==41){
					 card41.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card41);
				}

				else if(rand ==42){
					 card42.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card42);
				}

				else if(rand ==43){
					 card43.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card43);
				}

				else if(rand ==44){
					 card44.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card44);
				}

				else if(rand ==45){
					 card45.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card45);
				}

				else if(rand ==46){
					 card46.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card46);
				}

				else if(rand ==47){
					 card47.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card47);
				}

				else if(rand ==48){
					 card48.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card48);
				}

				else if(rand ==49){
					 card49.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card49);
				}

				else if(rand ==50){
					 card50.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card50);
				}

				else if(rand ==51){
					 card51.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card51);
				}

				else if(rand ==52){
					 card52.setBounds( 710-dealerCardCounter*90 , 20,250,250);
					 dealerCardValue = 10;
					 add(card52);
				}
				// Adds 1 to the number of cards in the dealer's hand and increaes the dealer's hand value by the value of the card
				dealerCardCounter++;
				dealerHandValue = dealerHandValue + dealerCardValue;
				// Saves the index used in the output
				usedValues[usedCardIndex] = rand;
				usedCardIndex++;
				// Prints the value of the dealer's hand
				dealerHandLabel.setText("The dealer's current hand value is " + dealerHandValue + ".");
				add(dealerHandLabel);
			}
			// Condition if the player beat the dealer since the dealer had a hand value greater than 21
			if(dealerHandValue > 21 && playerHandValue <= 21){
				remove(backgroundLabel);
				add(buttonPlayAgain);
				add(backgroundLabel);

				WinnerWindow wonMatch = new WinnerWindow(Blackjack.this);
				wonMatch.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				wonMatch.setSize(300,100);
				wonMatch.setVisible(true);
				wonMatch.setLocation(300,300);
			}
			// Condition of a loss if the dealer's hand value does not exceed the value of 21 and is greater than the player's hand value
			else if(dealerHandValue > playerHandValue && dealerHandValue <=21|| dealerHandValue == 21 && playerHandValue <21){
				remove(backgroundLabel);
				add(buttonPlayAgain);
				add(backgroundLabel);

				LoserWindow lossMatch = new LoserWindow(Blackjack.this);
				lossMatch.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				lossMatch.setSize(300,100);
				lossMatch.setVisible(true);
				lossMatch.setLocation(300,300);
			}
			// Condition when the dealer and player have the same hand value and are both valued at less than 21
			else if(dealerHandValue == playerHandValue && dealerHandValue <=21 && playerHandValue <=21){
				remove(backgroundLabel);
				add(buttonPlayAgain);
				add(backgroundLabel);

				TieWindow tieMatch = new TieWindow(Blackjack.this);
				tieMatch.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				tieMatch.setSize(300,100);
				tieMatch.setVisible(true);
				tieMatch.setLocation(300,300);
			}
			
			
		}
	}
	// Main method arguments to set the settings of the JFrame
	public static void main(String[] args) {
		// Settings of JFrame
		Blackjack frameWindow = new Blackjack();
		
		frameWindow.setDefaultLookAndFeelDecorated(true);
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWindow.getContentPane().setBackground(Color.white);
		frameWindow.setLayout(null);
		frameWindow.setSize(1050,750);
		frameWindow.setVisible(true);

	}

}
