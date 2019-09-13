import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private String name;
    private String description;
    private Task mainTask;
    private double rate;

    public Project(String name, String description, double rate){
        if (name == null || description == null){
            throw new NullPointerException("Project cunstructor");
        }else if(name == "" || description == "" || rate <= 0){
            throw new IllegalArgumentException("Project cunstructor");
        }
        this.name = name;
        this.description = description;
        this.rate = rate;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Task newTask){

        if (newTask == null)throw new NullPointerException("newTask is null");

        this.mainTask = newTask;
        /*if (this.mainTask == null){
            this.mainTask = newTask;
        }else{
            throw new IllegalArgumentException("Task is already initialized");
        }*/

    }

    public double getDuration(){
        return this.mainTask.getTimeRequired();
    }

    public long getTotalCost(){
        List<Deliverable> list = this.mainTask.allDeliverables();
        long cost = 0;
        for (Deliverable deliverable: list){

           cost += (deliverable.getMaterialCost() + (Math.round(deliverable.getTimeRequired() * rate)));
        }
        return cost;

    }

    public Map<LocalDate, List<Deliverable>> allDeliverables(){
        List<Deliverable> list = this.mainTask.allDeliverables();

        Map<LocalDate, List<Deliverable>> map = new HashMap<>();

        for(Deliverable deliverable: list){
            LocalDate date = deliverable.getDate();

            if (map.containsKey(date)){
                List<Deliverable> listPerDate= map.get(date);
                listPerDate.add(deliverable);
                map.replace(date,listPerDate);
            }else{
                List<Deliverable> listPerDate = new ArrayList<>();
                listPerDate.add(deliverable);
                map.put(date,listPerDate);
            }

        }

        return map;

    }

}
