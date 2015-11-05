package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import panels.MainPanel;

public class PartThree {
	private PartTwo partTwo;
	private Connection connection;
	private String message = "";
	private ArrayList<String> result;
	public PartThree(PartTwo partTwo)
	{
		result = new ArrayList<String>();
		this.partTwo = partTwo;
		connection = partTwo.getConnection();
	}
	public void insertINTOTutor(int studentID,int lecturerID)
	{
		PreparedStatement insertion;
		try
		{
			if(connection!=null)
			{
			insertion = connection.prepareStatement("INSERT INTO " + SQL.TUTOR + 
					"(studentID,lecturerIDC)" + SQL.VALUES + "(? , ?)");
			insertion.setInt(1, studentID);
			insertion.setInt(2, lecturerID);
			insertion.executeUpdate();
			partTwo.setMessage("Tutor " + lecturerID + " succesfully assigned to student " + studentID);
			}
		}
		catch (SQLException e)
		{
			partTwo.setMessage("Insertion into table " + SQL.TUTOR + " has failed.");
			partTwo.setMessage("Check the details provided");
		}
	}
	public ArrayList<String> tutorReport(int lecturerID)
	{
		PreparedStatement selection;
		ArrayList<String> list = new ArrayList<String>(); int times = 0;
		try{
			if(connection!=null)
			{
				selection = connection.prepareStatement("SELECT C.yearOfStudy, COUNT(A.studentID) "
						+ "FROM Student A, StudentRegistration C WHERE "
						+ "A.studentid = C.studentid AND A.studentid IN "
						+ "(SELECT studentid FROM Tutor WHERE lectureridc = ?) "
						+ "GROUP BY C.yearOfStudy;");
				selection.setInt(1,lecturerID);
				ResultSet result = selection.executeQuery();
				while(result.next())
				{
					times++;
					int yearOfStudy = result.getInt(1);
					list.add("====================" +
					" Year of Study: " + result.getInt(1) + 
					" ====================");
					list.add("" + result.getInt(2));
					selection = connection.prepareStatement("SELECT A.titleid, A.studentid, "
							+ "A.foreName, A.familyName, A.dateOfBirth, B.yearOfStudy, "
							+ "B.registrationTypeID, C.eMailAddress, C.postalAddress, "
							+ "D.name, D.eMailAddress, D.postalAddress, E.lectureridc "
							+ "FROM Student A, StudentRegistration B, StudentContact C,"
							+ "NextOfKinContact D, Tutor E WHERE B.studentID = A.studentID "
							+ "AND C.studentID = A.studentID AND D.studentID = A.studentID AND "
							+ "E.studentID = A.studentID AND A.studentID IN (SELECT studentid FROM"
							+ " Tutor WHERE lectureridc = ?) AND B.yearOfStudy = ?;");
					selection.setInt(1, lecturerID);
					selection.setInt(2, result.getInt(1));
					ResultSet tutees = selection.executeQuery();
					while(tutees.next())
					{
						String title = ""; String reg = "";
						PreparedStatement getTitle = connection.prepareStatement("SELECT titleString FROM Titles" +
										" WHERE titleID = " + tutees.getInt(1) + ";");
						ResultSet titleresultSet = getTitle.executeQuery();
						while(titleresultSet.next())
						{
							title = titleresultSet.getString(1);
						}
						list.add(title);
						list.add("" + tutees.getInt(2));
						list.add(tutees.getString(3));
						list.add(tutees.getString(4));
						list.add(tutees.getDate(5).toString());
						list.add(tutees.getInt(6) + "");
						PreparedStatement getRegistrationType = connection.prepareStatement("SELECT description"
								+ " FROM RegistrationType WHERE registrationtypeid = " + tutees.getInt(7) + ";");
						ResultSet registrationSet = getRegistrationType.executeQuery();
						while(registrationSet.next())
						{
							reg = registrationSet.getString(1);
						}
						list.add(reg);
						list.add(tutees.getString(8));
						list.add(tutees.getString(9));
						list.add(tutees.getString(10));
						list.add(tutees.getString(11));
						list.add(tutees.getString(12));
						list.add(tutees.getInt(13) + "");
						PreparedStatement getTutor = connection.prepareStatement("SELECT foreName, familyName"
								+ " FROM Lecturer WHERE lecturerid = " + tutees.getInt(13) + ";");
						ResultSet tutorSet = getTutor.executeQuery(); String foname = ""; String faname = "";
						while(tutorSet.next())
						{
							foname = tutorSet.getString(1);
							faname = tutorSet.getString(2);
						}
						list.add(foname);
						list.add(faname);
					}
				}
				list.add("" + times);
			}
		}
		catch(Exception e)
		{
			partTwo.setMessage("Please check the details provided.");
		}
		return list;
		
	}
	public ArrayList<String> studentReport(int studentID)
	{
		PreparedStatement insertion;
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			if(connection!=null)
			{
				insertion = connection.prepareStatement("SELECT A.titleid, A.studentid, "
						+ "A.foreName, A.familyName, A.dateOfBirth, B.yearOfStudy, B.registrationTypeID, "
						+ "C.eMailAddress, C.postalAddress, D.name, D.eMailAddress, D.postalAddress, "
						+ "E.lectureridc FROM Student A, StudentRegistration B, StudentContact C, "
						+ "NextOfKinContact D, Tutor E WHERE A.studentID = ? AND B.studentID = ? "
						+ "AND C.studentID =? AND D.studentID = ? AND E.studentID = ?;");
				insertion.setInt(1, studentID);
				insertion.setInt(2, studentID);
				insertion.setInt(3, studentID);
				insertion.setInt(4, studentID);
				insertion.setInt(5, studentID);
				ResultSet result = insertion.executeQuery();
				while(result.next())
				{
					String title = ""; String reg = "";
					PreparedStatement getTitle = connection.prepareStatement("SELECT titleString FROM Titles" +
									" WHERE titleID = " + result.getInt(1) + ";");
					ResultSet titleresultSet = getTitle.executeQuery();
					while(titleresultSet.next())
					{
						title = titleresultSet.getString(1);
					}
					list.add(title);
					list.add("" + result.getInt(2));
					list.add(result.getString(3));
					list.add(result.getString(4));
					list.add(result.getDate(5).toString());
					list.add(result.getInt(6) + "");
					PreparedStatement getRegistrationType = connection.prepareStatement("SELECT description"
							+ " FROM RegistrationType WHERE registrationtypeid = " + result.getInt(7) + ";");
					ResultSet registrationSet = getRegistrationType.executeQuery();
					while(registrationSet.next())
					{
						reg = registrationSet.getString(1);
					}
					list.add(reg);
					list.add(result.getString(8));
					list.add(result.getString(9));
					list.add(result.getString(10));
					list.add(result.getString(11));
					list.add(result.getString(12));
					list.add(result.getInt(13) + "");
					PreparedStatement getTutor = connection.prepareStatement("SELECT foreName, familyName"
							+ " FROM Lecturer WHERE lecturerid = " + result.getInt(13) + ";");
					ResultSet tutorSet = getTutor.executeQuery(); String foname = ""; String faname = "";
					while(tutorSet.next())
					{
						foname = tutorSet.getString(1);
						faname = tutorSet.getString(2);
					}
					list.add(foname);
					list.add(faname);
				}
			}
		}
		catch(Exception e)
		{
			partTwo.setMessage("Student does not exist");
		}
		return list;
	}
	public void insertINTOStudent(int titleID, String foreName, String familyName, Date dob,
			String emailAddress, String postalAddress, int registrationID, int yearOfStudy,
			String nokName, String nokEmail, String nokAddress)
	{
		PreparedStatement insertion;
		int sid = 0;
		try
		{
			if(connection != null)
			{
			insertion = connection.prepareStatement("INSERT INTO " + SQL.STUDENT + 
					"(titleID,foreName,familyName,dateOfBirth)" + SQL.VALUES + "(? , ? , ? , ?)"
							+ " RETURNING studentID;");
			insertion.setInt(1, titleID);
			insertion.setString(2, foreName);
			insertion.setString(3, familyName);
			insertion.setDate(4, dob);
			ResultSet resultSet = insertion.executeQuery();
			while(resultSet.next())
			sid = resultSet.getInt(1);
			partTwo.setMessage("Insertion into " + SQL.STUDENT + " has been succesful.");
			insertion = connection.prepareStatement("INSERT INTO " + SQL.STUDENTCONTACT + 
					"(studentID,eMailAddress,postalAddress)" + SQL.VALUES + "(? , ? , ?)");
			insertion.setInt(1,sid);
			insertion.setString(2,emailAddress);
			insertion.setString(3,postalAddress);
			insertion.executeUpdate();
			partTwo.setMessage("Insertion into " + SQL.STUDENTCONTACT + " has been succesful.");
			insertion = connection.prepareStatement("INSERT INTO " + SQL.STUDENTREGISTRATION + 
					"(studentID,yearOfStudy,registrationTypeID)" + SQL.VALUES + "(? , ? , ?)");
			insertion.setInt(1,sid);
			insertion.setInt(2,yearOfStudy);
			insertion.setInt(3,registrationID);
			insertion.executeUpdate();
			partTwo.setMessage("Insertion into " + SQL.STUDENTREGISTRATION + " has been succesful.");
			insertion = connection.prepareStatement("INSERT INTO " + SQL.NEXTOFKINCONTACT + 
					"(studentID,name,eMailAddress,postalAddress)" + SQL.VALUES + "(? , ? , ? , ?)");
			insertion.setInt(1,sid);
			insertion.setString(2,nokName);
			insertion.setString(3,nokEmail);
			insertion.setString(4,nokAddress);
			insertion.executeUpdate();
			partTwo.setMessage("Insertion into " + SQL.NEXTOFKINCONTACT + " has been succesful.");
			}
		}
		catch (SQLException e)
		{
			partTwo.setMessage("Insertion into table " + SQL.STUDENT + " has failed.");
			partTwo.setMessage(e.getMessage());
		}
	}
	public void getTitleList()
	{
		//SELECT A.titleid, A.studentid, A.foreName, A.familyName, A.dateOfBirth, B.yearOfStudy, B.registrationT
		//ypeID, C.eMailAddress, C.postalAddress, D.name, D.eMailAddress, D.postalAddress, E.lectureridc FROM Student A, StudentRe
		//gistration B, StudentContact C, NextOfKinContact D, Tutor E WHERE A.studentID = 1 AND B.studentID = 1 AND C.studentID =
		//1 AND D.studentID = 1 AND E.studentID = 1;
	}
	public ArrayList<String> getResult()
	{
		return result;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public void restoreConnection()
	{
		connection = partTwo.getConnection();
	}
	
}
