package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import utils.ExcelUtil;

public class ExcelUtil {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void loadExcel(String path, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get Cell Data (Safe)
    public static String getCellData(int row, int col) {

        if (sheet == null) {
            throw new RuntimeException("Excel sheet not loaded. Call loadExcel() first.");
        }
        if (sheet.getRow(row) == null || sheet.getRow(row).getCell(col) == null) {
            return "";
        }

        XSSFCell cell = sheet.getRow(row).getCell(col);

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }

    // Get Row Count
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }

    // Close Workbook
    public static void closeExcel() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}