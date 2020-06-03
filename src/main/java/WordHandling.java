import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WordHandling {

    public static void wordDoc() throws IOException {
        File folder = new File(MainClass.docLocationPath);
        File[] files = folder.listFiles();
        XWPFDocument doc = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File(MainClass.docLocationPath + File.separator + MainClass.testcaseName + ".docx"));
        XWPFParagraph par = doc.createParagraph();
        par.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun run = par.createRun();
        run.setBold(true);
        run.setItalic(true);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        run.setText("Screenshots for Test Case : " + MainClass.testcaseName);
        run.addBreak();
        run.setText("Creation Date : " + dateformat.format(date));
        run.addBreak();
        run.setText("Created By : " + System.getProperty("user.name"));
        run.addBreak();
        System.out.println(StepDescription.description);
        int i = 0;
        for (File file : files) {
            String fileName = file.getName();
            int document = -1;
            if (fileName.endsWith(MainClass.imageType)) {
                if (fileName.endsWith(".PNG")) {
                    document = doc.PICTURE_TYPE_PNG;
                } else if (fileName.endsWith(".JPEG")) {
                    document = doc.PICTURE_TYPE_JPEG;
                }
            }
            if (document != -1) {
                try {
                    String StepDetail = StepDescription.description.get(i);
                    if (!StepDetail.equalsIgnoreCase("Enter Step Description")) {
                        run.setText(StepDetail);
                    }
                    FileInputStream fis = new FileInputStream(file);
                    run.addPicture(fis, document, fileName, Units.toEMU(500), Units.toEMU(400));
                    run.addBreak();
                    fis.close();
                    i++;
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        doc.write(out);
        doc.close();
        out.close();
    }
}
