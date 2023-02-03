import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements RepeatabilityMethod {
    private String taskName;
    private String taskBody;
    private TaskType taskType;

    private static int count;

    private int id;

    private LocalDateTime date;

    public Task(String taskName, String taskBody, TaskType taskType, LocalDateTime date) throws InputErrorException {
        setTaskName(taskName);
        setTaskBody(taskBody);
        setTaskType(taskType);
        setDate(date);
        count++;
        this.id = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskBody;
    }

    public void setTaskName(String taskName) throws InputErrorException {
        if (taskName != null) {
            this.taskName = taskName;
        } else {
            throw new InputErrorException("не введено имя");
        }

    }

    public String getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(String taskBody) throws InputErrorException {
        if (taskBody != null) {
            this.taskBody = taskBody;
        } else {
            throw new InputErrorException("не введено имя");
        }
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) throws InputErrorException {
//        if ((!Objects.equals(taskType.toString(), "PER")) || (!Objects.equals(taskType.toString(), "WOR")) || taskType.toString().isEmpty() || taskType.toString().isBlank()) {
//            throw new InputErrorException("введите правильный тип задачи PER/WOR");
//        } else {
            this.taskType = taskType;
        }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) throws InputErrorException {
        if (date != null) {
            this.date = date;
        } else {
            throw new InputErrorException("дата и время не указанны");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(taskName, task.taskName) && Objects.equals(taskBody, task.taskBody) && taskType == task.taskType && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName, taskBody, taskType, id, date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", taskBody='" + taskBody + '\'' +
                ", taskType=" + taskType +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
