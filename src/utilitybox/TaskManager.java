package utilitybox;

import java.io.*;
import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String filePath;

    public TaskManager(String filePath) {
        this.filePath = filePath;
        loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
    }

    public void markDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).done = true;
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void saveTasks() {
        try {
            File dir = new File("data");
            if (!dir.exists()) {
                dir.mkdir();
            }
            PrintWriter out = new PrintWriter(new FileWriter(filePath));
            for (Task t : tasks) {
                out.println((t.done ? "1" : "0") + ";" + t.name);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Failed to save tasks.");
        }
    }

    public void loadTasks() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(";", 2);
                Task t = new Task(parts[1]);
                t.done = parts[0].equals("1");
                tasks.add(t);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Failed to load tasks.");
        }
    }
}

