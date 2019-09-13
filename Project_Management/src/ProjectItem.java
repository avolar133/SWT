public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate){
        if (name == null || details == null){
            throw new NullPointerException("Name or details are null in projectItem");
        }else if(name == "" || details == "" || rate<= 0){
            throw new IllegalArgumentException("name, details or rate is Illegal in ProjectItem");
        }
        this.name = name;
        this.details = details;
        this.rate = rate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public long getCostEstimate(){
        double workCost = Math.round(getTimeRequired() * rate);

        long materialCost = getMaterialCost();


        return (long)workCost + materialCost;





        /*
       double workCost = getTimeRequired() * rate;
       long materialCost = getMaterialCost();
       return  (long)workCost + materialCost;

         */

    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();

}
