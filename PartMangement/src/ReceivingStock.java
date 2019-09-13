public class ReceivingStock extends Stock{

    private int minStockItems;
    private int maxStockItems;


    public ReceivingStock(int minStockItems, int maxStockItems){
        if (minStockItems < 0 || maxStockItems < 0 || maxStockItems <= minStockItems){
            throw new IllegalArgumentException("Something wrong with the max or min values");
        }else {
            this.minStockItems = minStockItems;
            this.maxStockItems = maxStockItems;
        }
    }

    public int getMinStockItems() {
        return minStockItems;
    }

    public int getMaxStockItems() {
        return maxStockItems;
    }

    @Override
    public boolean insert(Part part, int amount) {
        int currentAmount = 0;
        if (parts.containsKey(part)) {

             currentAmount = parts.get(part);
        }
        if (currentAmount + amount > maxStockItems){

            return false;
        }else {

            boolean stateInsert = super.insert(part, amount);
            return stateInsert;
        }


    }

    @Override
    public boolean remove(Part part, int amount) {



        boolean stateRemove = super.remove(part, amount);
        return stateRemove;


    }
}