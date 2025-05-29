package utilitybox;

public class Task {
    String name;
    boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String toString() {
        return (done ? "[x] " : "[ ] ") + name;
    }
}

