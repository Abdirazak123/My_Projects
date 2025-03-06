package assignment;

class Deck {
	  private Card[] cards;
	  private int count;

	  public Deck() {
	    // Create an array of 52 cards (13 cards of each suit)
	    cards = new Card[52];
	    int index = 0;
	    for (int suit = 0; suit < 4; suit++) {
	      for (int value = 1; value <= 13; value++) {
	        // Create a new card with the current suit and value
	        Card card = new Card(suit, value);
	        cards[index] = card;
	        index++;
	      }
	    }

	    // Set the initial count to the full deck of 52 cards
	    count = 52;
	  }

	  public void shuffle() {
	    // Shuffle the cards using the Fisher-Yates shuffle algorithm
	    for (int i = count - 1; i > 0; i--) {
	      int j = (int) (Math.random() * (i + 1));
	      Card temp = cards[i];
	      cards[i] = cards[j];
	      cards[j] = temp;
	    }
	  }

	  public Card deal() {
	    // Decrement the count and return the card at the current count index
	    if (count > 0) {
	      count--;
	      return cards[count];
	    } else {
	      return null;
	    }
	  }
	}
