package sample.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class GeneratePDF {
    public static String file;

    public static void generatePDF (String price, String DateDepa, String HourDepa, String VilleDepa, String VilleArriv) {

        try {
           String filename = "C:\\Users\\user\\Desktop\\TravelAgency - Copy\\agence_voyage\\src\\sample\\Generated Billets\\Billet.pdf";
           Document document = new Document();
           PdfWriter.getInstance(document, new FileOutputStream(filename));

           document.open();
           //add a parag
           Paragraph p = new Paragraph("hello, We wish you a safe trip!");
           document.add(p);
           //adding empty parag
           document.add( new Paragraph(" "));
           //add a table:
            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Date Depart"));
            table.addCell(c1);

             c1 = new PdfPCell(new Phrase("Heure Depart"));
             table.addCell(c1);
             c1 = new PdfPCell(new Phrase("Ville Depart"));
             table.addCell(c1);
             c1 = new PdfPCell(new Phrase("Ville arrive"));

             table.addCell(c1);
            table.setHeaderRows(1);
            table.addCell(DateDepa);
            table.addCell(HourDepa);
            table.addCell(VilleDepa);
            table.addCell(VilleArriv);
            document.add(table);
            document.add( new Paragraph(" "));
            document.add( new Paragraph(price +" Dh"));
            document.close();

          file = filename;
          System.out.println( "Billet Generated Succesfully");
       }catch (Exception e){
          System.out.println( e.getMessage());
       }

    }

}

