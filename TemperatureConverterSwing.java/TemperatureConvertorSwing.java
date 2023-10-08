import javax.swing.*;
import java.awt.event.*;

    public class TemperatureConverterSwing {
        private JFrame frame;
        private JLabel label1, label2;
        private JTextField inputField;
        private JRadioButton celsiusButton, fahrenheitButton;
        private JButton convertButton;

        public TemperatureConverterSwing() {
            frame = new JFrame("Temperature Converter");
            frame.setLayout(null);

            label1 = new JLabel("Enter Temperature:");
            label1.setBounds(20, 20, 150, 30);

            inputField = new JTextField();
            inputField.setBounds(180, 20, 100, 30);

            label2 = new JLabel("");
            label2.setBounds(20, 70, 300, 30);

            celsiusButton = new JRadioButton("Celsius to Fahrenheit");
            celsiusButton.setBounds(20, 120, 200, 30);

            fahrenheitButton = new JRadioButton("Fahrenheit to Celsius");
            fahrenheitButton.setBounds(20, 160, 200, 30);

            ButtonGroup group = new ButtonGroup();
            group.add(celsiusButton);
            group.add(fahrenheitButton);

            convertButton = new JButton("Convert");
            convertButton.setBounds(20, 210, 100, 30);
            convertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    convertTemperature();
                }
            });

            frame.add(label1);
            frame.add(inputField);
            frame.add(label2);
            frame.add(celsiusButton);
            frame.add(fahrenheitButton);
            frame.add(convertButton);

            frame.setSize(350, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        public void convertTemperature() {
            try {
                double temperature = Double.parseDouble(inputField.getText());

                if (celsiusButton.isSelected()) {
                    double fahrenheit = (temperature * 9/5) + 32;
                    label2.setText(temperature + " Celsius is equivalent to " + fahrenheit + " Fahrenheit.");
                } else if (fahrenheitButton.isSelected()) {
                    double celsius = (temperature - 32) * 5/9;
                    label2.setText(temperature + " Fahrenheit is equivalent to " + celsius + " Celsius.");
                } else {
                    label2.setText("Please select a conversion type.");
                }
            } catch (NumberFormatException ex) {
                label2.setText("Invalid input. Please enter a valid temperature value.");
            }
        }

        public static void main(String[] args) {
            new TemperatureConverterSwing();
        }
    }

}
