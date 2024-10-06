import java.util.Random;

public class Task {
    private static int NUMBER_OF_TASKS = 0;
    private static int TASK_ID = 0;
    private String taskName;
    private Integer taskId;
    private Integer executionTime;

    private void initTask() {
        NUMBER_OF_TASKS++;
        Random random = new Random();
        this.taskId = this.generateId();
        this.taskName = "Task " + this.taskId;
        this.executionTime = random.nextInt(1, 21);
        System.out.println("Init method for task: " + taskName);
    }

    public void destroyTask() {
        NUMBER_OF_TASKS--;
        System.out.println("Destroyed Task " + this.taskName);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public void run() throws InterruptedException {
        System.out.println("Running task: " + this.taskName + " with execution time: " + this.executionTime);
        Thread.sleep(this.executionTime);
    }

    private Integer generateId() {
        return TASK_ID++;
    }

    public static int getNumberOfTasks() {
        return NUMBER_OF_TASKS;
    }
}
