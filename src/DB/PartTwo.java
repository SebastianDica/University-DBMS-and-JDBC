package DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;

import panels.MainPanel;
import panels.TerminalPanel;
public class PartTwo extends Observable{
	private String currentMessage = "Terminal accessed";
	private Connection conn = null;
	private int check = 0;
	private PartOne partOne;
	public PartTwo(PartOne partOne)
	{
		super();
		this.partOne = partOne;
	}
	public void createTableCheck(String command,String tableName)
	{
		setCheck(0);
		createTable(command,tableName);
	}
	public void setCheck(int value)
	{
		check = value;
	}
	public void driverSetup()
	{

		System.setProperty("jdbc.drivers","org.postgresql.Driver");
		try 
		{
			Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException ex) 
		{
			setMessage("Driver not found");
			System.out.println("Driver not found");
		}
		setMessage("PostgreSQL driver registered.");
	}
	public void createTable(String command,String tableName)
	{
		if(check < 2)
		{
			PreparedStatement tableCreation;
			try
			{
				tableCreation = conn.prepareStatement(command);
				tableCreation.execute();
				setMessage("Table " + tableName + " has been created succesfully.");
			}
			catch (SQLException e)
			{
				setCheck(check + 1);
				setMessage("Table " + tableName + " already exists.");
				try 
				{
					tableCreation = conn.prepareStatement("DROP TABLE " + tableName + " CASCADE;");
					tableCreation.execute();
					setMessage("Table " + tableName + " has been dropped succesfully.");
					createTable(command,tableName);
				} 
				catch (SQLException e1) 
				{
					setMessage("Connection has been lost.");
					close();
				}
			}
		}
	}
	public void createDatabase()
	{
		if(connect("exercise2fsd491") == true)
		{
			setMessage("Connection successful to exercise2fsd491.");
		}
		else
		{
			setMessage("Connection has failed. Check your network connection and your database.");
		}
	}
	public boolean connect(String dbName)
	{
		try 
		{
			conn = DriverManager.getConnection(SQL.DBNAME + dbName, SQL.USER, SQL.PW);
		}
		catch (SQLException conEx) 
		{
			setMessage("Connection has been refused");
		}
		if (conn != null) 
		{
			setMessage("Database accessed!");
			return true;
		} 
		else 
		{
			setMessage("Failed to make connection.");
			return false;
		}
	}
	public synchronized void setMessage(String message)
	{
		synchronized(this)
		{
			currentMessage = message;
			setChanged();
			notifyObservers();
		}
	}
	public synchronized String getMessage()
	{
		synchronized(this)
		{
			return currentMessage;
		}
	}
	public void insertINTO(String tableName, ArrayList<String> toInsert, ArrayList<String> whereToInsert)
	{
		String values = uniteArrayComma2(toInsert);
		String location = uniteArrayComma(whereToInsert);
		PreparedStatement insertion;
		try
		{
			insertion = conn.prepareStatement("INSERT INTO " + tableName + "(" 
					+ location + ")" + SQL.VALUES + "(" + values +");");
			insertion.executeUpdate();
			setMessage("Insertion of " + values + " into " + tableName + " has been succesful.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			setMessage("Insertion into table " + tableName + " has failed.");
		}
	}
	public void insertTitles()
	{
		ArrayList<String> whereTo = new ArrayList<String>(Arrays.asList(SQL.titleString2));
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Mr.")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Prof.")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Dr.")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Miss")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Mrs.")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Sir")),whereTo);
		insertINTO(SQL.TITLES,new ArrayList<String>(Arrays.asList("Lady")),whereTo);
	}
	public void insertStudents()
	{
		ArrayList<String> whereTo = new ArrayList<String>(
				Arrays.asList(SQL.titleID2,SQL.foreName2,SQL.familyName2,SQL.dateOfBirth2));
		ArrayList<String> whereTo2 = new ArrayList<String>(
				Arrays.asList(SQL.studentID2,SQL.eMailAddress2,SQL.postalAddress2));
		ArrayList<String> whereTo3 = new ArrayList<String>(
				Arrays.asList(SQL.studentID2,SQL.yearOfStudy2,SQL.registrationTypeID2));
		ArrayList<String> whereTo4 = new ArrayList<String>(
				Arrays.asList(SQL.studentID2,SQL.name2,SQL.eMailAddress2,SQL.postalAddress2));
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Sebastian","Dica","27/06/1995")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("1","emailAddress1","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("1","2","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("1","someName","emailAddress1","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Cameron","Angus","13/02/1996")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("2","emailAddress2","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("2","2","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("2","someName","emailAddress2","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Ben","Durrans","16/05/1996")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("3","emailAddress3","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("3","3","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("3","someName","emailAddress3","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Tom","Clarke","20/08/1995")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("4","emailAddress4","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("4","3","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("4","someName","emailAddress4","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Rowan","Cole","27/09/1996")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("5","emailAddress5","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("5","2","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("5","someName","emailAddress5","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Kyle","Taylor","12/11/1995")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("6","emailAddress6","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("6","4","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("6","someName","emailAddress6","someAddress")),whereTo4);
		insertINTO(SQL.STUDENT,new ArrayList<String>(Arrays.asList("1","Ben","Shaw","29/06/1995")),whereTo);
		insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(Arrays.asList("7","emailAddress7","someAddress")),whereTo2);
		insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(Arrays.asList("7","4","1")),whereTo3);
		insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(Arrays.asList("7","someName","emailAddress7","someAddress")),whereTo4);
		randomizeInsertStudent(whereTo,whereTo2,whereTo3,whereTo4);
	}
	public Connection getConnection()
	{
		return conn;
	}
	public void randomizeInsertStudent(ArrayList<String> whereTo,
			ArrayList<String> whereTo2,ArrayList<String> whereTo3,
			ArrayList<String> whereTo4)
	{
		Random generator = new Random();
		int lowD = 1;int highD = 28;
		int lowM = 1;int highM = 12;
		int lowY = 1980;int highY = 2010;
		int lowYS = 0; int highYS = 5;
		
		for(int i = 0 ; i < 100 ; i++)
		{
			insertINTO(SQL.STUDENT,new ArrayList<String>(
					Arrays.asList("1","FirstName" + i,"Surname" + i, 
							"" + (generator.nextInt(highD-lowD) + lowD) + 
							"/" + (generator.nextInt(highM-lowM) + lowM) +
							"/" + (generator.nextInt(highY-lowY) + lowY)))
							,whereTo);
			insertINTO(SQL.STUDENTCONTACT,new ArrayList<String>(
					Arrays.asList("" + (i+8),"emailAddress" + (i+8),"someAddress")),whereTo2);
			insertINTO(SQL.STUDENTREGISTRATION,new ArrayList<String>(
					Arrays.asList("" + (i+8),
							"" + (generator.nextInt(highYS-lowYS) + lowYS),"1")),whereTo3);
			insertINTO(SQL.NEXTOFKINCONTACT,new ArrayList<String>(
					Arrays.asList("" + (i+8),"someName","emailAddress" + (i+8),"someAddress")),whereTo4);
		}
	}
	public void insertLecturers()
	{
		ArrayList<String> whereTo = new ArrayList<String>(
				Arrays.asList(SQL.titleID2,SQL.foreName2,SQL.familyName2));
		ArrayList<String> whereTo2 = new ArrayList<String>(
				Arrays.asList(SQL.lecturerID2,SQL.office2,SQL.eMailAddress2));
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("3","Volker","Sorge")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("1","101","lecturerEMail1")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("3","Mark","Lee")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("2","102","lecturerEMail2")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("2","Jon","Rowe")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("3","103","lecturerEMail3")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("6","Robert","Hendley")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("4","104","lecturerEMail4")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("7","Elizabeth","Johnson")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("5","105","lecturerEMail5")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("3","Nick","Hawes")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("6","106","lecturerEMail6")),whereTo2);
		insertINTO(SQL.LECTURER,new ArrayList<String>(Arrays.asList("6","Martin","Escardo")),whereTo);
		insertINTO(SQL.LECTURERCONTACT,new ArrayList<String>(Arrays.asList("7","107","lecturerEMail7")),whereTo2);
	}
	public void insertRegistrationType()
	{
		ArrayList<String> whereTo = new ArrayList<String>(Arrays.asList(SQL.description2));
		insertINTO(SQL.REGISTRATIONTYPE,new ArrayList<String>(Arrays.asList("Undergraduate")),whereTo);
		insertINTO(SQL.REGISTRATIONTYPE,new ArrayList<String>(Arrays.asList("Postgraduate")),whereTo);
		insertINTO(SQL.REGISTRATIONTYPE,new ArrayList<String>(Arrays.asList("Exchange")),whereTo);
		insertINTO(SQL.REGISTRATIONTYPE,new ArrayList<String>(Arrays.asList("Masters")),whereTo);
		insertINTO(SQL.REGISTRATIONTYPE,new ArrayList<String>(Arrays.asList("PhD")),whereTo);
	}
	public void insertTutor()
	{
		ArrayList<String> whereTo = new ArrayList<String>(Arrays.asList(SQL.studentID2,SQL.lecturerID2C));
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("1","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("2","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("3","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("4","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("5","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("6","1")),whereTo);
		insertINTO(SQL.TUTOR,new ArrayList<String>(Arrays.asList("7","1")),whereTo);
	}
	public void populateDB()
	{
		insertTitles();
		insertLecturers(); // LecturerContact
		insertRegistrationType();
		insertStudents(); // StudentContact AND StudentRegistration AND NextOfKinContact
		insertTutor();
		setMessage("Completed populating database.");
	}
	public void close()
	{
		try {
			if(conn!=null && !conn.isClosed())
			conn.close();
			setMessage("Connection closed");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void createTableStudents()
	{
		createTableCheck(uniteArray(partOne.listConstraintsStudent()),SQL.STUDENT);
	}
	private void createTableTitles()
	{
		createTableCheck(uniteArray(partOne.listConstraintsTitles()),SQL.TITLES);
	}
	private void createTableLecturer()
	{
		createTableCheck(uniteArray(partOne.listConstraintsLecturer()),SQL.LECTURER);
	}
	private void createTableRegistrationType()
	{
		createTableCheck(uniteArray(partOne.listConstraintsRegistrationType()),SQL.REGISTRATIONTYPE);
	}
	private void createTableTutor()
	{
		createTableCheck(uniteArray(partOne.listConstraintsTutor()),SQL.TUTOR);
	}
	private void createTableLecturerContact()
	{
		createTableCheck(uniteArray(partOne.listConstraintsLecturerContact()),SQL.LECTURERCONTACT);
	}
	private void createTableNextOfKin()
	{
		createTableCheck(uniteArray(partOne.listConstraintsNextOfKinContact()),SQL.NEXTOFKINCONTACT);
	}
	private void createTableStudentContact()
	{
		createTableCheck(uniteArray(partOne.listConstraintsStudentContact()),SQL.STUDENTCONTACT);
	}
	private void createTableStudentRegistration()
	{
		createTableCheck(uniteArray(partOne.listConstraintsStudentRegistration()),SQL.STUDENTREGISTRATION);
	}
	public void createAllTables()
	{
		synchronized(this)
		{
			setMessage("Creating tables ... ... ...");
			createTableTitles();
			createTableStudents();
			createTableLecturer();
			createTableRegistrationType();
			setMessage("Still creating tables ... ... ...");
			createTableTutor();
			createTableLecturerContact();
			createTableNextOfKin();
			createTableStudentContact();
			setMessage("Almost there ... ... ...");
			createTableStudentRegistration();
			setMessage("Completed creating tables.");
		}
	}
	public String uniteArray(ArrayList<String> list)
	{
		String result = ""; int n = list.size();
		for(int i = 0 ; i < (n-2) ; i++)
		{
			result += list.get(i);
		}
		return result;
	}
	public String uniteArrayComma(ArrayList<String> list)
	{
		String result = ""; int n = list.size();
		for(int i = 0 ; i < n ; i++)
		{
			result += list.get(i);
			if(i<(n-1))
			result += ",";
		}
		return result;
	}
	public String uniteArrayComma2(ArrayList<String> list)
	{
		String result = ""; int n = list.size();
		for(int i = 0 ; i < n ; i++)
		{
			result += "'" + list.get(i) + "'";
			if(i<(n-1))
			result += ",";
		}
		return result;
	}
}
