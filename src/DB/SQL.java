package DB;

public class SQL {
	
	
	//--------------------------------------------------------//
	//------------------------Tables--------------------------//
	//--------------------------------------------------------//
	
	
	public static final String STUDENT = "Student";
	public static final String LECTURER = "Lecturer";
	public static final String STUDENTREGISTRATION = "StudentRegistration";
	public static final String STUDENTCONTACT = "StudentContact";
	public static final String NEXTOFKINCONTACT = "NextOfKinContact";
	public static final String LECTURERCONTACT = "LecturerContactTable";
	public static final String TUTOR = "Tutor";
	public static final String TITLES = "Titles";
	public static final String REGISTRATIONTYPE = "RegistrationType";
	
	
	//--------------------------------------------------------//
	//-------------------------VALUES-------------------------//
	//--------------------------------------------------------//
	
	
	public static final String studentID = "studentID                SERIAL";
	public static final String titleID = "titleID                  SERIAL";
	public static final String lecturerID = "lecturerID               SERIAL";
	public static final String lecturerIDC = "LecturerIDC              SERIAL";
	public static final String registrationTypeID = "registrationTypeID       SERIAL";
	public static final String foreName = "foreName                 CHAR(20)";
	public static final String name = "name                     CHAR(20)";
	public static final String familyName = "familyName               CHAR(20)";
	public static final String dateOfBirth = "dateOfBirth              DATE";
	public static final String yearOfStudy = "yearOfStudy              INTEGER";
	public static final String eMailAddress = "eMailAddress             CHAR(30)";
	public static final String postalAddress = "postalAddress            CHAR(50)";
	public static final String office = "office                   INTEGER";
	public static final String titleString = "titleString              CHAR(10)";
	public static final String description = "description              CHAR(100)";
	
	//--------------------------------------------------------//
	//------------------VALUES WITH NO TYPE-------------------//
	//--------------------------------------------------------//
	
	public static final String studentID2 = "studentID";
	public static final String titleID2 = "titleID";
	public static final String lecturerID2 = "lecturerID";
	public static final String lecturerID2C = "LecturerIDC";
	public static final String registrationTypeID2 = "registrationTypeID";
	public static final String foreName2 = "foreName";
	public static final String name2 = "name";
	public static final String familyName2 = "familyName";
	public static final String dateOfBirth2 = "dateOfBirth";
	public static final String yearOfStudy2 = "yearOfStudy";
	public static final String eMailAddress2 = "eMailAddress";
	public static final String postalAddress2 = "postalAddress";
	public static final String office2 = "office";
	public static final String titleString2 = "titleString";
	public static final String description2 = "description";
	
	//--------------------------------------------------------//
	//----------------------Constraints-----------------------//
	//--------------------------------------------------------//
	
	
	public static final String UNIQUE = "UNIQUE";
	public static final String NOTNULL = "NOT NULL";
	public static final String PRIMARYKEY = "PRIMARY KEY";
	public static final String FOREIGNKEY = "FOREIGN KEY";
	public static final String SERIAL = "SERIAL";
	
	
	//--------------------------------------------------------//
	//--------------------------Keys--------------------------//
	//--------------------------------------------------------//
	
	
	public static final String STUDENTKEY = "StudentKey";
	public static final String LECTURERKEY = "LecturerKey";
	public static final String REGISTRATIONTYPEKEY = "RegistrationTypeKey";
	public static final String TITLEKEY = "TitleKey";
	
	
	//--------------------------------------------------------//
	//----------------------Other Syntax----------------------//
	//--------------------------------------------------------//
	
	
	public static final String REFERENCES = "REFERENCES";
	public static final String ONDELETE = "ON DELETE";
	public static final String ONUPDATE = "ON UPDATE";
	public static final String CASCADE = "CASCADE";
	public static final String CONSTRAINT = "CONSTRAINT";
	public static final String INDENT = "            ";
	public static final String AND = "AND";
	public static final String CHECK = "CHECK";
	public static final String NOCOMMENT = "No additional comments.";
	public static final String CREATE = "CREATE";
	public static final String TABLE = "TABLE";
	public static final String VALUES = "VALUES";
	
	//--------------------------------------------------------//
	//-------------------------Types--------------------------//
	//--------------------------------------------------------//
	
	public static final String INTEGER = "INTEGER";
	public static final String DATE = "DATE";
	public static final String CHAR = "CHAR";
	
	//--------------------------------------------------------//
	//----------------------Connectivity----------------------//
	//--------------------------------------------------------//
	
	public static final String DBNAME = "jdbc:postgresql://dbteach2.cs.bham.ac.uk/";
	public static final String USER = "fsd491";
	public static final String PW = "hijahacr";
}
