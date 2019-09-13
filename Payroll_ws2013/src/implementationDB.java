import java.util.ArrayList;
import java.util.List;

public class implementationDB implements PayrollDB {
    private List<Employee> myArray;

    public implementationDB(){
        myArray = new ArrayList<>();
    }

    @Override
    public List<Employee> getEmployeeList() {
        return myArray;
    }
}
