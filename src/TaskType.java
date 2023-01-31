public  enum TaskType {
    WOR("Рабочая"),
    PER("Личная");
    String taskTypeName;

    TaskType(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public void setTaskTypeName(String taskTypeName) {
        this.taskTypeName = taskTypeName;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }
}
