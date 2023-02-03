import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String taskName, String taskBody, TaskType taskType, LocalDateTime date) throws InputErrorException {
        super(taskName, taskBody, taskType, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return ((dateForChecking.isAfter(getDate().toLocalDate()) || dateForChecking.isEqual(getDate().toLocalDate())) && (getDate().getDayOfYear() - dateForChecking.getDayOfYear()) % 7 == 0 && (getDate().getDayOfYear() - dateForChecking.getDayOfYear()) != 0);
    }

}
