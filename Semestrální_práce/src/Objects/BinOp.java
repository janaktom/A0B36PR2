/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author TOMHP
 */
public class BinOp extends Expr {
    
    char operator;
    Expr leva, prava;
    
    
    public BinOp(char operand, Expr leva, Expr prava) {
        this.operator = operand;
        this.leva = leva;
        this.prava = prava;
    }
    
    
    @Override
    double evaluate() {
        switch (operator) {
            case '*':
                return leva.evaluate() * prava.evaluate();
            case '/':
                return leva.evaluate() / prava.evaluate();
            case '+':
                return leva.evaluate() + prava.evaluate();
            case '-':
                return leva.evaluate() - prava.evaluate();
            default:
                System.out.println("chyba");
                return -1;
        }
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
