import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String taskName, String taskBody, TaskType taskType, LocalDateTime date) throws InputErrorException {
        super(taskName, taskBody, taskType, date);
    }

    @Override
    public boolean appearsIn(LocalDate dateForChecking) {
        return ((dateForChecking.isAfter(getDate().toLocalDate()) || dateForChecking.isEqual(getDate().toLocalDate())) && dateForChecking.getYear() != getDate().getYear() && getDate().getMonthValue() == dateForChecking.getMonthValue() && getDate().getDayOfMonth() == dateForChecking.getDayOfMonth());
    }
}
