package fileProces;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class _03_ExelRead {
    @Test
    public void readExel_xls() throws IOException {
        // pom a poi ekliyoruzorg.apache.poi olacak
        // xml icin ise poi-ooxml eklerir


        //okunacak exel dosyasinin yolu ve adi
        String path = "src/test/java/fileProces/_02_Exel1.xls";

        // exel dosyasi FileInput ile okunur
        FileInputStream inputStream = new FileInputStream(path);

        //exel icin bir workbook cvreate edilir
        Workbook workbook = WorkbookFactory.create(inputStream);

        // exel ici8nde sayfa seciyoruz
        //  Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("Tabelle1");

        //row =satir demek

        Row row = sheet1.getRow(0);

        //Cell ise sutundur yani hucre
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());

        inputStream.close();

    }

    @Test
    public void readExel_xlsx() throws IOException {
        // pom a poi ekliyoruzorg.apache.poi olacak
        // xml icin ise poi-ooxml eklerir


        //okunacak exel dosyasinin yolu ve adi
        String path = "src/test/java/fileProces/users.xlsx";

        // exel dosyasi FileInput ile okunur
        FileInputStream inputStream = new FileInputStream(path);

        //exel icin bir workbook cvreate edilir
        Workbook workbook = WorkbookFactory.create(inputStream);

        // exel ici8nde sayfa seciyoruz
        //  Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("data");

        //row =satir demek

        Row row = sheet1.getRow(0);

        //Cell ise sutundur yani hucre
        Cell cell = row.getCell(0);
        System.out.println(cell.toString());

        inputStream.close();

    }
}
