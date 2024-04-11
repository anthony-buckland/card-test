package za.co.aboutblank;

import za.co.aboutblank.exceptions.InvalidCardException;
import za.co.aboutblank.exceptions.InvalidHandException;

public class Main {
    public static void main(String[] args) {
        // check if the length of args array is < 0
        if (args.length == 0) {
            System.out.println("No card details.");
        } else {
            try {
                if (args.length != 5) {
                    throw new InvalidHandException("Too many or too few cards. Please count. I can only do 5 at a time");
                } else {
                    for (String index : args) {
                        System.out.println(index);
                    }
                }
            }
            catch(InvalidHandException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}