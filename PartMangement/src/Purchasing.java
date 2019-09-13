public class Purchasing implements StockObserver{

    // department which performs actions on its stock as required (here: buy()).
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock receivingStock){
        if (receivingStock == null){
            throw new NullPointerException("receivingStock is null");
        }

        this.receivingStock = receivingStock;
    }

    public void buy(Part part, int count){
        receivingStock.insert(part , count);
    }

    public ReceivingStock getStock(){
        return receivingStock;
    }

    @Override
    public void onPartCountChanged(Part part, int count) {
        int min = receivingStock.getMinStockItems();
        int max = receivingStock.getMaxStockItems();

        if (count < min){

            buy(part, max - count);
        }
    }
}
