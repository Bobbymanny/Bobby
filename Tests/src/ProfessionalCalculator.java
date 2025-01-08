import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessionalCalculator {
    // Declare components
    private JFrame frame;
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton addButton, subButton, mulButton, divButton, clrButton, equButton;
    private JPanel buttonPanel;

    // Variables to store arithmetic operations
    private double num1, num2, result;
    private char operator;

    public ProfessionalCalculator() {
        // Set up the main frame
        frame = new JFrame("Professional Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Display Field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Number Buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        // Operation Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("C");
        equButton = new JButton("=");

        operationButtons = new JButton[]{addButton, subButton, mulButton, divButton, clrButton, equButton};

        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 18));
            buttonPanel.add(button);
        }

        // Add action listeners to buttons
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(e -> display.setText(display.getText() + finalI));
        }

        addButton.addActionListener(e -> performOperation('+'));
        subButton.addActionListener(e -> performOperation('-'));
        mulButton.addActionListener(e -> performOperation('*'));
        divButton.addActionListener(e -> performOperation('/'));
        clrButton.addActionListener(e -> display.setText(""));
        equButton.addActionListener(e -> calculateResult());

        // Final frame setup
        frame.setVisible(true);
    }

    // Method to perform arithmetic operations
    private void performOperation(char op) {
        num1 = Double.parseDouble(display.getText());
        operator = op;
        display.setText("");
    }

    // Method to calculate result
    private void calculateResult() {
        num2 = Double.parseDouble(display.getText());
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        display.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new ProfessionalCalculator();
    }
}
