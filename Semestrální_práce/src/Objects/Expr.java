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

    abstract Expr divide();

    abstract Expr square();

    abstract Expr log();
    
    abstract Expr sin();
    
    abstract Expr cos();
    
    abstract Expr tan();
    
    abstract Expr sinh();
    
    abstract Expr cosh();
    
    abstract Expr tanh();
    
    abstract Expr exp();
    
    
}
