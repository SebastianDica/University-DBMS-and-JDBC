package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import DB.PartThree;
import DB.PartTwo;
import models.PartOneModel;
import panelactivity.MainActivityPanelActivity;
import terminal.CallHandler;

public class ControlPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainActivityPanelActivity mainActivity;
	private PartOneModel partOneModel;
	private PartTwo partTwo;
	private PartThree partThree;
	private MainActivityPanel mainPanel;

	public ControlPanel(MainActivityPanelActivity mainActivity,
			PartOneModel partOneModel,PartTwo partTwo,PartThree partThree,MainActivityPanel mainPanel)
	{
		super();
		this.mainPanel = mainPanel;
		setBackground(Color.GRAY);
		createMainControlPanel();
		this.mainActivity = mainActivity;
		this.partOneModel = partOneModel;
		this.partTwo = partTwo;
		this.partThree = partThree;
       	partTwo.driverSetup();
       	partTwo.createDatabase();
	}
	public void createMainControlPanel()
	{
		removeAll();
		JButton exit = new JButton("Exit System");
		exit.addActionListener(e ->
		{
			int exitOptionPane = JOptionPane.YES_NO_OPTION;
    		int answer = JOptionPane.showConfirmDialog (null, 
    				"Would you like to close this program?",
    				"Please don't close me :'(",exitOptionPane);
    		if(answer == JOptionPane.YES_OPTION)
    			{
    				partTwo.close();
    				System.exit(CallHandler.EC_SUCCESS);
    			}
		});
		JButton partOne = new JButton("PartOne");
		partOne.addActionListener(e ->
		{
			createPartOneControlPanel();
		});
		JButton partTwo = new JButton("PartTwo");
		partTwo.addActionListener(e ->
		{
			createPartTwoControlPanel();
		});
		JButton partThree = new JButton("PartThree");
		partThree.addActionListener(e ->
		{
			createPartThreeControlPanel();
		});
		setLayout(new GridLayout(10,1,10,10));
		add(exit);
		add(partOne);
		add(partTwo);
		add(partThree);
		revalidate();
		update();
	}
	private void createPartOneControlPanel() {
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createMainControlPanel();
		});
		JLabel tables = new JLabel("Tables:");
		tables.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
		JButton studentsTable = new JButton("Student");
		studentsTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListStudent());
		});
		JButton lecturerTable = new JButton("Lecturer");
		lecturerTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListLecturer());
		});
		JButton studentRegistrationTable = new JButton("StudentRegistration");
		studentRegistrationTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListStudentRegistration());
		});
		JButton studentContactTable = new JButton("StudentContact");
		studentContactTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListStudentContact());
		});
		JButton nextOfKinContactTable = new JButton("NextOfKinContact");
		nextOfKinContactTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListNextOfKinContact());
		});
		JButton lecturerContactTable = new JButton("LecturerContact");
		lecturerContactTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListLecturerContact());
		});
		JButton tutorTable = new JButton("Tutor");
		tutorTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListTutor());
		});
		JButton titleTable = new JButton("Titles");
		titleTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListTitles());
		});
		JButton registrationTypeTable = new JButton("RegistrationType");
		registrationTypeTable.addActionListener(e ->
		{
			mainActivity.setCurrentMessage(partOneModel.getListRegistrationType());
		});
		setLayout(new GridLayout(11,1,4,5));
		add(back);
		add(tables);
		add(studentsTable);
		add(lecturerTable);
		add(studentRegistrationTable);
		add(studentContactTable);
		add(nextOfKinContactTable);
		add(lecturerContactTable);
		add(tutorTable);
		add(titleTable);
		add(registrationTypeTable);
		revalidate();
		update();
	}
	private void createPartTwoControlPanel() {
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createMainControlPanel();
		});
		JButton createTables = new JButton("Create all tables");
		createTables.addActionListener(e ->
		{
		    SwingWorker<Void, Void> w = new SwingWorker<Void, Void>()
		    {
				   @Override
				   protected Void doInBackground() throws Exception
				   {
				    	try
				    	{
				    		partTwo.createAllTables();     
				    	}
				    	catch(Exception e)
				    	{
				    	    e.printStackTrace();
				    	}
				    	return null;
				    }
			};
			w.execute();
		
		});
		JButton populateDB = new JButton("Populate Database");
		populateDB.addActionListener(e ->
		{
		    SwingWorker<Void, Void> w = new SwingWorker<Void, Void>()
		    {
				   @Override
				   protected Void doInBackground() throws Exception
				   {
				    	try
				    	{
			    		partTwo.populateDB();
				    	}
				    	catch(Exception e)
				    	{
				    	    e.printStackTrace();
				    	}
				    	return null;
				    }
			};
			w.execute();
		
		});
		setLayout(new GridLayout(11,1,4,5));
		add(back);
		add(createTables);
		add(populateDB);
		revalidate();
		update();
	}
	private void createPartThreeControlPanel() {
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createMainControlPanel();
		});
		JButton registerStudent = new JButton("RegisterStudent");
		registerStudent.addActionListener(e ->
		{
			mainPanel.studentRegistrationView();
			studentRegistrationConfirm();
		});
		JButton assignTutor = new JButton("AssignTutor");
		assignTutor.addActionListener(e ->
		{
			mainPanel.tutorAssignView();
			tutorAssignConfirm();
		});
		JButton studentReport = new JButton("Student Report");
		studentReport.addActionListener(e ->
		{
			mainPanel.studentReportView();
			studentReportConfirm();
		});
		JButton tutorReport = new JButton("Tutor Report");
		tutorReport.addActionListener(e ->
		{
			mainPanel.tutorReportView();
			tutorReportConfirm();
		});
		setLayout(new GridLayout(11,1,4,5));
		add(back);
		add(registerStudent);
		add(assignTutor);
		add(studentReport);
		add(tutorReport);
		revalidate();
		update();
	}
	public void studentRegistrationConfirm()
	{
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createPartThreeControlPanel();
		});
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e ->
		{
			mainPanel.confirmStudentRegistration();
			createPartThreeControlPanel();
		});
		add(back);
		add(confirm);
		revalidate();
		update();
	}
	public void tutorAssignConfirm()
	{
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createPartThreeControlPanel();
		});
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e ->
		{
			mainPanel.confirmTutorRegistration();
			createPartThreeControlPanel();
		});
		add(back);
		add(confirm);
		revalidate();
		update();
	}
	public void tutorReportConfirm()
	{
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createPartThreeControlPanel();
		});
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e ->
		{
			ArrayList<String> result = mainPanel.confirmTutorReport();
			mainPanel.setCurrentMessageTR(result);
			createPartThreeControlPanel();
		});
		add(back);
		add(confirm);
		revalidate();
		update();
	}
	public void studentReportConfirm()
	{
		removeAll();
		JButton back = new JButton("Back");
		back.addActionListener(e ->
		{
			mainPanel.mainView();
			createPartThreeControlPanel();
		});
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(e ->
		{
			ArrayList<String> result = mainPanel.confirmStudentReport();
			mainPanel.setCurrentMessageSR(result);
			createPartThreeControlPanel();
		});
		add(back);
		add(confirm);
		revalidate();
		update();
	}
	public void update()
	{
		repaint();
	}
}
