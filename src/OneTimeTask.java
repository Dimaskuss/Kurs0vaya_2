import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String taskName, String taskBody, TaskType taskType, LocalDateTime date) throws InputErrorException {
        super(taskName, taskBody, taskType, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return (dateForChecking.isEqual(getDate().toLocalDate()));
    }
}
