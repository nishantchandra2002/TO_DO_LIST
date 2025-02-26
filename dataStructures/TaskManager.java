package dataStructures;
import Models.Task;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Comparator;
public class TaskManager {
    private LinkedList<Task>taskList;
    public TaskManager() {
        taskList = new LinkedList<>();
    }
    public void addTask(String description,int priority,LocalDate deadline){
        Task newTask=new Task(description,priority,deadline);
        taskList.add(newTask);
    }
    public void remove_Task(String taskId){
        Iterator<Task> iterator = taskList.iterator();
        while(iterator.hasNext()){
            Task task=iterator.next();
            if(task.getID().equals(taskId)){
                iterator.remove();
                return;

            }
        }
        System.out.println("Task not found!");

    }
    public void MarkTaskCompleted(String taskId){
        for(Task task:taskList){
            if(task.getID().equals(taskId)){
                task.markCompleted();
                return;
            }
        }
        System.out.println("Task not found!");

    }
    public List<Task> getAllTasksSort(){
        taskList.sort(Comparator.comparingInt(Task::getPriority)
            .thenComparing(Task::getDeadline));
            return taskList;
    }
    public List<Task> getAllTasks() {
        return taskList;
    }
    
}

