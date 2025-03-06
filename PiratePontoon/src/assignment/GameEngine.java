package assignment;


import java.util.Scanner;

class GameEngine {
	  private Deck deck;
	  private Hand playerHand;
	  private Hand dealerHand;

	  public GameEngine() {
	    // Create a deck of cards and shuffle it
	    deck = new Deck();
	    deck.shuffle();

	    // Create empty hands for the player and the dealer
	    playerHand = new Hand();
	    dealerHand = new Hand();
	  }
	
	  public void play() {
		  System.out.println("Welcome to Pirate Pontoon");
		  Scanner scanner = new Scanner(System.in);
		  System.out.print("What is your name? ");
			String name = scanner.nextLine();
		  while (true) {
		    // Deal two cards to the player and the dealer
		    playerHand.add(deck.deal());
		    playerHand.add(deck.deal());
		    dealerHand.add(deck.deal());
		    dealerHand.add(deck.deal());

		    // Check if the player has a Pontoon (i.e., a hand of two cards with a total value of 21)
		    if (playerHand.getTotal() == 21) {
		      System.out.println(name = "has a Pontoon and wins!");
		      break;
		    }

		    // The player can choose to hit (i.e., take another card) or stand (i.e., keep their current hand)
		    boolean hit = true; // Assume the player hits
		    while (hit) {
		      // Check if the player's total is over 21 (i.e., they have busted)
		      if (playerHand.getTotal() > 21) {
		        System.out.println(name + " has busted and loses!");
		        break;
		      }

		      // Ask the player if they want to hit or stand
		      System.out.println("Your hand: " + playerHand + " (total: " + playerHand.getTotal() + ")");
		      System.out.println("Hit or Stand (H/S): ");
		      Scanner input = new Scanner(System.in);
		      char c = input.next().charAt(0);
		      if (c == 'S')   {
		        hit = false;
		      } else {
		        // Deal another card to the player
		        playerHand.add(deck.deal());
		      }
		    }

		    // The dealer plays according to the following rules:
		    // - If the dealer's total is less than 17, they must hit
		    // - If the dealer's total is 17 or more, they must stand
		    while (dealerHand.getTotal() < 17) {
		      dealerHand.add(deck.deal());
		    }

		    // Check if the dealer has busted
		    if (dealerHand.getTotal() > 21) {
		      System.out.printf("Dealer has busted and %s wins!" , name);
		      break;
		    }

		    // Compare the player's and dealer's hands to determine the winner
		    if (playerHand.getTotal() > dealerHand.getTotal()) {
		      System.out.println(name + " wins!");
		    } else if (playerHand.getTotal() < dealerHand.getTotal()) {
		      System.out.println("Dealer wins!");
		    } else {
		      System.out.println("It's a tie!");
		    }

		    // Ask the player if they want to play again
		    System.out.println("Play again (Y/N): ");
		    Scanner input = new Scanner(System.in);
		      char c = input.next().charAt(0);
		    if (c == 'N') {
		      break;
		    }
		    

		    // Reset the deck, player hand, and dealer hand for the next game
		    deck = new Deck();
		    deck.shuffle();
		    playerHand = new Hand();
		    dealerHand = new Hand();
		  }
		}
}
