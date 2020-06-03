import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocationUI {

    public JFrame winLayout() {
        JFrame frame = null;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            frame = new JFrame("ENTER ALL DETAILS BELOW");
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 400);
            frame.getContentPane().setLayout(new FlowLayout());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frame;
    }

    public JTextField createTextField(JFrame frame, String fieldName) {
        JTextField textField = new JTextField(fieldName);
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textField.setText("");
            }
        });
        frame.getContentPane().add(textField);
        return textField;
    }

    public JComboBox comboBox(JFrame frame) {
        JComboBox jlist = new JComboBox<String>();
        jlist.addItem("PNG");
        jlist.addItem("JPEG");
        frame.getContentPane().add(jlist);
        return jlist;
    }


}
