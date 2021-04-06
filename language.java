import java.util.Scanner;

public class language {
    public static void main(String[] args) {
        int choice = 0;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\tLanguage Menu:\n\t1. English to English\n\t2. English to Marathi\n\t3. Marathi to English\n\t4. Marathi to Marathi\n\t5. Exit");
        
        do {
            System.out.println("\tEnter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\tYou've chosen English to English meaning.");
                    // call methods
                    break;
                
                case 2:
                    System.out.println("\tYou've chosen English to Marathi meaning.");
                    // call methods
                    break;

                case 3:
                    System.out.println("\tYou've chosen Marathi to English meaning.");
                    // call methods
                    break;
                
                case 4:
                    System.out.println("\tYou've chosen Marathi to Marathi meaning.");
                    // call methods
                    break;
                
                case 5: 
                    System.out.println("\tYou're exiting.");
                    break;

                default: 
                    System.out.println("\tInvalid choice.");
                    break;
            }
            
        } while (choice != 5);
        
        scanner.close();            //avoid data leak
    }
}
