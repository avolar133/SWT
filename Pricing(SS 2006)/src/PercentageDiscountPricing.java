public class PercentageDiscountPricing implements ISalePricing {
    private double percentage;

    public PercentageDiscountPricing(double percentage){

        this.percentage = percentage;
    }

    public long getTotal(Sale sale){
        long preDiscount = sale.getPreDiscountTotal();
        long returnPrice = preDiscount - (long)(preDiscount*(percentage/100));

        return returnPrice;
    }
}
