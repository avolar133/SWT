// calculates the selling price based on the largest discount for the customer
public class BestForCustomerPricing extends ComplexPricing {

    public BestForCustomerPricing(ISalePricing pricing){
        super(pricing);
    }

    public long getTotal(Sale sale){
        long lastPricing = sale.getPreDiscountTotal();

        for (ISalePricing element : getPricings()){
            long afterDiscount = element.getTotal(sale);
            if(afterDiscount < lastPricing){
                lastPricing = afterDiscount;
            }
        }
        return lastPricing;
    }
}
