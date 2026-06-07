# Expense Tracker

A Java-based console application for tracking daily expenses.

## Features

- Add expense
- View expenses
- Store expenses in file
- Expense summary

## Tech Stack

(Java + OOP + File Handling)
Java
File Handling

## Running the Application

This project is a **console-based Java Expense Tracker**. All interactions are performed through the terminal/command prompt.

### Compile the Project

Before running the application, compile the Java source files:

```bash
javac Expense.java ExpenseTracker.java
```

### Run the Application

Execute the following command:

```bash
java ExpenseTracker
```

### Available Options

After running the program, you will see:

```text
===== Expense Tracker =====
1. Add Expense
2. View Expenses
3. Category Summary
4. Exit
```

### Example Usage

#### Add an Expense

```text
Enter Choice: 1
Category: Food
Amount: 300
```

Output:

```text
Expense saved successfully.
```

#### View All Expenses

```text
Enter Choice: 2
```

Output:

```text
Expense History:
Food,300.0
Travel,500.0
----------------------
Total Expense: 800.0
```

#### View Category Summary

```text
Enter Choice: 3
```

Output:

```text
===== Category Summary =====
Food: 300.0
Travel: 500.0
Shopping: 0.0
Other: 0.0
```

#### Exit the Application

```text
Enter Choice: 4
```

Output:

```text
Exiting...
```

### Data Storage

All expenses are stored in the `expenses.txt` file, ensuring data persistence across multiple application runs.
