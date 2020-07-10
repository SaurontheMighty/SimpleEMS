public class FTE extends EmployeeInfo {
    
    /**
     *
     */
    public double yearlySalary;
    
    /**
     *
     * @param eN
     * @param fN
     * @param lN
     * @param s
     * @param wL
     * @param dR
     * @param yS
     */
    public FTE(int eN, String fN, String lN, int g, int wL, double dR, double yS) {
        super(eN, fN, lN, g, wL, dR);
        yearlySalary = yS;
        
    }
    
}