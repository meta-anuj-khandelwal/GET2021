package question3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * <h1>CollegeCounseling</h1>
 * <p>
 * This class is used to manage college counseling.
 * 
 * </p>
 * 
 * @author Anuj Khandelwal
 * @version 1.0
 * @since 2021-03-04
 */
public class CollegeCounseling {
	// Student Queue in order of their ranks.
	Queue<Student> studentQueue = new StudentQueue();
	// List of programs college offers.
	ArrayList<Programs> programList = new ArrayList<Programs>();
	// store allocated student
	ArrayList<Student> studentList = new ArrayList<Student>();

	/**
	 * this function to fetch data from file and store it in studentList
	 * 
	 * @param studentFilePath
	 *            excel file path
	 */
	public void loadStudentFromExcel(String studentFilePath) {
		try {
			// creating a new file instance
			File file = new File(studentFilePath);
			// obtaining bytes from the file
			FileInputStream fis = new FileInputStream(file);
			// creating Workbook instance
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// creating a Sheet object to retrieve object
			XSSFSheet sheet = wb.getSheetAt(0);
			// iterating over excel file
			Iterator<Row> itr = sheet.iterator();
			// passing headers
			itr.next();
			while (itr.hasNext()) {
				Row row = itr.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				// iterating over each column
				ArrayList<String> courseChoiceList = new ArrayList<String>();
				String studentName = new String();

				int nameFlag = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {

					case STRING:
						if (nameFlag == 0) {
							studentName = cell.getStringCellValue();
							nameFlag = 1;
						} else {
							courseChoiceList.add(cell.getStringCellValue());
						}

						break;
					default:
						break;
					}

				}

				Student student = new Student(studentName, courseChoiceList);
				studentQueue.enqueue(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function to fetch data from file and store it in programList
	 * 
	 * @param studentFilePath
	 *            excel file path
	 */
	public void loadProgramFromExcel(String programFilePath) {
		try {
			// creating a new file instance
			File file = new File(programFilePath);
			// obtaining bytes from the file
			FileInputStream fis = new FileInputStream(file);
			// creating Workbook instance
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// creating a Sheet object to retrieve object
			XSSFSheet sheet = wb.getSheetAt(0);
			// iterating over excel file
			Iterator<Row> itr = sheet.iterator();
			// passing headers
			itr.next();
			while (itr.hasNext()) {
				Row row = itr.next();

				Iterator<Cell> cellIterator = row.cellIterator();
				// iterating over each column

				int capacity = 0;
				String programName = new String();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {

					case NUMERIC:
						capacity = (int) cell.getNumericCellValue();
						break; // cell type

					case STRING:
						programName = cell.getStringCellValue();
						break;
					default:
						break;
					}
				}
				Programs programs = new Programs(programName, capacity);
				programList.add(programs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function store program allocation data in excel file
	 * 
	 * @param studentFilePath
	 *            excel file path
	 */
	public void saveToExcel(String filename) {
		try {
			// creating an instance of HSSFWorkbook class
			HSSFWorkbook workbook = new HSSFWorkbook();
			// invoking creatSheet() method and passing the name of the sheet to
			// be created
			HSSFSheet sheet = workbook.createSheet("sheet1");
			// creating the 0th row using the createRow() method
			HSSFRow rowhead = sheet.createRow((short) 0);
			// creating cell by using the createCell() method and setting the
			// values to the cell by using the setCellValue() method
			rowhead.createCell(0).setCellValue("Student Name");
			rowhead.createCell(1).setCellValue("Allocated Course");

			for (int rowIndex = 0; rowIndex < studentList.size(); rowIndex++) {
				HSSFRow row = sheet.createRow((short) rowIndex + 1);
				// inserting data in the first row
				row.createCell(0).setCellValue(
						studentList.get(rowIndex).getName());
				row.createCell(1).setCellValue(
						studentList.get(rowIndex).getProgramAllocated());

			}
			FileOutputStream fileOut = new FileOutputStream(filename);

			workbook.write(fileOut);
			// closing the Stream
			fileOut.close();
			// closing the workbook
			workbook.close();
			// prints the message on the console
			System.out.println("Data has been saved successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function use queue of student and allocate course to them
	 * 
	 * @return nothing
	 */
	public void Counseling() {
		while (!studentQueue.isEmpty()) {
			Student student = studentQueue.dequeue();
			// System.out.println(student);
			ArrayList<String> studentCourseChoiceList = student
					.getCourseChoiceList();
			// finding which choice number course is available from
			// studentChoice.
			boolean isProgramAllocated = false;
			for (int choiceNumber = 0; choiceNumber < 5; choiceNumber++) {
				// searching for studentChoice course from college program list
				for (int programIndex = 0; programIndex < programList.size(); programIndex++) {
					// if student choice course available in college program
					// list
					if (studentCourseChoiceList.get(choiceNumber).equals(
							programList.get(programIndex).getCourseName())) {
						// if course has capacity
						if (programList.get(programIndex).hasCapacity()) {
							// allocating course to student
							student.setProgramAllocated(programList.get(
									programIndex).getCourseName());
							studentList.add(student);
							// decreasing course capacity by 1
							programList.get(programIndex).decreaseCapacity();
							isProgramAllocated = true;
							break;
						}
					}
				}
				if (isProgramAllocated) {
					break;
				}
			}
			if (!isProgramAllocated) {
				studentList.add(student);
			}

		}
	}

	/**
	 * This function print the student name with allocated program.
	 */
	public void showData() {
		System.out.println("Name\tProgram");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(studentList.get(i).getName() + "\t"
					+ studentList.get(i).getProgramAllocated());
		}
	}
}
