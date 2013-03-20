/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author TOMHP
 */
public abstract class Expr {
    abstract double evaluate();
 
    abstract Expr derive(char var);
 
    abstract Expr simplify();
    
}
