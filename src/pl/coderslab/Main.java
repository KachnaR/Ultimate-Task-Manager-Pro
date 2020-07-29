package pl.coderslab;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String [][] tasks = new String [0][0];
    public static void main(String[] args) {
        tasks = LoadTasks("tasks.csv");
        System.out.println(ConsoleColors.BLUE + "Please select an option"+ ConsoleColors.RESET + "\nadd\nremove\nlist\nexit\n");
        Scanner scanner = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "add":
                    addTasks();
                    break;
                case "remove":
                    removeTasks();
                    break;
                case "list":
                    listTasks();
                    break;
                case "exit":
                    exit();
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
        }
    }
    public static String[][] LoadTasks(String TaskList){
        Path path1 = Paths.get(TaskList);
        String [][] TaskArr = new String [0][3];
        try {
            for (String line : Files.readAllLines(path1)) {
                TaskArr = Arrays.copyOf (TaskArr, TaskArr.length + 1);
                TaskArr[TaskArr.length -1] = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } return TaskArr;
    }
    public static void addTasks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        System.out.println("Please add task due date");
        String dueDate = scanner.nextLine();
        System.out.println("Is your task is important: true/false");
        String Important = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length +1);
        tasks[tasks.length - 1] = new String [3];
        tasks[tasks.length -1][0] = description;
        tasks[tasks.length -1][1] = dueDate;
        tasks[tasks.length -1][2] = Important;

    }
    public static void listTasks() {
        for (int i = 0; i < tasks.length ; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length ; j++) {
                System.out.print(tasks[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void removeTasks() {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove");
        while (true) {
            int Output = scanner.nextInt();
            if (Output >= 0 && Output < tasks.length) {
                tasks = ArrayUtils.remove(tasks, Output);
                break;
            } else {
                System.out.println("Wrong index. Please choose a number between 0 and " + (tasks.length - 1));
            }
        }
    }
    public static void exit() {
        try {
            PrintWriter printWriter = new PrintWriter("tasks.csv");
            for (int i = 0; i < tasks.length ; i++) {
                printWriter.println(tasks[i][0] + "," + tasks[i][1] + "," + tasks[i][2]);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(ConsoleColors.RED + "Bye, bye." + ConsoleColors.RESET);
    }
}
