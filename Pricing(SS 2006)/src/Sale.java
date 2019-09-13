public class Sale {
    private long preDiscountTotal; //catalog price
    private ISalePricing pricing;


    public Sale(long preDiscountTotal, ISalePricing pricing)
    {
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal(){

        return this.preDiscountTotal;
    }

    //desired pricing logic
    public void setPricing(ISalePricing pricing){

    }

    // determines the final price of the product after all registerd discounts have been applied
    public long getTotal(){
        return pricing.getTotal(new Sale(preDiscountTotal,pricing));
    }

    //return ISalePricing
    public static ISalePricing createPricing(DiscountType discountType, double percentage , long discount, long threshold){


        if(discountType.equals(DiscountType.PERCENTAGEDISCOUNT) && discount == 0 && threshold == 0){
            PercentageDiscountPricing percentagePricing = new PercentageDiscountPricing(percentage);
            return percentagePricing;

        }else if(discountType.equals(DiscountType.ABSOLUTEDISCOUNT) && percentage == 0){
            AbsoluteDiscountPricing absolutePricing = new AbsoluteDiscountPricing(discount, threshold);
            return absolutePricing;
        }

        return null;
    }
}
