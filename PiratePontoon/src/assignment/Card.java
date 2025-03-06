package assignment;

class Card {
	  private int suit;
	  private int value;

	  public Card(int suit, int value) {
	    this.suit = suit;
	    this.value = value;
	  }

	  public int getSuit() {
	    return suit;
	  }

	  public int getValue() {
	    return value;
	  }

	  // Override the toString() method to return a string representation of the card
	  @Override
	  public String toString() {
	    String suitString;
	    switch (suit) {
	      case 0:
	        suitString = "Hearts";
	        break;
	      case 1:
	        suitString = "Diamonds";
	        break;
	      case 2:
	        suitString = "Spades";
	        break;
	      case 3:
	        suitString = "Clubs";
	        break;
	      default:
	        suitString = "";
	        break;
	    }

	    String valueString;
	    switch (value) {
	      case 1:
	        valueString = "Ace";
	        break;
	      case 2:
	        valueString = "2";
	        break;
	      case 3:
	        valueString = "3";
	        break;
	      case 4:
	        valueString = "4";
	        break;
	      case 5:
	        valueString = "5";
	        break;
	      case 6:
	        valueString = "6";
	        break;
	      case 7:
	        valueString = "7";
	        break;
	      case 8:
	        valueString = "8";
	        break;
	      case 9:
	        valueString = "9";
	        break;
	      case 10:
	        valueString = "10";
	        break;
	      case 11:
	        valueString = "Jack";
	        break;
	      case 12:
	        valueString = "Queen";
	        break;
	      case 13:
	        valueString = "King";
	        break;
	      default:
	        valueString = "";
	        break;
	    }

	    return valueString + " of " + suitString;
	  }
	}
