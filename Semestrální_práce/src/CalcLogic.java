/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOMHP
 */
public class CalcLogic {
    
    //-- Instance variables.
    private double currentTotal;   // The current total is all we need to remember.
    
    /** Constructor */
    public CalcLogic() {
        currentTotal = 0;
    }
    
    public String getTotalString() {
        return "" + currentTotal;
    }
    
    public void setTotal(String n) {
        currentTotal = convertToNumber(n);
    }
    
    public void add(String n) {
        currentTotal += convertToNumber(n);
    }
    
    public void subtract(String n) {
        currentTotal -= convertToNumber(n);
    }
    
    public void multiply(String n) {
        currentTotal *= convertToNumber(n);
    }
    
    public void divide(String n) {
        currentTotal /= convertToNumber(n);
    }
    
    public void Minus(String n){
        currentTotal  = -Double.parseDouble(n);
    }
    
    public void ReverseTotal(String n){
        currentTotal = 1/Double.parseDouble(n);
    }
    
    public void sinus(Double n){
        currentTotal = Math.sin(Math.toRadians(n));
    }
    
    public void cos(Double n){
        currentTotal = Math.cos(Math.toRadians(n));
    }
    
    public void tan(Double n){
        currentTotal = Math.tan(Math.toRadians(n));
    }
    

    
    private double convertToNumber(String n) {
        return Double.parseDouble(n);
    }
    

}
