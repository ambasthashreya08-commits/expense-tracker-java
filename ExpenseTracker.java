import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}