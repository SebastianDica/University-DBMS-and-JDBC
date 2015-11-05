package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observer;

import javax.swing.JPanel;

import DB.PartThree;
import DB.PartTwo;
import models.PartOneModel;
import panelactivity.MainActivityPanelActivity;

public class MainPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel control;
	private JPanel terminal;
	private MainActivityPanel mainActivity;
	private JPanel top;
	public MainPanel(PartOneModel partOneModel,PartTwo partTwo,PartThree partThree)
	{
		super();
		MainActivityPanelActivity mainActivityModel = new MainActivityPanelActivity();
		terminal = new TerminalPanel(partTwo);
		partTwo.addObserver((Observer) terminal);
		mainActivity = new MainActivityPanel(mainActivityModel,partThree);
		control = new ControlPanel(mainActivityModel,partOneModel,partTwo,partThree,mainActivity);
		top = new TopPanel();
		mainActivityModel.addObserver((Observer) mainActivity);
		top.setPreferredSize(new Dimension(700,100));
		control.setPreferredSize(new Dimension(250,600));
		terminal.setPreferredSize(new Dimension(700,150));
		mainActivity.setPreferredSize(new Dimension(450,325));
		setLayout(new BorderLayout(10,10));
		add(top,BorderLayout.NORTH);
		add(control,BorderLayout.EAST);	
		add(terminal,BorderLayout.SOUTH);
		add(mainActivity,BorderLayout.CENTER);
		setBackground(Color.BLACK);
	}
}
