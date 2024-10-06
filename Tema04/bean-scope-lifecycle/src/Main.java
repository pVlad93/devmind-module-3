import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Opening context:");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Create 5 tasks
        List<Task> taskList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            taskList.add(context.getBean("task", Task.class));
        }
        System.out.println();

        // Run all tasks
        for(Task task: taskList) {
            task.run();
        }

        System.out.println();
        // Destroy task 3
        taskList.get(3).destroyTask();
        taskList.remove(3);

        // Number of tasks
        System.out.println("Number of tasks after destroying Task3: " + Task.getNumberOfTasks());

        System.out.println();
        // Add 2 new tasks
        taskList.add(context.getBean("task", Task.class));
        taskList.add(context.getBean("task", Task.class));

        System.out.println("Adding 2 new tasks");
        System.out.println("Number of tasks: " + Task.getNumberOfTasks());

        for(Task task: taskList) {
            task.destroyTask();
        }

        System.out.println("Closing context");
        context.close();
    }
}
