import java.io.*;
import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Category Summary");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Category: ");
                String category = sc.nextLine();

                System.out.print("Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

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

                    System.out.println("\nExpense History:");

                    while ((line = reader.readLine()) != null) {

                        System.out.println(line);

                        String[] parts = line.split(",");

                        total += Double.parseDouble(parts[1]);
                    }

                    System.out.println("----------------------");
                    System.out.println("Total Expense: " + total);

                    reader.close();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 3) {

                double foodTotal = 0;
                double travelTotal = 0;
                double shoppingTotal = 0;
                double otherTotal = 0;

                try {

                    BufferedReader reader =
                            new BufferedReader(
                                    new FileReader("expenses.txt"));

                    String line;

                    while ((line = reader.readLine()) != null) {

                        String[] parts = line.split(",");

                        String category = parts[0];
                        double amount =
                                Double.parseDouble(parts[1]);

                        if (category.equalsIgnoreCase("Food")) {
                            foodTotal += amount;
                        } else if (category.equalsIgnoreCase("Travel")) {
                            travelTotal += amount;
                        } else if (category.equalsIgnoreCase("Shopping")) {
                            shoppingTotal += amount;
                        } else {
                            otherTotal += amount;
                        }
                    }

                    System.out.println("\n===== Category Summary =====");
                    System.out.println("Food: " + foodTotal);
                    System.out.println("Travel: " + travelTotal);
                    System.out.println("Shopping: " + shoppingTotal);
                    System.out.println("Other: " + otherTotal);

                    reader.close();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 4) {

                System.out.println("Exiting...");
                break;

            } else {

                System.out.println("Invalid Choice.");
            }
        }

        sc.close();
    }
}