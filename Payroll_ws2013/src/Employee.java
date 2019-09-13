abstract class Employee  {

    private String id;

    public Employee(String id){
        if (id == null ){
            throw new NullPointerException("id cannot be empty");
        }else if (id == ""){
            throw new IllegalArgumentException("id cannot be empty");
        }else {
            this.id = id;
        }
    }

    public Employee(){
        throw new IllegalArgumentException("Employee should never passed empty");
    }

    public String getId(){
        return id;
    }
    // determines whether the given day is the payday of the employee.
    public abstract boolean isPayday(int dayOfMonth);

    // determines the (gross) salary of the employee but in some cases throws an UnpayableEmployeeException instead
    public abstract double calculatePay() throws UnpayableEmployeeException;

    public abstract double calculateDeductions();

}
