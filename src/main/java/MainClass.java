import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainClass{
    static String location = "";
    static String prefix = "";
    static String format = "";

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            final JFrame f = new JFrame("ENTER ALL DETAILS BELOW");
//          f.setAlwaysOnTop(true);
            f.setLocationRelativeTo( null );
            f.getContentPane().setLayout(new FlowLayout());

            final JTextField textField1 = new JTextField("Enter the Location");
            textField1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    textField1.setText("");
                }
            });
            f.getContentPane().add(textField1);

            final JTextField textField2 = new JTextField("Enter the Test Name");
            textField2.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    textField2.setText("");
                }
            });
            f.getContentPane().add(textField2);

            String  jlistData[] =
                    {
                            "GIF",
                            "PNG",
                            "JPEG"
                    };
            final JComboBox  jlist = new JComboBox<String>( jlistData );
            f.getContentPane().add(jlist);

            final JButton jButton = new JButton("Ok");
            jButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    location = textField1.getText();
                    prefix = textField2.getText();
                    format = jlist.getSelectedItem().toString();
                    System.out.println(location);
                    System.out.println(prefix);
                    System.out.println(format);
                    f.setVisible(false);
                    PrintButton.printButton();
                }
            });
            f.getContentPane().add(jButton);

            f.pack();
            f.setVisible(true);
        }
        catch (Exception evt)
        {
            evt.printStackTrace();
        }
    }
}