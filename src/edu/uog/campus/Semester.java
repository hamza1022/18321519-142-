package edu.uog.campus;


	
	public class Semester {
		
		public static String csvFile="D:\\Hamza 4th semester\\SEMESTER.csv";
		
		private int SEMESTER_ID;
		
		private String SEMESTER_NAME;
		
		private String SEMESTER_TYPE;
		
	
		public int getSEMESTER_ID() {
			return SEMESTER_ID;
		}
		public void setSEMESTER_ID(int semester_ID) {
			SEMESTER_ID = semester_ID;
		}
		public String getSEMESTER_NAME() {
			return SEMESTER_NAME;
		}
		public void setSEMESTER_NAME(String semester_NAME) {
			SEMESTER_NAME = semester_NAME;
		}
		public String getSEMESTER_TYPE() {
			return SEMESTER_TYPE;
		}
		public void setSEMESTER_TYPE(String semester_TYPE) {
			SEMESTER_TYPE = semester_TYPE;
		}
		
		
	
		public String toString() {
			String str;
			str = this.SEMESTER_ID
					+ "," + this.SEMESTER_NAME
					+ "," + this.SEMESTER_TYPE;
					
			return str;
		}
		

}
