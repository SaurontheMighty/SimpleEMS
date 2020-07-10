public class EmployeeInfo {

    
    // ATTRIBUTES
    private int empNum;
    private String firstName;
    private String lastName;
    private int gender; // encode e.g. 0 for M, 1 for F, etc.
    private int workLoc; // encode e.g. 0 for Mississauga, etc.
    private double deductRate; // e.g. 0.21 for 21%
    
    
    // CONSTRUCTORS
    
    public EmployeeInfo(int eN, String fN, String lN, int g, int wL, double dR) {
    	empNum = eN;
    	firstName = fN;
    	lastName = lN;
    	gender = g;
    	workLoc = wL;
    	deductRate = dR;
    }
    
    
    // METHODS
    
    public int getEmpNum() {
    	return empNum;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public int getGender() {
    	return gender;
    }
    
    public int getWorkLoc() {
    	return workLoc;
    }
    
    public double getDeductRate() {
    	return deductRate;
    }
    
}