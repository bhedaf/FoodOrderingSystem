package com.example.sheridanbagelhouseproject;
/*
 * @author Fizza Imran  991670304
 * @author Freya Bheda  991643368
 * modified: 6 Aug 2022
 * Description: this class manages printing to printer and appending to file.

 *
 * */
import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class PrintController {

    //this method prints recipt to the file
    public static void printToFile(String data){

        try {
            //connecting file to stream
            OutputStream outFile = new FileOutputStream("receipt.txt");

            //to save the data
            byte[] byteArray= data.getBytes();

            //writes the data into stream
            outFile.write(byteArray);

            //print to comsole so we know recipt is ready
            System.out.println("Recipt is ready.");

            //closing stream
            outFile.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

    }

    //this method prints out the recipt to printer (credit: this code is provided bt professor)
    public static void printToPrinter(String data) {
        printToFile(data);  // to generate receipt file
        PrintRequestAttributeSet pras =     new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        PrintService ps[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 200, 200, ps, defaultService, flavor, pras);
        if (service != null) {
            try {
                DocPrintJob job = service.createPrintJob();
                DocAttributeSet das = new HashDocAttributeSet();
                FileInputStream fis = new FileInputStream("receipt.txt");
                Doc doc = new SimpleDoc(fis, flavor, das);
                try {
                    job.print(doc, pras);
                    System.out.println("Job sent to printer.");

                } catch (PrintException e) {
                    System.out.println("Print error!" + e.getMessage());
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found!" + e.getMessage());
            }
        }
    }
}
