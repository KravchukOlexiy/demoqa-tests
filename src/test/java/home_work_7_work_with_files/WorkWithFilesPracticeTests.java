package home_work_7_work_with_files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WorkWithFilesPracticeTests {

    @Test
    void downloadTextFile() throws IOException {
        open("https://filesamples.com/formats/txt");
        File downloadedFile = $(byText("Download")).download();
        String txtFileParsed = IOUtils.toString(new FileReader(downloadedFile));
        Assertions.assertTrue(txtFileParsed.contains("A mene tu?"));
    }

    @Test
    void downloadPDFFile() throws IOException {
        open("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/#google_vignette");
        File downloadedFile = $(byText("Download sample pdf file")).download();
        PDF pdfFileParsed = new PDF(downloadedFile);
        Assertions.assertTrue(pdfFileParsed.text.contains("Lorem ipsum"));
    }

    @Test
    void downloadXLSFile() throws IOException {
        open("https://file-examples.com/index.php/sample-documents-download/sample-xls-download/");
        File downloadedFile = $(byText("Download sample xls file")).download();
        XLS xlsFileParsed = new XLS(downloadedFile);
        Assertions.assertTrue(xlsFileParsed.excel
                .getSheetAt(0)
                .getRow(9)
                .getCell(4)
                .getStringCellValue()
                .contains("United States"));
    }

    @Test
    void readCSVFileFromResources() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("2.csv");
             Reader reader = new InputStreamReader(inputStream)) {
            CSVReader csvReader = new CSVReader((reader));
            List<String[]> stringsOFCSV = csvReader.readAll();
            Assertions.assertEquals(5, stringsOFCSV.size());
        }
    }

    @Test
    void parseZipFileTest() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("3.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
            }
        }
    }

}