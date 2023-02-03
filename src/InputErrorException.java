public class InputErrorException extends Exception {
private String argument;
    public InputErrorException(String argument) {
        getArgument();
    }

    public String getArgument() {
        return "не хорошо ты делаешь";
    }

    @Override
    public String toString() {
        return "InputErrorException{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
