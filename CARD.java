public class CARD {

    private RANK rank;
    private SUIT suit;
    public CARD next;
    private CARD previous;


    public CARD(RANK r, SUIT s, CARD next)
    {
        rank = r;
        suit = s;
    }

    public CARD()
    {

    }

    public CARD(RANK r, SUIT s)
    {
        rank = r;
        suit = s;
    }


    public SUIT getSuit()
    {
        return this.suit;
    }

    public RANK getRank()
    {
        return this.rank;
    }

    public CARD getNext(){return this.next;}

    public void setNext(CARD c){next = c;}

}
