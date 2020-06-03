import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public abstract class PrintButton extends JFrame implements WindowListener {

    public static void printButton() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            Dlg f = new Dlg(new JFrame(), "PRINT");
            f.setAlwaysOnTop(true);
            f.getContentPane().setLayout(new FlowLayout());
            final JButton jButton = new JButton("Prtsc");
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);
                    PrintScreen.printScreen();
                    StepDescription.stepDescription(f);
                }
            });
            f.getContentPane().add(jButton);
            f.pack();
            f.setVisible(true);
        } catch (Exception evt) {
            evt.printStackTrace();
        }
    }
}


class Dlg extends JDialog {
    public Dlg(JFrame frame, String str) {
        super(frame, str);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                try {
                    WordHandling.wordDoc();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File folder = new File(MainClass.docLocationPath);
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.getName().endsWith(".PNG") || file.getName().endsWith(".JPEG")) {
                        try {
                            boolean success = file.delete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.exit(0);
            }
        });
    }
}


