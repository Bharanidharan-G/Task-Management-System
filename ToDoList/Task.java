import java.util.*;

class Task{
    private final int taskId;
    private String taskName;
    private String description;
    private String dueDate;
    private Priority priority;
    private List<String> category;
    public Task(int taskId,String taskName,String description,String dueDate,Priority priority,List<String> category){
        this.taskId=taskId;
        this.taskName=taskName;
        this.description=description;
        this.dueDate=dueDate;
        this.priority=priority;
        this.category=category;
    }
    public int getId(){
        return taskId;
    }
    public String getName(){
        return taskName;
    }
    public String getDescription(){
        return description;
    }
    public String getDate(){
        return dueDate;
    }
    public Priority getPriority(){
        return priority;
    }
    public List<String> getCategory(){
        return category;
    }
}