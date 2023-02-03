import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String taskName, String taskBody, TaskType taskType, LocalDateTime date) throws InputErrorException {
        super(taskName, taskBody, taskType, date);
    }

    public boolean appearsIn(LocalDate dateForChecking) {
        return (dateForChecking.isAfter(getDate().toLocalDate()) || dateForChecking.isEqual(getDate().toLocalDate()));
    }
}
