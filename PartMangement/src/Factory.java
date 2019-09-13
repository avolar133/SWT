public class Factory {

    private Purchasing purchasing;
    private ReceivingStock receivingStock;

    public Factory(Purchasing purchasing, ReceivingStock receivingStock){
        if (purchasing == null || receivingStock == null){
            throw new NullPointerException("Factory got a null variable");
        }
        this.purchasing = purchasing;
        this.receivingStock = receivingStock;
        receivingStock.addObserver(purchasing);
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public ReceivingStock getReceivingStock(){
        return receivingStock;
    }

    public static Part createPart(PartType partType, String id, String name){

        if (partType == null){
            throw new NullPointerException("Part type is null");
        }else if (id == "" || name == ""){
            throw new IllegalArgumentException("id or name is empty");
        }else if(id == null || name == null){
            throw new NullPointerException("id or name is null");
        }


        if (partType.equals(PartType.COMPONENTS)){
            return new Components(id, name);
        }else if(partType.equals(PartType.SINGLE_COMPONENT)){
            return new SingleComponent(id, name);
        }else {
            return new Resource(id, name);
        }
    }
}
