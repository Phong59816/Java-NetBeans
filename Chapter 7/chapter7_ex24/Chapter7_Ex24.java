
package chapter7_ex24;

/*
Name: Phong Tran
Date : 10/03/21
Project: Programming project Exercise 7.24
Description: This program simulate the random picking of cards from a 52 cards deck
and putting it back until all 4 suits are picked.
*/
public class Chapter7_Ex24 {

    public static void main(String[] args) {
        //create array of card suits and ranks
        String [] suits = {"Clubs","Diamonds","Hearts","Spades"};
        String [] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack",
            "Queen","King"};
        //create boolean array to keep track of suit found
        boolean[] found = new boolean[4];
        //number of cards picked
        int picks = 0;
        //counter for loop
        int count = 0;
        //loop until all 4 suits is found
        while(count < 4){
            //increment pick as card get pick
            picks++;
            //generate random a number between 0 - 51
            int index = (int) (Math.random() * 52);
            //if suit is not already found
            if(!found[index / 13]){
                found[index / 13] = true;
                count++;
                //generate random suit index 0 - 3
                String suit = suits[index / 13];
                //generate random rank index 0 - 12
                String rank = ranks[index % 13];
               //print first card of each suit picked
                System.out.println(rank + " of " + suit);
            }
            
        }
        //print number of picks
        System.out.println("Number of picks: " + picks);
        
    }
}
