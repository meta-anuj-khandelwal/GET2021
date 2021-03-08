package question3;

public class Main {

	public static void main(String[] args) {
		CollegeCounseling collegeCounseling = new CollegeCounseling();
		collegeCounseling
				.loadProgramFromExcel("C:\\Users\\anuj.khandelwal_meta\\Downloads\\courselist.xlsx");
		collegeCounseling
				.loadStudentFromExcel("C:\\Users\\anuj.khandelwal_meta\\Downloads\\studentdata.xlsx");
		collegeCounseling.Counseling();
		collegeCounseling
				.saveToExcel("C:\\Users\\anuj.khandelwal_meta\\Downloads\\studentallocated.xlsx");
	collegeCounseling.showData();
	}
}
