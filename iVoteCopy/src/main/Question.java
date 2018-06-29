package main;

import java.util.ArrayList;

public class Question
{
	private String question;
	private Answer[] answers;

	public Question(String question, Answer[] answers)
	{
		this.question = question;
		this.answers = answers;
	}

	public String getQuestion()
	{
		return question;
	}

	public Answer[] getAnswers()
	{
		return answers;
	}

	public Answer[] getCorrectAnswers()
	{
		ArrayList<Answer> correctAnswersExpandable = new ArrayList<>();
		for (Answer answer : answers)
			if (answer.isCorrect())
				correctAnswersExpandable.add(answer);

		Answer[] correctAnswers = new Answer[correctAnswersExpandable.size()];
		for (int i = 0; i < correctAnswers.length; i++)
			correctAnswers[i] = correctAnswersExpandable.get(i);

		return correctAnswers;
	}

}
