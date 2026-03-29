import java.util.*;
import java.time.*;
import java.time.format.*;

class TaskManager{
    Scanner sc=new Scanner(System.in);
    HashMap<Integer,Task> tasks=new HashMap<>();
    public  void addTask(){
        System.out.print("Enter Task ID: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Name: ");
        String name=sc.nextLine();
        System.out.print("Enter Task Description: ");
        String description=sc.nextLine();
        String dueDate=null;
        while(dueDate==null){
            System.out.print("Enter Due Date (dd-MM-yyyy): ");
            dueDate=getDate();
        }
        System.out.print("Enter Priority: ");
        String pt=sc.nextLine().toUpperCase();
        Priority priority;
        if(pt.equals("")){
            priority=Priority.MEDIUM;
        }
        else{
            priority=Priority.valueOf(pt);
        }
        System.out.print("Enter Category: ");
        List<String> category = getInput();
        tasks.put(id,new Task(id,name,description,dueDate,priority,category));
    }
    public List<String> getInput(){
        String str=sc.nextLine();
        String[] arr=str.split(",");
        List<String> list=new ArrayList<>();
        for(String ch:arr){
            list.add(ch.trim());
        }
        return list;
    }
    public String getDate(){
        String date=sc.nextLine();
        try{
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
            LocalDate newDate=LocalDate.parse(date,formatter);
            LocalDate today=LocalDate.now();
            if(newDate.isBefore(today)){
                System.out.println("Date Cannot be in Past!");
                return null;
            }
            return date;
        
        }
        catch(Exception e){
            System.out.println("Invalid Date!");
            return null;
        }
        
    }
    public void viewTask(){
        for(Task task:tasks.values()){
            System.out.printf("Task ID: %-3d | Task Name: %-10s | Task Description: %-15s | Due Date: %-5s | Priority: %-3s | Category: %-15s\n",
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDate(),
                task.getPriority(),
                listTostr(task.getCategory())
            );
        }
    }
    public String listTostr(List<String> list){
        return String.join(", ",list);
    }
    public void viewPrioritywise(){
        TreeMap<Priority,List<Task>> p = new TreeMap<>();
        for(Task task:tasks.values()){
            Priority pty=task.getPriority();
            if(!p.containsKey(pty)){
                p.put(pty,new ArrayList<>());
            }
            p.get(pty).add(task);
        }
        
        for(Priority pty : p.keySet()){
            System.out.println("---------- "+pty+" Tasks ----------");
            for(Task task : p.get(pty)){
                System.out.printf("Task ID: %-3d | Task Name: %-10s | Task Description: %-15s | Due Date: %-5s | Priority: %-3s  | Category: %-15s\n",
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDate(),
                task.getPriority(),
                listTostr(task.getCategory())
            );
            }
        }
    }
    public void viewCategorywise(){
        HashMap<String,List<Task>> ct=new HashMap<>();
        for(Task task:tasks.values()){
            for(String category:task.getCategory()){
                if(!ct.containsKey(category)){
                    ct.put(category,new ArrayList<>());
                }
                ct.get(category).add(task);
            }
        }
        
        for(String category:ct.keySet()){
            System.out.println("---------- Task Under Category: "+category+"----------");
            for(Task task : ct.get(category)){
                    System.out.printf("Task ID: %-3d | Task Name: %-10s | Task Description: %-15s | Due Date: %-5s | Priority: %-3s  | Category: %-15s\n",
                    task.getId(),
                    task.getName(),
                    task.getDescription(),
                    task.getDate(),
                    task.getPriority(),
                    listTostr(task.getCategory())
                );
            }
        }
        
        
    }
}







