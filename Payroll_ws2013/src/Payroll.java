import java.util.List;

public class Payroll {
    //private int payday;
    private PayrollDisposition disposition;
    private int payday;

    public Payroll(PayrollDisposition disposition, int payday){
        if (disposition == null){

            throw new NullPointerException("disposition is null");

        }else if( payday < 1 || payday > 31 ){

            throw new IllegalArgumentException("Illegal payday");

        }else {

            this.payday = payday;
            this.disposition = disposition;

        }

    }

    public void doPayroll(PayrollDB db){
        /*List<Employee> list= db.getEmployeeList();
        for (Employee empl : list){
            double payment = empl.calculatePay() - empl.calculateDeductions();
        }*/

        List<Employee> dbList = db.getEmployeeList();


         for (Employee a: dbList){
             if (a.isPayday(payday)) {

                 double calcPay;
                 try {
                     calcPay = a.calculatePay();
                 } catch (UnpayableEmployeeException e) {
                     calcPay = 0;
                 }

                 double payment = calcPay - a.calculateDeductions();
                 if (!(payment <= 0)) {
                     disposition.sendPayment(a, payment);
                 }
             }

         }

    }


}
