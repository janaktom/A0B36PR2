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
    @Override
    double evaluate() {
         return (double)cislo;
    }

    @Override
    Expr derive(char var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    double log() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
