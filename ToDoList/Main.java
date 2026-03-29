import java.util.*;
class Main{
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        TaskManager taskManage=new TaskManager();
        boolean f=true;
        while(f){
            System.out.print("\n1->Add New Task\n2->View Tasks\n3->view Prioritywise\n4->View Tasks Under Category\n0->Exit\n");
            System.out.print("Enter Choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    taskManage.addTask();
                    break;
                case 2:
                    taskManage.viewTask();
                    break;
                case 3:
                    taskManage.viewPrioritywise();
                    break;
                case 4:
                    taskManage.viewCategorywise();
                    break;
                case 0:
                    f=false;
                    break;
            }
        }
        sc.close();
    }
}