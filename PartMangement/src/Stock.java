import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Stock {
    protected Map<Part,Integer> parts;
    private List<StockObserver> listOfObservers;


    public Stock(){
        parts = new HashMap<>();
        listOfObservers = new ArrayList<>();
    }

    public int getCount(Part part){
        if (part == null) throw new NullPointerException("part is null");
        Integer amount = parts.get(part);
        if (amount == null){
            return -1;
        }else{
            return amount;
        }
    }

    public boolean insert(Part part, int amount){
        if (part == null){
            throw new NullPointerException("You cannot insert empty part");
        }else if(amount <= 0){
            throw new IllegalArgumentException("Amount is negativ or zero");
        }



        if (parts.containsKey(part)){ // This part is already in our map
            int lastAmount = parts.get(part);
            parts.replace(part,lastAmount + amount);

            notifyPartCountChanged(part); // notify if there are inserted parts

            return true;
        }else{
            // this part is not exist yet. Add it to parts (hashMap)

            parts.put(part, amount);
            return true;
        }

        //notifyPartCountChanged(part); // notify if there are inserted parts
        //return true;
    }

    public boolean remove(Part part, int amount){

        if (part == null){
            throw new NullPointerException("You cannot insert empty part");
        }else if(amount <= 0){
            throw new IllegalArgumentException("Amount is negativ or zero");
        }



        if(parts.containsKey(part)){
            int lastAmount = parts.get(part);
            if (lastAmount < amount){
                return false;
            }else {
                parts.replace(part,lastAmount-amount);
                notifyPartCountChanged(part); // notify if there are removed parts
                return true;
            }
        }else {
            return false;
        }
    }

    public void addObserver(StockObserver observer){
        if (observer == null) throw new NullPointerException("Observer is null");
        listOfObservers.add(observer);
    }

    private void notifyPartCountChanged(Part part){
        int amount;

        amount = parts.get(part);

        for (StockObserver observer: listOfObservers){
            observer.onPartCountChanged(part, amount);
        }

    }



}
