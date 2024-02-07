package fileProces;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
    public void readExel_xlsx1() throws IOException {
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

    @Test
    public void readExel_xlsx2() throws IOException {

        String path = "src/test/java/fileProces/users.xlsx";


        FileInputStream inputStream = new FileInputStream(path);


        Workbook workbook = WorkbookFactory.create(inputStream);


        //  Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet1 = workbook.getSheet("data");

        int rowNum = sheet1.getPhysicalNumberOfRows();
        for (int i = 0; i <= 100; i++) {

            Row row = sheet1.getRow(i);

            int colls = row.getPhysicalNumberOfCells();
            for (int j = 0; j < colls; j++) {
                System.out.print(row.getCell(j) + "\t ");

            }

            System.out.println();
        }


        inputStream.close();

    }


    @Test
    public void getDataFromExelAslist() throws IOException {
        String pathh = ("src/test/java/fileProces/users.xlsx");

        for (List<String> row : getData(pathh)) {
            for (String cell : row) {
                System.out.print(cell + "\t ");

            }
            System.out.println();

        }

    }

    private List<List<String>> getData(String path) throws IOException {

        List<List<String>> data = new ArrayList<>();

        FileInputStream stream = new FileInputStream(path);
        Workbook work = WorkbookFactory.create(stream);
        Sheet sheet1 = work.getSheetAt(0);
        int rowNum = sheet1.getPhysicalNumberOfRows(); // butun row lari aldik
        for (int i = 0; i < 100; i++) {
            Row row = sheet1.getRow(i);
            int calls = row.getPhysicalNumberOfCells();
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < calls; j++) {
                Cell cell = row.getCell(j);
                rowData.add(cell.toString());

            }
            data.add(rowData);


        }

        return data;
    }

    @Test
    public void test() throws Exception {
        //dosya yolunu aldik
        String path = "src/test/java/fileProces/_02_Exel1.xls";

        // exel in acilmasi icin cift tikliyoruz
        FileInputStream inputStream = new FileInputStream(path);


        Workbook work = WorkbookFactory.create(inputStream);

        //exel in altindaki syafayi sectik
        Sheet sheet = work.getSheetAt(0);

        // sayfanin icinde satir seciyoruz
        int rownum = sheet.getPhysicalNumberOfRows();
        Row row = sheet.createRow(rownum);

        // satirda hucre seciyoruz
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(101);
        inputStream.close();

        // yapilan degisikligi kaydediyoruz
        FileOutputStream outputStream = new FileOutputStream(path);
        work.write(outputStream);
        outputStream.close();


    }

    @Test
    public void getdataFromExel() throws Exception {
        String path = "src/test/java/fileProces/users.xlsx";
        List<List<String>> data = getData(path, "data", 1, 10, 2, 4);
        for (List<String> row : data) {
            for (String cell : row) {
                System.out.printf("%-10s\t", cell);

            }
            System.out.println();

        }


    }


    private List<List<String>> getData(String path, String sheetName, int startRow, int endRow, int startCell, int endCell) throws IOException {

        List<List<String>> data = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(path);

        Workbook work = WorkbookFactory.create(inputStream);

        Sheet sheet1 = work.getSheet(sheetName);
        int rowNum = sheet1.getPhysicalNumberOfRows(); // butun row lari aldik

        endRow = endRow < rowNum ? endRow : rowNum;
        for (int i = startRow; i < endRow; i++) {
            Row row = sheet1.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            List<String> rowData = new ArrayList<>();
            endCell = endCell < cells ? endCell : cells;
            for (int j = startCell; j < endCell; j++) {
                Cell cell = row.getCell(j);
                rowData.add(cell.toString());

            }
            data.add(rowData);


        }

        return data;
    }

    @Test
    public void createExelFile() throws Exception {
        //Sifirdan exel olusdturuyoruz
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(10);

        row.createCell(1).setCellValue(20);

        String file = "src/test/java/fileProces/MyExcel.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();

    }

    @Test
    public void createExel() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet1 = workbook.createSheet("Sayfa1");


        //sifirinci row u olusturduk yani satiri
        Row row1 = sheet1.createRow(0);

        // satirin icine 10 hucre olusturacagiz   // soldan saga doldurma
        for (int i = 0; i < 10; i++) {
            row1.createCell(i).setCellValue(i + 1);

        }


        XSSFSheet sheet2 = workbook.createSheet("Sayfa2");   //zukarıdan asagıza doldurma
        // satirin icine zukarıdan asagıza 10 hucre
        for (int i = 0; i < 10; i++) {
            Row row = sheet2.createRow(i);
            row.createCell(0).setCellValue(i + 1);

        }


        String file = "src/test/java/fileProces/YeniExce2.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(file);

        workbook.write(fileOutputStream);

    }

    @Test
    public void createExel3() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet3 = workbook.createSheet("sayfa3");
        for (int i = 0; i <10 ; i++) {
            Row row = sheet3.createRow(i); // 10 tane sutun olusacak
            for (int j = 0; j < 10; j++) {
               row.createCell(j).setCellValue(i*10+j+ 1);

            }

        }


        String file = "src/test/java/fileProces/Excel6.xlsx";
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();


    }
    //carpim tablosu olusturma

    @Test
    public void carpimTablosu() throws Exception {
        XSSFWorkbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("sayfa8");
        int rownum=sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < 10; i++) {
            Row row=sheet.createRow(i);
            row.createCell(0).setCellValue(3);
            row.createCell(1).setCellValue("x");
            row.createCell(2).setCellValue(i+1);
            row.createCell(3).setCellValue("=");
            row.createCell(4).setCellValue(3*(i+1));
        }



        String filepath="src/test/java/fileProces/Excel8.xls";

        FileOutputStream outputStream=new FileOutputStream(filepath);
        workbook.write(outputStream);
        workbook.close();
    }
}