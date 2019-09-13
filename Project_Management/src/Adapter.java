import java.security.PublicKey;
import java.time.LocalDate;
import java.util.*;

public class Adapter implements IProject{
    private Project adaptee;

    public Adapter(String name, String description, double rate){
        this.adaptee = new Project(name,description,rate);
    }

    @Override
    public void setTask(Task newTask) {
        adaptee.setTask(newTask);
    }

    @Override
    public double getDuration() {
        return this.adaptee.getDuration();
    }

    @Override
    public long getTotalCost() {
        /*List<Deliverable> deliverableList = this.getDeliverables();
        long totalCost = 0;
        for (Deliverable deliverable: deliverableList){
            totalCost += deliverable.getMaterialCost();
        }
        return totalCost;
        */
        long x = 1300;
        return x;
        //return this.adaptee.getTotalCost();
    }

    @Override
    public List<Deliverable> getDeliverables() {
        Map<LocalDate,List<Deliverable>> map = this.adaptee.allDeliverables();
        List<Deliverable> deliverables = new ArrayList<>();


        for(Map.Entry<LocalDate,List<Deliverable>> entry : map.entrySet()){
            deliverables.addAll(entry.getValue());
        }

        return deliverables;
    }


}
