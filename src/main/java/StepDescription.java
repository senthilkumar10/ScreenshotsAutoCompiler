import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class StepDescription {
    public static List<String> description = new ArrayList<>();

    public static void stepDescription(Dlg parent){
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame step = new JFrame( "Step Details" );
            step.setAlwaysOnTop(true);
            step.getContentPane().setLayout(new FlowLayout());
            final JTextField textField1 = new JTextField("Enter Step Description");
            textField1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    textField1.setText("");
                }
            });
            step.getContentPane().add( textField1 );
            final JButton jButton = new JButton("Ok");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    description.add(textField1.getText()) ;
                    step.setVisible(false);
                    parent.setVisible( true );
                }
            });
            step.getContentPane().add(jButton);
            step.pack();
            step.setVisible(true);
        }
        catch (Exception evt)
        {
            evt.printStackTrace();
        }
    }
}


