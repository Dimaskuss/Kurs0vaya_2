public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(Integer id) {
        super("Задача с таким id не найдена");
    }
}
