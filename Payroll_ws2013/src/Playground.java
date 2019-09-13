public class Playground extends Employee{
    public Playground(String id) {
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        return 0;
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }



}
