public class AbsoluteDiscountPricing implements ISalePricing{
    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold){
        if(discount <0 || threshold <0){
            throw new IllegalArgumentException("discount cannot be negativ");
        }else {
            this.discount = discount;
            this.threshold = threshold;
        }
    }

    public long getTotal(Sale sale){



        long preDiscout = sale.getPreDiscountTotal();
        long afterDiscount = preDiscout - discount;
        if ( preDiscout< threshold){
            return preDiscout;
        }else if(afterDiscount < threshold){
            return threshold;
        }else {
            return afterDiscount;
        }
        /*
        long afterDiscount = preDiscout - discount;
        if (afterDiscount < threshold){
            return preDiscout;
        }else{
            return afterDiscount;
        }
        */

    }
}
