

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import javax.imageio.ImageIO;


public class PrintScreen
{
    static void printScreen()
    {
        try
        {
            Robot robot = new Robot();
            Calendar now = Calendar.getInstance();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            File folder = new File( MainClass.location );
            if (!folder.exists()){
                folder.mkdir();
            }
            ImageIO.write(screenShot, MainClass.format, new File(new String(MainClass.location+ "\\" +MainClass.prefix+"_"+System.currentTimeMillis()+"."+MainClass.format)));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

