public class BestForStorePricing extends ComplexPricing {

    public BestForStorePricing(ISalePricing pricing){
        super(pricing);
    }

    public long getTotal(Sale sale){
        /*long lastPricing = 0;
        for (ISalePricing element : getPricings()){
            long afterDiscount = element.getTotal(sale);
            System.out.println("afterDiscount = " + afterDiscount + " ,lastPricing = " +lastPricing);

            if(afterDiscount > lastPricing ){
                lastPricing = afterDiscount;
            }
        }
        return lastPricing;*/


        long originalPrice = sale.getPreDiscountTotal();
        long afterDiscount = 0;

        for (ISalePricing element : getPricings()){
           if (element.getTotal(sale) > afterDiscount && element.getTotal(sale) != originalPrice){
               afterDiscount = element.getTotal(sale);
           }

        }
        return afterDiscount;

    }
}
