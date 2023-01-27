
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task  {

    private String taskName;
    private String taskBody;
    private final TaskType taskType;


    private int id;

     int  repeatabilityType;


    private final LocalDate date;


    public Task(String taskName, String taskBody, TaskType taskType, int repeatabilityType) {

        this.taskName = taskName;

        this.taskBody = taskBody;
        this.taskType = taskType;
        this.repeatabilityType = repeatabilityType;

        this.date = LocalDate.now();




    }



    public void checkInputErrors() throws InputErrorException {
        if (taskName.isBlank() || taskName.isEmpty()) {
            throw new InputErrorException("Введите название");
        }
        if (taskBody.isBlank() || taskBody.isEmpty()) {
            throw new InputErrorException("Введите Здачу");
        }
        if ((!Objects.equals(taskType, "PER")) || (!Objects.equals(taskType, "WOR")) || taskType.toString().isEmpty() || taskType.toString().isBlank()) {
            throw new InputErrorException("Правильно введите тип задачи");
        }
        if (repeatabilityType < 1 || repeatabilityType > 5) {
            throw new InputErrorException("Введите правильный номер от 1 до 5!");
        }
    }

    public void setRepeatabilityType(int repeatabilityType) {
        this.repeatabilityType = repeatabilityType;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public  int getRepeatabilityType() {
        return repeatabilityType;
    }

    public LocalDate getDate() {
        return date;
    }



    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskBody() {
        return taskBody;
    }

    public void setTaskBody(String taskBody) {
        this.taskBody = taskBody;
    }




    @Override
    public String toString() {
        return  " дэйлик "+repeatabilityType+
                " Name='" + taskName + '\'' +
                ", taskBody='" + taskBody + '\'' +

                ", date=" + date +
                '}';
    }


}

