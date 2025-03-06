package assignment;

class Hand {
	  private Card[] cards;
	  private int count;

	  public Hand() {
	    // Create an empty array of cards with a maximum capacity of 5 cards
	    cards = new Card[5];
	    count = 0;
	  }

	  public void add(Card card) {
	    // Add the card to the hand and increment the count
	    cards[count] = card;
	    count++;
	  }

	  public int getTotal() {
	    // Compute the total value of the cards in the hand
	    int total = 0;
	    for (int i = 0; i < count; i++) {
	      Card card = cards[i];
	      total += card.getValue();
	    }
	    return total;
	  }

	  // Override the toString() method to return a string representation of the hand
	  @Override
	  public String toString() {
	    String handString = "";
	    for (int i = 0; i < count; i++) {
	      if (i > 0) {
	        handString += ", ";
	      }
	      handString += cards[i].toString();
	    }
	    return handString;
	  }
	}
