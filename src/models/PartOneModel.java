package models;

import java.util.ArrayList;
import java.util.Observable;

import DB.PartOne;

public class PartOneModel extends Observable{
	private PartOne subject;
	public PartOneModel(PartOne subject)
	{
		super();
		this.subject = subject;
	}
	public ArrayList<String> getListStudent()
	{
		return subject.listConstraintsStudent();
	}
	public ArrayList<String> getListLecturer()
	{
		return subject.listConstraintsLecturer();
	}
	public ArrayList<String> getListStudentRegistration()
	{
		return subject.listConstraintsStudentRegistration();
	}
	public ArrayList<String> getListStudentContact()
	{
		return subject.listConstraintsStudentContact();
	}
	public ArrayList<String> getListNextOfKinContact()
	{
		return subject.listConstraintsNextOfKinContact();
	}
	public ArrayList<String> getListLecturerContact()
	{
		return subject.listConstraintsLecturerContact();
	}
	public ArrayList<String> getListTutor()
	{
		return subject.listConstraintsTutor();
	}
	public ArrayList<String> getListTitles()
	{
		return subject.listConstraintsTitles();
	}
	public ArrayList<String> getListRegistrationType()
	{
		return subject.listConstraintsRegistrationType();
	}
}
