import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Task extends  ProjectItem {
    public List<ProjectItem> projectItems;


    public Task(String name, String details, double rate){
        super(name, details, rate);
        this.projectItems = new ArrayList<>();
    }

    @Override
    public double getTimeRequired() {
        double timeRequired = 0;
        for (ProjectItem item: projectItems){
            if (item.getClass().getName().equals("Deliverable")){
                timeRequired += item.getTimeRequired();
            }else{
                timeRequired += item.getTimeRequired();
            }

        }
        return timeRequired;
        /*List<Deliverable> deliverables = this.allDeliverables();
        double timeRequired = 0;
        for (Deliverable deliverable: deliverables){
            timeRequired += deliverable.getTimeRequired();
        }

        return timeRequired;
        */
    }

    @Override
    public long getMaterialCost() {
        /*long materialCost = 0;
        for (ProjectItem item: projectItems){
            if (item.getClass().getName().equals("Deliverable")){
                materialCost += item.getCostEstimate();
            }else{
                long taskCost = item.getMaterialCost();
                materialCost += taskCost;
            }

        }*/

        long materialCost = 0;
        for (ProjectItem item: projectItems){
            materialCost += item.getMaterialCost();
        }
        return materialCost;

    }

    public void addProjectItem(ProjectItem pi){
        if (pi == null){
            throw new NullPointerException("projectItem is null");
        }

        projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi){
        if (pi == null){
            throw new NullPointerException("projectItem is null");
        }

        ListIterator<ProjectItem> itr = projectItems.listIterator();

        while (itr.hasNext()){
            ProjectItem nextElement = itr.next();
            if (nextElement.equals(pi)){
                itr.remove();
            }

        }
    }

    public List<Deliverable> allDeliverables(){
        List<Deliverable> deliverables = new ArrayList<>();

        for (ProjectItem pi: projectItems){
           if (pi.getClass().getName().equals("Deliverable")){
               deliverables.add((Deliverable)pi);
           }else{
               Task tempTask = (Task)pi;
               deliverables.addAll(tempTask.allDeliverables());
           }
        }
        return deliverables;
    }
}
