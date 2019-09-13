import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        PayrollDispositionImpl disposition = new PayrollDispositionImpl();
        Map<Employee, Double> payments = new HashMap<>();

        Employee e1 = new Appointee("a1", 21, 205, 13);
        Employee e2 = new Appointee("a2", 21, 120, 25);
        Employee e3 = new Appointee("a3", 21, 163, 11);
        Employee e4 = new Appointee("a4", 21, 87, 10);
        Employee e5 = new Appointee("a5", 21, 111, 31);

        payments.put(e1, 1599.0);
        payments.put(e2, 1800.0);
        payments.put(e3, 1075.8);
        payments.put(e4, 522.0);
        payments.put(null, 55.0);


        for (Map.Entry<Employee, Double> e : payments.entrySet()) {
            disposition.sendPayment(e.getKey(), e.getValue());
            System.out.println(e.getKey()+ " and " + e.getValue());
        }

        System.out.println(disposition.getAverage());


    }
}
