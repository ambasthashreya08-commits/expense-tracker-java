import java.io.*;
import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            Expense expense = new Expense(category, amount);

            try {

                FileWriter writer =
                        new FileWriter("expenses.txt", true);

                writer.write(expense.toString() + "\n");

                writer.close();

                System.out.println("Expense saved successfully.");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else if (choice == 2) {

            double total = 0;

            try {

                BufferedReader reader =
                        new BufferedReader(
                                new FileReader("expenses.txt"));

                String line;

                while ((line = reader.readLine()) != null) {

                    System.out.println(line);

                    String[] parts = line.split(",");

                    total += Double.parseDouble(parts[1]);
                }

                System.out.println("----------------");
                System.out.println("Total Expense: " + total);

                reader.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}