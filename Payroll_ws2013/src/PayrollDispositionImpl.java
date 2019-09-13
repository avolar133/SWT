import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition{

    private Map<Employee,Double> payments;

    public PayrollDispositionImpl(){

        this.payments = new HashMap<>();

    }

    public double getTotal(){
        double total = 0;
        for (double payment : payments.values()){
            total += payment;
        }
        return  total;
    }

    public double getAverage(){
        /*double total = 0;
        double anzahl = 0;
        for (double payment : payments.values()){
            if (payment == 0){

            }else{
            total += payment;
            anzahl ++;
            }
        }
        return  (total/anzahl);

         */
        double total = 0;
        double anzahl = 0;
        for (double payment : payments.values()){
            if (payment != 0){
                total += payment;
                anzahl ++;
            }
        }

        if (anzahl != 0){
            return (total/anzahl);
        }else{
            return 0;
        }


    }

    public Map<Employee, Double> getPayments() {
        return payments;
    }

    @Override
    public void sendPayment(Employee empl, double payment) {
        if (payment <= 0){
            throw new IllegalArgumentException("payment cannot be negativ");
        }else if (empl == null){
            throw new NullPointerException("Employee is empty!");
        }else {
            payments.put(empl,payment);
        }
    }
}
