import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class PrintScreen {
    public static void printScreen() {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File folder = new File(MainClass.docLocationPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            ImageIO.write(screenShot, MainClass.imageType,
                    new File(new String(MainClass.docLocationPath + File.separator + MainClass.testcaseName + "_" + System.currentTimeMillis() + "." + MainClass.imageType)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

