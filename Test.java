public class Test
{
    public static void main(String[] args)
    {
        CARD_DECK cd = new CARD_DECK();

        for(SUIT s: SUIT.values())
        {
            for(RANK r: RANK.values())
            {
                cd.add(new CARD(r,s));
            }
        }


        for(int i=0; i <52; i++)
        {
            cd.showAll();
        }

    }




}
