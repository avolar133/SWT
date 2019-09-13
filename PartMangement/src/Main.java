public class Main {

    public static void main(String[] args) {

        Part p1 = Factory.createPart(PartType.SINGLE_COMPONENT,"1234","Wood");

        Part p2 = Factory.createPart(PartType.RESOURCE,"3321","gold");

        Part p3 = Factory.createPart(PartType.RESOURCE,"5555","silver");


       ReceivingStock myStock = new ReceivingStock(1,100);

       Purchasing purchasing = new Purchasing(myStock);

       Factory myFactory = new Factory(purchasing, myStock);

       System.out.println(myStock.insert(p1,100));
       System.out.println(myStock.insert(p2,50));
       System.out.println(myStock.insert(p3,10));




       SingleComponent sc = new SingleComponent("3", "name");
       System.out.println(myStock.insert(sc,15));


    }
}
