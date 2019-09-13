public class Appointee extends Employee {

    private int payday;
    private int hoursPerMonth;
    private double payPerHour;

    public Appointee(String id, int payday,int hoursPerMonth , double payPerHour){
        super(id);

        if (!(payPerHour > 0) ) {

            throw new IllegalArgumentException("Invalid pay per Hour rate");

        }else {
            this.payPerHour = payPerHour;
        }

        if (payday < 1 || payday > 31){
            throw new IllegalArgumentException("Invalid payday");

        }else{
            this.payday = payday;
        }
        if (hoursPerMonth < 1){
            throw new IllegalArgumentException("Invalid hours");
        } else {
            this.hoursPerMonth = hoursPerMonth;
        }
        this.payPerHour = payPerHour;

    }


    @Override
    public boolean isPayday(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            try {
                throw new IllegalArgumentException("There is no such a day");
            } catch (IllegalArgumentException e) {

            }
        }
        if (dayOfMonth == payday){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public double calculateDeductions() {
        double grossPayment;
        try{
            calculatePay();
            grossPayment  = hoursPerMonth * payPerHour;

        }catch (UnpayableEmployeeException e){
             grossPayment  = hoursPerMonth * payPerHour;
        }

        double deductions = grossPayment * 0.4;
        return deductions;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException{


        double grossPayment = hoursPerMonth * payPerHour;


        return grossPayment;

    }
}