public class Volunteer extends Employee {


    public Volunteer(String id){

        super(id);
    }

    public Volunteer(){};

    @Override
    public double calculatePay() throws UnpayableEmployeeException{


            throw new UnpayableEmployeeException("Volunteer dont get paid");





    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return false;
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }
}
