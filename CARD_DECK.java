public class CARD_DECK<T> implements ADT<T>
{
    //Setting up some variables that will be used in methods below
    private CARD first;
    public int size;
    private CARD last;

    public CARD_DECK()
    {
        initializeDeck();
    }//Constructor created

    private void initializeDeck()//initialising the Deck
    {
        first = null;
        size = 0;
    }

    public void add(CARD newEntry) //adding cards into the Deck
    {
        if (isEmpty())
        {
         first = newEntry;
        }
        else{
            CARD last = getCard(size);
            last.setNext(newEntry);
        }
        size++;
    }

    public void addAt(int position, CARD newEntry) //used within the find method in order to move cards
    {
        if (position >= 1 && position <= size)
        {
            if (position >= 1 && position <= size)
            {
                if (position == 1) {
                    newEntry.setNext(first);
                    first = newEntry;
                } else {
                    CARD prev = getCard(position - 1);
                    CARD after = prev.getNext();
                    newEntry.setNext(after);
                    prev.setNext(newEntry);
                }
                size++;
            }
        }
    }

    public void remove(int position)//used within the find method to remove cards that were moved.
    {
        if(position == 1)
        {
            first = first.getNext();
        }
        else if (position == size)
        {
            last = getCard(position-1);
        }
        else
        {
            CARD prev = getCard(position-1);
            CARD toRemove = prev.getNext();
            CARD after = toRemove.getNext();
            prev.setNext(after);
        }
        size--;
    }
    private boolean isEmpty()//checking if the size of the Deck is empty
    {
        boolean result;
        if(size == 0)
        {
            return true;
        }
        return false;
    }

    public void reveal() {
    System.out.println(first.getRank().toString() + " " +  first.getSuit().toString());//Method to reveal the top card
    }

    public int find(String rank, String suit)//finding the card that the user is looking for and then showing found method
    {
      int found = 0;
      for (int i=0; i<= size; i++)
      {
          if (rank.equals(getCard(i).getRank().toString()) && suit.equals(getCard(i).getSuit().toString()))
          {
              found = i;
          }

      }
        return found;//returning position found to the console
    }


    public void inShuffle() //method for in shuffle
    {
        //get half of deck
        int half = size/2;
        CARD[] arrayCD = new CARD[half];
        CARD[] arrayCD2 = new CARD[half];

        for(int i=0; i<half; i++)
        {
            arrayCD[i] = getCard(i+1);
            arrayCD2[i] = getCard(i+27);
        }

        initializeDeck();

        for(int i=0; i <arrayCD.length; i++)
        {
            this.add(arrayCD2[i]);
            this.add(arrayCD[i]);
        }
    }
    public void outShuffle() //method for out shuffle
    {
        int half = size/2;
        CARD[] arrayCD = new CARD[half];
        CARD[] arrayCD2 = new CARD[half];

        for(int i=0; i<half; i++)
        {
            arrayCD[i] = getCard(i+1);
            arrayCD2[i] = getCard(i+27);
        }

        initializeDeck();

        for(int i=0; i <arrayCD.length; i++)
        {
            this.add(arrayCD[i]);
            this.add(arrayCD2[i]);
        }
    }

    public void showAll() // shows all the cards in the Deck
    {
        CARD current = first;

        for(int i = 1; i<=size; i++)
        {
            System.out.println(current.getRank().toString() + " " + current.getSuit().toString());
            current = current.getNext();
        }
    }

    public void shuffle()//random card shuffle
    {
    for (int i = 1; i <= size; i++)
    {
        int random = (int) (Math.random() * (size - 1))+1;

        CARD temp = getCard(i);
        remove(i);
        addAt(random, temp);
    }
    }

    public CARD getCard(int position)//Shows Card at position given.
    {
        //add check to input
        CARD current = first;

        for(int i = 1; i < position; i++)
        {
            current = current.getNext();
        }

        assert current!=null;

        return current;
    }
}
