import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task annstask=new Task("Ann's task","Ann's task description","Ann",Priority.LOW,Status.IN_PROGRESS);
        Task annstask2=new Task("Ann's task","Ann's task2 description","Ann",Priority.MED,Status.IN_QUEUE);
        Task bobstask=new Task("Bob's task","Bob's task description","Bob",Priority.HIGH,Status.IN_QUEUE);
        Task bobstask2=new Task("Bob's task2","Bob's task2 description","Bob",Priority.MED,Status.ASSIGNED);
        Task carolstask=new Task("Carol's task","Carol's task description","Carol",Priority.HIGH,Status.IN_PROGRESS);
        Task carolstask2=new Task("Carol's task2","Carol's task2 description","Carol",Priority.LOW,Status.ASSIGNED);

        Task teamTask=new Task("Team task","Team task description","all",Priority.HIGH,Status.IN_PROGRESS);

        Set<Task> annsTasks=new LinkedHashSet<>();
        annsTasks.add(annstask);
        annsTasks.add(annstask2);
        annsTasks.add(teamTask);

        Set<Task> bobsTasks=new LinkedHashSet<>();
        bobsTasks.add(bobstask);
        bobsTasks.add(bobstask2);
        bobsTasks.add(teamTask);

        Set<Task> carolsTasks=new LinkedHashSet<>();
        carolsTasks.add(carolstask);
        carolsTasks.add(carolstask2);
        carolsTasks.add(teamTask);

        Set<Task> allTasks=new LinkedHashSet<>();
        allTasks.addAll(annsTasks);
        allTasks.addAll(bobsTasks);
        allTasks.addAll(carolsTasks);
        allTasks.add(teamTask);
        System.out.println("all tasks: "+allTasks);


        TaskData taskData=new TaskData(annsTasks,bobsTasks,carolsTasks);
        System.out.println("ann's tasks: "+taskData.getTasks("ann"));
        System.out.println("bob's tasks: "+taskData.getTasks("bob"));
        System.out.println("carol's tasks: "+taskData.getTasks("carol"));
        //System.out.println("ALL tasks: "+taskData.getTasks("all"));

        Set<Task> remainingTasksAfterAnnsTasksRemoved=taskData.getDifference(allTasks,annsTasks);
        System.out.println("all tasks without ann's tasks: "+remainingTasksAfterAnnsTasksRemoved);

        Set<Task> annsAndbobsTasksIntersection=taskData.getIntersect(annsTasks,bobsTasks);
        System.out.println("anns and bobs tasks intersection: "+annsAndbobsTasksIntersection);

        Set<Task> allTasksDifferenceFromAnnsTasks=taskData.getDifference(allTasks,annsTasks);
        System.out.println("all tasks difference from anns tasks: "+allTasksDifferenceFromAnnsTasks);


    }
}