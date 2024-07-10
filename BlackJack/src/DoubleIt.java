import java.util.Scanner;

    public class DoubleIt {
        public static boolean doubleBet(Scanner scanner, Deposit deposit, int bet_entry) {
            if (deposit.getBalance() >= bet_entry) {
                System.out.print("Do you want to double your bet? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    deposit.withdrawFunds(bet_entry);
                    System.out.println("Bet doubled! New bet: " + (bet_entry * 2) + " $");
                    System.out.println("Deposit after doubling bet: " + deposit.getBalance() + " $");
                    return true;
                }
            } else {
                System.out.println("You don't have enough funds to double the bet.");
            }
            return false;
        }
    }

