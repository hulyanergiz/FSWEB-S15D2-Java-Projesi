import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
    }
    public Set<Task> getTasks(String assignee){
        if(assignee=="ann"){
           return annsTasks;
        }else if(assignee=="bob"){
            return bobsTasks;
        }else if(assignee=="carol"){
            return carolsTasks;
        }else if(assignee=="all"){
        return getUnion(annsTasks,bobsTasks,carolsTasks);
        }
        return new HashSet<>();
        }
    public Set<Task> getUnion(Set<Task>... sets){
        HashSet<Task> allTasks=new HashSet<>();
        for(Set<Task> set:sets){
            allTasks.addAll(set);
        }
        return allTasks;
    }
    public Set<Task> getIntersect(Set<Task> first,Set<Task> second){
        Set<Task> intersections=new HashSet<>(first);
        intersections.retainAll(second);
        return intersections;
    }
    public Set<Task> getDifference(Set<Task> main, Set<Task> willRemove){
        Set<Task> difference=new HashSet<>(main);
        difference.removeAll(willRemove);
        return difference;
    }

    @Override
    public String toString() {
        return "TaskData{" +
                "annsTasks=" + annsTasks +
                ", bobsTasks=" + bobsTasks +
                ", carolsTasks=" + carolsTasks +
                '}';
    }
}
