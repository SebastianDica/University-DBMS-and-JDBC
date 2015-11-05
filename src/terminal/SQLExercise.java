package terminal;

import javax.swing.JFrame;

import DB.PartOne;
import DB.PartThree;
import DB.PartTwo;
import models.PartOneModel;
import panels.MainPanel;

public class SQLExercise 
{
	public static void main(String[] args)
	{
		CallHandler.handleArguments(args);
		JFrame terminalFrame = new JFrame("SSC Exercise 2");
		terminalFrame.setResizable(false);
		terminalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		terminalFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		terminalFrame.setUndecorated(true);
		PartOne partOne = new PartOne();
		PartOneModel partOneModel = new PartOneModel(partOne);
		PartTwo partTwo = new PartTwo(partOne);
		PartThree partThree = new PartThree(partTwo);
		MainPanel mainPanel = new MainPanel(partOneModel,partTwo,partThree);
		terminalFrame.add(mainPanel);
		terminalFrame.setVisible(true);
		LoadKeyboard.loadEscapeButton();
	}

}
