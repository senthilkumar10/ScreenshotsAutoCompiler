import java.awt.event.*;
import javax.swing.*;

public class MainClass {
    public static String docLocationPath = "";
    public static String testcaseName = "";
    public static String imageType = "";

    public static void main(String args[]) {

        LocationUI locationUI = new LocationUI();

        final JFrame frame = locationUI.winLayout();
        final JTextField textField1 = locationUI.createTextField(frame, "Enter the Location");
        final JTextField textField2 = locationUI.createTextField(frame, "Enter the Test Name");
        final JComboBox jlist = locationUI.comboBox(frame);

        final JButton jButton = new JButton("Ok");
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                docLocationPath = textField1.getText();
                testcaseName = textField2.getText();
                imageType = jlist.getSelectedItem().toString();
                System.out.println(docLocationPath);
                System.out.println(testcaseName);
                System.out.println(imageType);
                frame.setVisible(false);
                PrintButton.printButton();
            }
        });

        frame.getContentPane().add(jButton);
        frame.pack();
        frame.setVisible(true);

    }
}