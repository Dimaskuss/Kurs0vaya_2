import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ServiceTask {

    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Collection<Task> taskCollection = new HashSet<>();


    public void addTask(Task task) {
        this.taskMap.put(task.getId(), task);
    }

    public void removeTask(int id) throws TaskNotFoundException {
        if (this.taskMap.containsKey(id)) {
            taskCollection.add(taskMap.get(id));
            this.taskMap.remove(id);
            System.out.println("удаленные задачи :");
            System.out.println(taskCollection);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

    public void getAllByDate(LocalDate dateForChecking) {
        for (Task task : taskMap.values())
            if (task.appearsIn(dateForChecking)) {
            System.out.println(task);
        }
    }

    public void showAllTasks() {
        for (Task task : taskMap.values()) {
            System.out.println(task);
        }
    }
}


