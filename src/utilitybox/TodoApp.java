package utilitybox;

import java.util.Scanner;

public class TodoApp {
    private static final TaskManager manager = new TaskManager("data/tasks.txt");

    public static void run(Scanner scanner) {
        while (true) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Mark Task Done");
            System.out.println("4. Remove Task");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Task name: ");
                    String name = scanner.nextLine();
                    manager.addTask(new Task(name));
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    manager.listTasks();
                    System.out.print("Task number to mark done: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        manager.markDone(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "4":
                    manager.listTasks();
                    System.out.print("Enter task number to remove: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        manager.removeTask(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                case "0":
                    manager.saveTasks();
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}

