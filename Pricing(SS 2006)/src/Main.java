public class Main {

    public static void main(String[] args) {

        ISalePricing p1,p2,p3,p4,p5;
        p1 = new PercentageDiscountPricing(10.0); // 9000
        p2 = new PercentageDiscountPricing(5.0); // 9500
        p3 = new AbsoluteDiscountPricing(500, 5000); // 9500
        p4 = new AbsoluteDiscountPricing(3000, 9000); // 9000
        p5 = new AbsoluteDiscountPricing(1900, 8000); // 8100

        Sale testSale = new Sale(10000,p1);


        BestForStorePricing p = new BestForStorePricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        testSale.setPricing(p);
        System.out.println(testSale.getTotal());
    }


}
