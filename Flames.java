/* F L A M E S game created using JAVA programming language */

import java.util.Scanner; //importing Scanner class for taking input

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Creating scanner object
        System.out.print("Boy name: ");          
        String ogboy = input.nextLine().toLowerCase(); // Converting to lowercase for easy programming
        System.out.print("Girl name: ");
        String oggirl = input.nextLine().toLowerCase(); // Converting to lowercase for easy programming
        StringBuilder boy = new StringBuilder(ogboy);  // Copying the String value into the StringBuilder
        StringBuilder girl = new StringBuilder(oggirl); // because StringBuilder is 'mutable'
        System.out.println();
        System.out.println("Before Removing common characters: ");
        System.out.println(boy + " " + girl);  // Unprocessed String
        System.out.println();
        int count = 0, total_length = 0;
        for(int b = 0; b < boy.length(); b++) { // Iterating the String and comparing the common chars 
            boolean found = false;              // and changing the value to '0'
            for(int g = 0; g < girl.length(); g++) {
                if(boy.charAt(b) == girl.charAt(g)) {
                    count += 1;
                    boy.setCharAt(b,'0');
                    girl.setCharAt(g,'0');
                    break;
                }
            }
        }
        total_length = (boy.length() - count) + (girl.length() - count); // to find total length of processed String
        System.out.println("After removing common characters: ");
        System.out.print(boy.toString().replaceAll("0","") + " "); // replacing '0' with "";
        System.out.println(girl.toString().replaceAll("0","")); // replacing '0' with "";
        System.out.println("Number of uncommon characters: " + total_length + "\n"); // printing length of processed String
        
        flames(ogboy, oggirl, total_length);
    }
    
    static void flames(String boy, String girl, int count) {
        int index = 0;
        String flames = "FLAMES";
        StringBuilder flamesblock = new StringBuilder(flames);
        while(flamesblock.length() > 1) {
            index = (index + count - 1) % flamesblock.length(); // FLAMES LOGIC 
            flamesblock.deleteCharAt(index);
        }
        // Using if else to print whether the boy and girl are Freinds/Lovers/Affection/Marriage/Enemies/Sister
        if(flamesblock.toString().equals("F")) {
            System.out.println(boy + " and " + girl + " are 'Friends'");
        }
        else if(flamesblock.toString().equals("L")) {
            System.out.println(boy + " and " + girl + " are 'Lovers'");
        }
        else if(flamesblock.toString().equals("A")) {
            System.out.println(boy + " and " + girl + " have 'Affection'");
        }
        else if(flamesblock.toString().equals("M")) {
            System.out.println(boy + " and " + girl + " will 'Marry'");
        }
        else if(flamesblock.toString().equals("E")) {
            System.out.println(boy + " and " + girl + " are 'Enemies'");
        }
        else {
            System.out.println(girl + " and " + boy + " are 'Siblings'");
        }
    }
}
