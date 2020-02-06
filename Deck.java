import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Deck
{

    public static void main (String[] args)
    {
        CARD_DECK cd = new CARD_DECK();
        CARD_DECK cd1 = new CARD_DECK();
        CARD_DECK cd2 = new CARD_DECK();

        for (SUIT s : SUIT.values()) {
            for (RANK r : RANK.values())
            {
                cd.add(new CARD(r, s));
            }
        }

        //here we are doing the necessary prints before asking the user for input
        System.out.println("__________________________________________________");
        cd.showAll();
        System.out.println("__________________________________________________");
        cd.shuffle();
        cd.showAll();
        System.out.println("__________________________________________________");
        cd.reveal();
        System.out.println("__________________________________________________");

        System.out.println("Please enter an int between 2 and 52 in order to move top card to that position: ");
        Scanner sc = new Scanner(System.in);

        //here we are performing the different shuffles
        int input = sc.nextInt() - 1;
        String binary = Integer.toBinaryString(input);

        if (input <= cd.size && input >= 1) {

            for (int i = 0; i < binary.length(); i++)
            {
                if (binary.charAt(i) == '1')
                {
                    cd.inShuffle();

                }
                else
                    {
                    cd.outShuffle();

                    }
            }
            System.out.println("Card at position " + (input + 1) + " is " + cd.getCard(input + 1).getRank().toString() + " " + cd.getCard(input + 1).getSuit().toString());
            System.out.println("__________________________________________________");
            System.out.println("Write the RANK that you are looking for: ");
            String whatRank = sc.next();
            System.out.println("__________________________________________________");
            System.out.println("Write the SUIT that you are looking for: ");
            String whatSuit=sc.next();
            int found = cd.find(whatRank,whatSuit);
            System.out.println("__________________________________________________");
            if (found <= cd.size && found >= 1)
            {
                System.out.println(cd.getCard(found).getRank().toString() + " " + cd.getCard(found).getSuit().toString() + " is at position " + found);
            }
            else {
                System.out.println("You have entered an invalid card...");
            }
        }
        else
            {
            System.out.println("INVALID INPUT!");
            }
    }
    //System.out.println(binary);
}

