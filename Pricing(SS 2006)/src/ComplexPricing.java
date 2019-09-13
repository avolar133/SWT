import java.util.ArrayList;
import java.util.List;

abstract class ComplexPricing implements ISalePricing {
    private List<ISalePricing> pricings ;

    public ComplexPricing(ISalePricing pricing){

        pricings = new ArrayList<>();
        pricings.add(pricing);
    }

    public ComplexPricing(){};

    // abstract class without abstract method-> can only be inherited
    public void add(ISalePricing pricing){

        pricings.add(pricing);
    }

    // discount calculation is performed here. (also in BestForCustomerPricing and BestForStorePricing)
    public List<ISalePricing> getPricings() {
        // return ISalePricing
        return pricings;
    }
}
