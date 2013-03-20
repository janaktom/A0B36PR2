/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author TOMHP
 */
public class Variable extends Expr{

    @Override
    double evaluate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    Expr derive(char var) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    Expr simplify() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
