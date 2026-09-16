import java.awt.*;
import javax.swing.*;

public class Calculator {
    static double num1 = 0;
    static double num2 = 0;
    static String operator = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JTextField display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel panel = new JPanel(new GridLayout(4, 4));

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonPlus = new JButton("+");

        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonMinus = new JButton("-");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonMultiply = new JButton("*");

        JButton button0 = new JButton("0");
        JButton buttonClear = new JButton("C");
        JButton buttonEquals = new JButton("=");
        JButton buttonDivide = new JButton("/");

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiply);

        panel.add(button0);
        panel.add(buttonClear);
        panel.add(buttonEquals);
        panel.add(buttonDivide);

        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Number buttons
        button7.addActionListener(e -> appendNumber(display, "7"));
        button8.addActionListener(e -> appendNumber(display, "8"));
        button9.addActionListener(e -> appendNumber(display, "9"));
        button4.addActionListener(e -> appendNumber(display, "4"));
        button5.addActionListener(e -> appendNumber(display, "5"));
        button6.addActionListener(e -> appendNumber(display, "6"));
        button1.addActionListener(e -> appendNumber(display, "1"));
        button2.addActionListener(e -> appendNumber(display, "2"));
        button3.addActionListener(e -> appendNumber(display, "3"));
        button0.addActionListener(e -> appendNumber(display, "0"));

        // Operators
        buttonPlus.addActionListener(e -> setOperator(display, "+"));
        buttonMinus.addActionListener(e -> setOperator(display, "-"));
        buttonMultiply.addActionListener(e -> setOperator(display, "*"));
        buttonDivide.addActionListener(e -> setOperator(display, "/"));

        // Equals
        buttonEquals.addActionListener(e -> calculate(display));

        // Clear
        buttonClear.addActionListener(e -> display.setText(""));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static void appendNumber(JTextField display, String number) {
        display.setText(display.getText() + number);
    }

    static void setOperator(JTextField display, String op) {
        if (display.getText().isEmpty()) {
            return;
        }

        num1 = Double.parseDouble(display.getText());
        operator = op;
        display.setText("");
    }

    static void calculate(JTextField display) {
        if (display.getText().isEmpty() || operator.isEmpty()) {
            return;
        }

        num2 = Double.parseDouble(display.getText());

        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    display.setText("Cannot divide by 0");
                    return;
                }
                result = num1 / num2;
                break;
        }

        display.setText(String.valueOf(result));
    }
}