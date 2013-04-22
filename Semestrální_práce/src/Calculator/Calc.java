package Calculator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOMHP
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calc extends JFrame {

    private static final Font BIGGER_FONT = new Font("monspaced", Font.PLAIN, 20);
    private JTextField screen;
    private boolean startingNumber = true;
    private String prevOp = "=";
    private CalcLogic logic = new CalcLogic();

    

    public Calc() {
        this.setTitle("Simple Calc");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
          
        ActionListener opListener = new OpListener();
        ActionListener numListener = new NumListener();
        ActionListener otherListener = new OtherListener();
        ActionListener piListener = new PiListener();
  
        
        screen = new JTextField("0", 12);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setFont(BIGGER_FONT);


        JButton clearButton = new JButton("Clear");
        clearButton.setFont(BIGGER_FONT);
        clearButton.addActionListener(new ClearListener());
        
        String buttonOrder = "789456123.0";
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3, 2, 2));
        for (int i = 0; i < buttonOrder.length(); i++) {
            String keyTop = buttonOrder.substring(i, i + 1);
            JButton b = new JButton(keyTop);
            b.addActionListener(numListener);
            b.setFont(BIGGER_FONT);
            buttonPanel.add(b);
        }
        
        JButton equals = new JButton("=");
        buttonPanel.add(equals);
        equals.addActionListener(opListener);
        equals.setFont(BIGGER_FONT);
        
        JPanel basicOp = new JPanel();
        basicOp.setLayout(new GridLayout(4, 1, 2, 2));
        
        JButton plus = new JButton("+");
        basicOp.add(plus);
        plus.addActionListener(opListener);
        plus.setFont(BIGGER_FONT);
        
        JButton minus = new JButton("-");
        basicOp.add(minus);
        minus.addActionListener(opListener);
        minus.setFont(BIGGER_FONT);
        
        JButton multi = new JButton("*");
        basicOp.add(multi);
        multi.addActionListener(opListener);
        multi.setFont(BIGGER_FONT);
        
        JButton div = new JButton("/");
        basicOp.add(div);
        div.addActionListener(opListener);
        div.setFont(BIGGER_FONT);
        
        JPanel opPanel = new JPanel();
        opPanel.setLayout(new GridLayout(4, 3, 2, 2));
        
       
      
        JButton sin = new JButton("sin");
        sin.addActionListener(opListener);
        opPanel.add(sin);
        sin.setFont(BIGGER_FONT);
        
        JButton square = new JButton("square");
        opPanel.add(square);
        square.addActionListener(opListener);
        square.setFont(BIGGER_FONT);
        
        
        
        JButton cos = new JButton("cos");
        opPanel.add(cos);
        cos.addActionListener(opListener);
        cos.setFont(BIGGER_FONT);
        
        JButton root = new JButton("root");
        opPanel.add(root);
        root.addActionListener(opListener);
        root.setFont(BIGGER_FONT);
        
        
        
        JButton tan = new JButton("tan");
        opPanel.add(tan);
        tan.addActionListener(opListener);
        tan.setFont(BIGGER_FONT);
        
        JButton rev = new JButton("1/x");
        opPanel.add(rev);
        rev.addActionListener(otherListener);
        rev.setFont(BIGGER_FONT);
        
        
        

        
        JButton pi = new JButton("PI");
        opPanel.add(pi);
        pi.addActionListener(piListener);
        pi.setFont(BIGGER_FONT);
        

        
 

        JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new FlowLayout());
        clearPanel.add(clearButton);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));
        content.add(screen, BorderLayout.NORTH);
        content.add(buttonPanel, BorderLayout.WEST);
        content.add(opPanel, BorderLayout.EAST);
        content.add(clearPanel, BorderLayout.SOUTH);
        content.add(basicOp, BorderLayout.CENTER);

        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.setContentPane(content);
        this.pack();


    }

    private void actionClear() {
        startingNumber = true;
        screen.setText("0");
        prevOp = "=";
        logic.setTotal("0");
    }

    class OpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                String displayText = screen.getText();
//            if (startingNumber&&"sin".equals(prevOp)) {
//                screen.setText("sin");
//                logic.sinus(Double.valueOf(displayText));
//                
//
//            } else {

                startingNumber = true;
                try {

                    

                    if (prevOp.equals("=")) {
                        logic.setTotal(displayText);
                    } else if (prevOp.equals("+")) {
                        logic.add(displayText);
                    } else if (prevOp.equals("-")) {
                        logic.subtract(displayText);
                    } else if (prevOp.equals("*")) {
                        logic.multiply(displayText);
                    } else if (prevOp.equals("/")) {
                        logic.divide(displayText);
                    } else if(prevOp.equals("sin")){
                        logic.sinus(Double.valueOf(displayText));
                        
                    } else if(prevOp.equals("cos")){
                        logic.cos(Double.valueOf(displayText));
                     
                    }else if(prevOp.equals("tan")){
                        logic.tan(Double.valueOf(displayText));
                       
                    }

                    screen.setText("" + logic.getTotalString());

                } catch (NumberFormatException ex) {
                    actionClear();
                    screen.setText("Error");
                }

                prevOp = e.getActionCommand();
            }
        }
    
    


    class NumListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String digit = e.getActionCommand();
            if (startingNumber) {
                screen.setText(digit);
                startingNumber = false;
            }else{
                screen.setText(screen.getText() + digit);
            }
        }
    }
    
    class PiListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            screen.setText(String.valueOf(Math.PI));
            startingNumber = false;
        }
    
    }
    
    class OtherListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String str = ae.getActionCommand();
        
        if("1/x".equals(str)){
            logic.ReverseTotal(screen.getText());
           screen.setText("" + logic.getTotalString());
           startingNumber = false;
        }else if("-".equals(str)){
           logic.Minus(screen.getText());
           screen.setText("" + logic.getTotalString());
        }
        }
        
    }
    class ClearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            actionClear();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception unused) {
        }

        Calc window = new Calc();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}

