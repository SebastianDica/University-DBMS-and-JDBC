package panelactivity;

import java.util.ArrayList;
import java.util.Observable;

public class MainActivityPanelActivity extends Observable {
	public ArrayList<String> currentMessage;
	public MainActivityPanelActivity()
	{
		super();
		currentMessage = new ArrayList<String>();
	}
	public void setCurrentMessage(ArrayList<String> currentMessage)
	{
		this.currentMessage = currentMessage;
		setChanged();
		notifyObservers();
	}
	public ArrayList<String> getCurrentMessage()
	{
		return currentMessage;
	}
}
