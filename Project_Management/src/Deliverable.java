import java.time.LocalDate;

public class Deliverable extends ProjectItem{
    private long materialCost;
    private double productionTime;
    private LocalDate date;

    public Deliverable(String name, String details, double rate, long materialCost, double productionTime, LocalDate date ){
        super(name, details, rate);

        if (date == null){
            throw new NullPointerException("date is null in Deliverable");
        }else if(materialCost < 0 || productionTime <= 0 ){
            throw new IllegalArgumentException("Material or Production is smaller then 0 in Deliverable");
        }
        this.materialCost = materialCost;
        this.productionTime = productionTime;
        this.date = date;

    }

    @Override
    public double getTimeRequired() {
        return productionTime;
    }

    @Override
    public long getMaterialCost() {
        // added it because junit
        /*if (materialCost == 0){
            return 0;
        }
        return materialCost + getCostEstimate();
        */
        return materialCost;
    }

    public LocalDate getDate() {
        return date;
    }
}
