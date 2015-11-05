package DB;
import java.util.ArrayList;
public class PartOne {
	
	public PartOne()
	{
		
	}
	public ArrayList<String> listConstraintsRegistrationType()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.REGISTRATIONTYPE);
		tableConstraints.add("(");
		tableConstraints.add(SQL.registrationTypeID + ",");
		tableConstraints.add(SQL.description + ",");
		tableConstraints.add(SQL.PRIMARYKEY + "(" + SQL.registrationTypeID2 + ")");
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add(SQL.NOCOMMENT);
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsTitles()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.TITLES);
		tableConstraints.add("(");
		tableConstraints.add(SQL.titleID + ",");
		tableConstraints.add(SQL.titleString + ",");
		tableConstraints.add(SQL.PRIMARYKEY + "(" + SQL.titleID2 + ")");
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add(SQL.NOCOMMENT + "Pretty straight-forward.");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsTutor()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.TUTOR);
		tableConstraints.add("(");
		tableConstraints.add(SQL.studentID + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.lecturerIDC + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.studentID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.STUDENT + " (" + SQL.studentID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.lecturerID2C + ")" + " " + 
								SQL.REFERENCES + " " + SQL.LECTURER + " (" + SQL.lecturerID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("The studentid is unique such that each different student can have a \n"
				+"tutor");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsLecturerContact()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.LECTURERCONTACT);
		tableConstraints.add("(");
		tableConstraints.add(SQL.lecturerID + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.office + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.eMailAddress + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.lecturerID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.LECTURER + "(" + SQL.lecturerID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("Same as for student contacts. Potentially offices can be shared.");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsNextOfKinContact()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.NEXTOFKINCONTACT);
		tableConstraints.add("(");
		tableConstraints.add(SQL.studentID + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.name + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.eMailAddress + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.postalAddress + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.studentID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.STUDENT + "(" + SQL.studentID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("Obviously, studentID is not unique because they might have \n" +
		"several next kin contacts.");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsStudentContact()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.STUDENTCONTACT);
		tableConstraints.add("(");
		tableConstraints.add(SQL.studentID + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.eMailAddress + " " + SQL.NOTNULL + " " + SQL.UNIQUE + "," );
		tableConstraints.add(SQL.postalAddress + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.studentID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.STUDENT + "(" + SQL.studentID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("I want the email address to be UNIQUE because I don't want \n"+
			"private information to potentially reach the wrong student.");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsStudentRegistration()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.STUDENTREGISTRATION);
		tableConstraints.add("(");
		tableConstraints.add(SQL.studentID + " " + SQL.NOTNULL + " " + SQL.UNIQUE + ",");
		tableConstraints.add(SQL.yearOfStudy + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.registrationTypeID + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.studentID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.STUDENT + " (" + SQL.studentID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.registrationTypeID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.REGISTRATIONTYPE + " (" + SQL.registrationTypeID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE + ",");
		tableConstraints.add(SQL.CHECK + "(" + SQL.yearOfStudy2 + "<= 5 " + 
											SQL.AND + " " + SQL.yearOfStudy2 +">=0)");
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add(SQL.NOCOMMENT);
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsLecturer()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.LECTURER);
		tableConstraints.add("(");
		tableConstraints.add(SQL.lecturerID + ",");
		tableConstraints.add(SQL.titleID + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.foreName + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.familyName + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.PRIMARYKEY + "(" + SQL.lecturerID2 + ")" + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.titleID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.TITLES + " (" + SQL.titleID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("Same as for the table Students.");
		return tableConstraints;
	}
	public ArrayList<String> listConstraintsStudent()
	{
		ArrayList<String> tableConstraints = new ArrayList<String>();
		tableConstraints.add(SQL.CREATE + " " + SQL.TABLE + " " + SQL.STUDENT);
		tableConstraints.add("(");
		tableConstraints.add(SQL.studentID + ",");
		tableConstraints.add(SQL.titleID + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.foreName + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.familyName + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.dateOfBirth + " " + SQL.NOTNULL + ",");
		tableConstraints.add(SQL.PRIMARYKEY + "(" + SQL.studentID2 + ")" + ",");
		tableConstraints.add(SQL.FOREIGNKEY + "(" + SQL.titleID2 + ")" + " " + 
								SQL.REFERENCES + " " + SQL.TITLES + " (" + SQL.titleID2 + ")");
		tableConstraints.add(SQL.INDENT + SQL.ONDELETE + " " + SQL.CASCADE);
		tableConstraints.add(SQL.INDENT + SQL.ONUPDATE + " " + SQL.CASCADE);
		tableConstraints.add(");");
		tableConstraints.add(SQL.INDENT);
		tableConstraints.add("In this table, the student ID is a serial. A serial helps me to \n"
				+"auto-increment the key if it is a primary key. It also automatically adds constraints \n"
				+"such as NOT NULL and UNIQUE. Most of the things I require from my students are \n"
				+"compulsory. That is just my University Policy :). Harsh, I know.");
		return tableConstraints;
	}
}
