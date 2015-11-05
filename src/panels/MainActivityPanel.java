package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.PartThree;
import DB.PartTwo;

import com.sun.prism.Surface;

import panelactivity.MainActivityPanelActivity;

public class MainActivityPanel extends JPanel implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainActivityPanelActivity model;
	private static final String INDENT = "               ";
	private JTextArea mainArea;
	private JTextArea titleID;
	private JTextArea forename;
	private JTextArea familyname;
	private JTextArea dateOfBirth;
	private JTextArea emailAddress;
	private JTextArea postalAddress;
	private JTextArea yearOfStudy;
	private JTextArea registrationType;
	private JTextArea nokname;
	private JTextArea nokemail;
	private JTextArea nokaddress;
	private PartThree partThree;
	private JTextArea lecturerIDT;
	private JTextArea studentIDT;
	private JTextArea studentReportID;
	private JTextArea tutorReportID;
	public MainActivityPanel(MainActivityPanelActivity model,PartThree partThree)
	{
		super(new GridBagLayout());
		this.partThree = partThree;
		this.model = model;
		setBackground(new Color(24,24,24));
		mainArea = new JTextArea();
		mainView();
	}
	public void studentReportView()
	{
		removeAll();
		Color w = new Color(190,190,190);
		JLabel form = new JLabel("Student Report");
		form.setForeground(w);
		form.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));
		studentReportID = new JTextArea(5,2);
		JLabel studentIDTLabel = new JLabel("StudentID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		add(form);
		setLayout(new GridLayout(14, 2, 0, 10));
		add(studentIDTLabel);
		add(studentReportID);
		revalidate();
		repaint();
	}
	public void tutorReportView()
	{
		removeAll();
		Color w = new Color(190,190,190);
		JLabel form = new JLabel("Tutor Report");
		form.setForeground(w);
		form.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));
		tutorReportID = new JTextArea(5,2);
		JLabel tutorIDTLabel = new JLabel("LecturerID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		add(form);
		setLayout(new GridLayout(14, 2, 0, 10));
		add(tutorIDTLabel);
		add(tutorReportID);
		revalidate();
		repaint();
	}
	public void tutorAssignView()
	{
		removeAll();
		Color w = new Color(190,190,190);
		JLabel form = new JLabel("Tutor Assign Form");
		form.setForeground(w);
		form.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));
		studentIDT = new JTextArea(5,2);
		JLabel studentIDTLabel = new JLabel("StudentID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		lecturerIDT = new JTextArea(5,2);
		JLabel lecturerIDTLabel = new JLabel("LecturerID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		add(form);
		setLayout(new GridLayout(14, 2, 0, 10));
		add(studentIDTLabel);
		add(studentIDT);
		add(lecturerIDTLabel);
		add(lecturerIDT);
		revalidate();
		repaint();
	}
	public void studentRegistrationView()
	{
		removeAll();
		Color w = new Color(190,190,190);
		JLabel form = new JLabel("Student Registration Form");
		form.setForeground(w);
		form.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));
		titleID = new JTextArea(5,2);
		titleID.setSize(100,1);
		JLabel titleIDLabel = new JLabel("Title ID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		forename = new JTextArea(5,2);
		JLabel forenameLabel = new JLabel ("Forename"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		familyname = new JTextArea(5,2);
		JLabel familynameLabel = new JLabel ("Familyname"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		dateOfBirth = new JTextArea(5,2);
		JLabel dateOfBirthLabel = new JLabel ("Date of Birth (dd/mm/yyyy)"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		JLabel studentContact = new JLabel ("Student Contacts"){{ setForeground(w); new Font(Font.MONOSPACED,Font.CENTER_BASELINE,10);}};
		emailAddress = new JTextArea(5,2);
		JLabel emailAddressLabel = new JLabel ("E-mail Address"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		postalAddress = new JTextArea(5,2);
		JLabel postalAdressLabel = new JLabel ("Postal address"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		yearOfStudy = new JTextArea(5,2);
		JLabel yearOfStudyLabel = new JLabel ("Year of Study"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		registrationType = new JTextArea(5,2);
		JLabel registrationTypeLabel = new JLabel ("Registration Type ID"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		JLabel nextOfKinContact = new JLabel ("Next of Kin Contacts"){{ setForeground(w); new Font(Font.MONOSPACED,Font.CENTER_BASELINE,10);}};
		nokname = new JTextArea(5,2);
		JLabel noknameLabel = new JLabel ("Name"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		nokemail = new JTextArea(5,2);
		JLabel nokemailLabel = new JLabel ("E-Mail Address"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		nokaddress = new JTextArea(5,2);
		JLabel nokaddressLabel = new JLabel ("Postal address"){{ setForeground(w); new Font(Font.MONOSPACED,Font.PLAIN,10);}};
		add(form);
		add(new JLabel());
		setLayout(new GridLayout(14, 2, 0, 10));
		add(titleIDLabel);add(titleID);
		add(forenameLabel);add(forename);
		add(familynameLabel);add(familyname);
		add(dateOfBirthLabel);add(dateOfBirth);
		add(studentContact);add(new JLabel());
		add(emailAddressLabel);add(emailAddress);
		add(postalAdressLabel);add(postalAddress);
		add(yearOfStudyLabel);add(yearOfStudy);
		add(registrationTypeLabel);add(registrationType);
		add(nextOfKinContact);add(new JLabel());
		add(noknameLabel);add(nokname);
		add(nokemailLabel);add(nokemail);
		add(nokaddressLabel);add(nokaddress);
		revalidate();
		repaint();
	}
	public ArrayList<String> confirmStudentReport()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("A problem occured while trying to gather the data.");
		partThree.restoreConnection();
		try
		{
			result = partThree.studentReport(Integer.parseInt(studentReportID.getText()));		
		}
		catch (Exception e1) {
			setSimpleMessage("This student doesn't appear to be in the database");
		}
		mainView();
		return result;
	}
	public ArrayList<String> confirmTutorReport()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("A problem occured while trying to gather the data.");
		partThree.restoreConnection();
		try
		{
			result = partThree.tutorReport(Integer.parseInt(tutorReportID.getText()));		
		}
		catch (Exception e1) {
			setSimpleMessage("This tutor doesn't appear to be in the database");
		}
		mainView();
		return result;
	}
	public void setCurrentMessageSR(ArrayList<String> details)
	{
		if(details.isEmpty())
		{
			mainView();
			mainArea.setText("Please check the details provided");
		}
		else
		{
		mainView();
		mainArea.setText("");
		initialNewLine(2);
		mainArea.append(INDENT + "----------STUDENT REPORT----------" + "\n" );
		mainArea.append(INDENT + "-- Student ID: " + details.get(1) + "\n");
		mainArea.append(INDENT + "-- Name: " + details.get(0) + " " + details.get(3) 
				+ " " + details.get(2) + "\n");
		mainArea.append(INDENT + "-- Date of birth: " + details.get(4) + "\n");
		mainArea.append(INDENT + "-- Year of study: " + details.get(5) + "\n");
		mainArea.append(INDENT + "-- Registration type: " + details.get(6) + "\n");
		mainArea.append(INDENT + "-- E-Mail Address: " + details.get(7) + "\n");
		mainArea.append(INDENT + "-- Postal Address: " + details.get(8) + "\n");
		mainArea.append(INDENT + "-- Next of Kin Contact -----------\n");
		mainArea.append(INDENT + "-- Name: " + details.get(9) + "\n");
		mainArea.append(INDENT + "-- E-Mail Address: " + details.get(10) + "\n");
		mainArea.append(INDENT + "-- Postal Address: " + details.get(11) + "\n");
		mainArea.append(INDENT + "-- Personal Tutor ----------------\n");
		mainArea.append(INDENT + "-- Lecturer ID: " + details.get(12) + "\n");
		mainArea.append(INDENT + "-- Name: " + details.get(13) + " " + details.get(14) + "\n");
		mainArea.append(INDENT + "----------------------------------");
		}
	}
	public void setCurrentMessageTR(ArrayList<String> details)
	{
		if(details.isEmpty())
		{
			mainView();
			mainArea.setText("Please check the details provided");
		}
		else
		{
		mainView();
		mainArea.setText("");
		initialNewLine(2);
		int times = Integer.parseInt(details.get(details.size() - 1));
		int last = 0;
		for(int i = 0 ; i < times ; i++)
		{
			mainArea.append(details.get(last) + "\n");
			int tutees = Integer.parseInt(details.get(last + 1));
			last += 2;
			for(int j = 0 ; j < tutees; j++)
			{
				mainArea.append(INDENT + "----------------------------------" + "\n" );
				mainArea.append(INDENT + "-- Student ID: " + details.get(last + 1) + "\n");
				mainArea.append(INDENT + "-- Name: " + details.get(last) + " " + details.get(last + 3) 
							+ " " + details.get(last + 2) + "\n");
				mainArea.append(INDENT + "-- Date of birth: " + details.get(last + 4) + "\n");
				mainArea.append(INDENT + "-- Registration type: " + details.get(last + 6) + "\n");
				mainArea.append(INDENT + "-- E-Mail Address: " + details.get(last + 7) + "\n");
				mainArea.append(INDENT + "-- Postal Address: " + details.get(last + 8) + "\n");
				mainArea.append(INDENT + "-- Next of Kin Contact -----------\n");
				mainArea.append(INDENT + "-- Name: " + details.get(last + 9) + "\n");
				mainArea.append(INDENT + "-- E-Mail Address: " + details.get(last + 10) + "\n");
				mainArea.append(INDENT + "-- Postal Address: " + details.get(last + 11) + "\n");
				mainArea.append(INDENT + "----------------------------------" + "\n");
				last+=15;
			}
			
		}
		}
	}
	public void setSimpleMessage(String message)
	{
		mainView();
		mainArea.setText("");
		initialNewLine(2);
		mainArea.append(message);
	}
	public void confirmStudentRegistration()
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		partThree.restoreConnection();
		try {
			partThree.insertINTOStudent(Integer.parseInt(titleID.getText()),
					forename.getText(),familyname.getText(),
					new java.sql.Date((dateformat.parse(dateOfBirth.getText())).getTime()),
					emailAddress.getText(),postalAddress.getText(),
					Integer.parseInt(yearOfStudy.getText()),
					Integer.parseInt(registrationType.getText()),
					nokname.getText(),nokemail.getText(),nokaddress.getText());
		} catch (Exception e1) {
			setSimpleMessage("The registration has failed. Please check the details you have provided");
		}
	}
	public void confirmTutorRegistration()
	{
		partThree.restoreConnection();
		try
		{
			partThree.insertINTOTutor(Integer.parseInt(studentIDT.getText()),
			Integer.parseInt(lecturerIDT.getText()));
		}
		catch (Exception e1)
		{
			setSimpleMessage("The registration has failed. Please check the details you have provided");
		}
	}
	public void mainView()
	{
		removeAll();
		setLayout(new GridBagLayout());
		mainArea.setEditable(false);
       	mainArea.setBackground(new Color(24,24,24));
       	mainArea.setForeground(Color.WHITE);
       	mainArea.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		JScrollPane scrollPane = new JScrollPane(mainArea);
        GridBagConstraints constraints = new GridBagConstraints();
       	constraints.gridwidth = GridBagConstraints.REMAINDER;
       	constraints.fill = GridBagConstraints.HORIZONTAL;
      	constraints.fill = GridBagConstraints.BOTH;
       	constraints.weightx = 1.0;
       	constraints.weighty = 1.0;
       	add(scrollPane, constraints);
       	revalidate();
       	repaint();
	}
	@Override
	public void update(Observable arg0, Object arg1) {
			mainArea.setText("");
			initialNewLine(2);
			ArrayList<String> message = model.getCurrentMessage();
			for(int i = 0; i < message.size() ;i++)
			{
				mainArea.append(INDENT + message.get(i) + "\n" );
			}
	}
	public void initialNewLine(int times)
	{
		for(int i = 0 ; i < times ; i++)
		{
			mainArea.append("\n");
		}
	}
}
