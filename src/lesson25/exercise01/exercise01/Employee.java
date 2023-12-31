package lesson25.exercise01.exercise01;

public abstract class Employee implements TaskHandler {

    private final TaskProgressCallback callback;
    private final String name;
    private final Task.Status taskStatus;


    protected Employee(TaskProgressCallback callback,
                       String name,
                       Task.Status taskStatus) {
        this.callback = callback;
        this.name = name;
        this.taskStatus = taskStatus;
    }

    public boolean doTask(Task task) {
        boolean canHandle = taskStatus == task.getStatus();
        if (canHandle) {
            System.out.println(getClass().getSimpleName() + " " + name + " is doing task " + getDetails(task));
            callback.updateTask(getTaskWhenDone(task));
        }
        return canHandle;
    }

    protected abstract Task getTaskWhenDone(Task task);

    protected abstract String getDetails(Task task);
}
