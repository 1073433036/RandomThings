package main;

public class Student
{
	private String name;
	private Answer[] selectedAnswers;

	public Student(String name, Answer[] selectedAnswers)
	{
		this.name = name;
		this.selectedAnswers = selectedAnswers;
	}

	public String getName()
	{
		return name;
	}

	public Answer[] getSelectedAnswers()
	{
		return selectedAnswers;
	}
}
