import java.time.LocalDate;
import java.util.*;


public class Main {

    public static Map<Integer, Task> tasks1 = new HashMap<>();

    static int count = 0;

    static int id;

    public static void main(String[] args) throws InputErrorException {


        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            deleteTask(scanner);
                            break;
                        case 3:
                            getTaskForDate(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }

        }
        System.out.println(tasks1);





        }




    private static void inputTask(Scanner scanner) throws InputErrorException {


        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();


        System.out.print("Введите саму задачу: ");
        String taskBody = scanner.next();

        System.out.print("Укажите текстом тип задачи < WOR / PER > : ");

//
      TaskType taskType = TaskType.valueOf(scanner.next());
//

        System.out.print("Укажите цифрой индекс повторяемости задачи - \n" +
                "1 - однократная,\n" +
                "2 - ежедневная,\n" +
                "3 - еженедельная,\n" +
                "4 - ежемесячная,\n" +
                "5 - ежегодная.\n" +
                "Выбранный тип : ");

        int repeatabilityType = Integer.parseInt(scanner.next());

        count++;
        id = count;


        new Task(taskName, taskBody, taskType, repeatabilityType);


        tasks1.put(id, new Task(taskName, taskBody, taskType, repeatabilityType));


        try {
            new Task(taskName, taskBody, taskType, repeatabilityType).checkInputErrors();
        } catch (InputErrorException e) {
            System.out.println("Процесс создания оборвался . Создайте задачу заново введя корректные данные");

            tasks1.remove(id);

            inputTask(scanner);

        }


    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Введите ID задачи которую хотите удалить : ");
        int deleteNumber = Integer.parseInt(scanner.next());
        tasks1.remove(deleteNumber);
        System.out.println(" Задача "+ deleteNumber +" удалена ");



    }

    private static void getTaskForDate(Scanner scanner){

        System.out.print("Введите день: ");
        int day = Integer.parseInt(scanner.next());
        System.out.print("Введите месяч: ");
        int month = Integer.parseInt(scanner.next());
        System.out.print("Введите год: ");
        int year = Integer.parseInt(scanner.next());
        LocalDate date = LocalDate.of(year,month,day);

      for(Task task : tasks1.values()) // одноразовая задача (день в день)
            if (task.getRepeatabilityType()==1 && task.getDate().getDayOfMonth()==date.getDayOfMonth() && task.getDate().getYear() == date.getYear() && task.getDate().getMonthValue()== date.getMonthValue())
                System.out.println(task);
      for(Task task : tasks1.values()) // каждый день
            if (task.getRepeatabilityType()==2 )
                System.out.println(task);
      for(Task task : tasks1.values()) // каждую неделю
            if (task.getRepeatabilityType()==3 && (task.getDate().getDayOfYear()-date.getDayOfYear())%7==0 && (task.getDate().getDayOfYear()-date.getDayOfYear())!=0)
                System.out.println(task);
      for(Task task : tasks1.values()) // каждый месяц
            if (task.getRepeatabilityType()==4 && task.getDate().getDayOfMonth()==date.getDayOfMonth() && task.getDate().getYear() == date.getYear() && task.getDate().getMonthValue()!= date.getMonthValue())
                System.out.println(task);
      for(Task task : tasks1.values()) // каждый год
            if (task.getRepeatabilityType()==5 && task.getDate().getDayOfMonth()==date.getDayOfMonth() && task.getDate().getYear() != date.getYear() && task.getDate().getMonthValue()== date.getMonthValue())
                System.out.println(task);


    }


    private static void printMenu() {
        System.out.println(
                """
                        1. Добавить задачу
                        2. Удалить задачу
                        3. Получить задачу на указанный день
                        0. Выход
                        """
        );
    }


}