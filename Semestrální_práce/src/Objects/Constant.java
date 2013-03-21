/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author TOMHP
 */
public class Constant extends Expr {
    double cislo;
    
    public Constant(double cislo){
    this.cislo = cislo;
    }
    
    @Override
    double evaluate() {
         return (double)cislo;
    }

    
    @Override
    Expr log() {
       if(cislo>0){
        return new Constant(Math.log10(cislo));
       }
        System.out.println("Logaritmus lze pocitat pouze z nezapornych cisel");
       return null;
    }
    
    @Override
    Expr square(){
        return new Constant(Math.sqrt(cislo));
    
    }

    @Override
    Expr divide() {
        return new Constant(cislo);
    }

    
}
