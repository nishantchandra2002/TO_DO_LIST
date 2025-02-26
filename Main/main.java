package Main;
import dataStructures.TaskManager;
import Models.Task;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class main {
    public static void main(String[]args){
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== To-Do List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addTask(taskManager, scanner);
                    break;
                case 2:
                    removeTask(taskManager, scanner);
                    break;
                case 3:
                    markTaskCompleted(taskManager, scanner);
                    break;
                case 4:
                    viewTasks(taskManager);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
    private static void addTask(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter priority (higher number = higher priority): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter deadline (YYYY-MM-DD): ");
        String deadlineStr = scanner.nextLine();
        LocalDate deadline = LocalDate.parse(deadlineStr);

        taskManager.addTask(description, priority, deadline);
        System.out.println("Task added successfully!");
    }
    private static void removeTask(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter task ID to remove: ");
        String taskId = scanner.nextLine();

        taskManager.remove_Task(taskId);
        System.out.println("Task removed successfully (if found)!");
    }
    private static void markTaskCompleted(TaskManager taskManager, Scanner scanner) {
        System.out.print("Enter task ID to mark as completed: ");
        String taskId = scanner.nextLine();

        taskManager.MarkTaskCompleted(taskId);
        System.out.println("Task marked as completed (if found)!");
    }
    private static void viewTasks(TaskManager taskManager) {
        List<Task> tasks = taskManager.getAllTasksSort();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
        } else {
            System.out.println("\n===== Task List =====");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }

    }
    
}

