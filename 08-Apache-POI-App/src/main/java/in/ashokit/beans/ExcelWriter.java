package in.ashokit.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws Exception {

		Emp e1 = new Emp("101", "Nithin", "15000.00");
		Emp e2 = new Emp("102", "Steve", "25000.00");
		Emp e3 = new Emp("103", "John", "35000.00");
		Emp e4 = new Emp("104", "Somu", "45000.00");
		Emp e5 = new Emp("105", "Ramesh", "55000.00");
		Emp e6 = new Emp("106", "Butler", "65000.00");

		List<Emp> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);

		ExcelWriter writer = new ExcelWriter();
		writer.write(empList);
	}

	public void write(List<Emp> empList) throws Exception {
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Emps");

		Row headerRow = sheet.createRow(0);

		Cell headerCell0 = headerRow.createCell(0);
		Cell headerCell1 = headerRow.createCell(1);
		Cell headerCell2 = headerRow.createCell(2);

		headerCell0.setCellValue("Emp Id");
		headerCell1.setCellValue("Emp Name");
		headerCell2.setCellValue("Emp Salary");

		for (int i = 0; i < empList.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);

			Cell dataCell0 = dataRow.createCell(0);
			Cell dataCell1 = dataRow.createCell(1);
			Cell dataCell2 = dataRow.createCell(2);

			Emp emp = empList.get(i);
			dataCell0.setCellValue(emp.getEmpId());
			dataCell1.setCellValue(emp.getEmpName());
			dataCell2.setCellValue(emp.getEmpSalary());
		}

		FileOutputStream fos = new FileOutputStream(new File("Emps.xlsx"));
		workbook.write(fos);

		workbook.close();

	}

}
