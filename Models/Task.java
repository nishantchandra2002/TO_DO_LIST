package Models;
import java.time.LocalDate;
import java.util.UUID;
public class Task implements Comparable<Task>{
    private String Id;
    private String description;
    private int priority;
    private LocalDate deadline;
    private boolean isCompleted;

    public Task(String description,int priority,LocalDate deadline){
        this.Id=UUID.randomUUID().toString();
        this.description=description;
        this.priority=priority;
        this.deadline=deadline;
        this.isCompleted=false;
    }
    public String getID(){return Id;}
    public String getDescription(){return description;}
    public int getPriority(){return priority;}
    public LocalDate getDeadline(){return deadline;}
    public boolean isCompleted(){return isCompleted;}
    public void markCompleted(){
        this.isCompleted=true;
    }
    public int compareTo(Task other){
        if(this.priority!=other.priority){
            return Integer.compare(this.priority,other.priority);  
        }
        return this.deadline.compareTo(other.deadline);
    }
    @Override
    public String toString() {
        return "[ID: "+ Id +"]"+description +"|Priority:" +priority + " | Deadline: " + deadline + " | Completed: " + isCompleted;
    }

}
