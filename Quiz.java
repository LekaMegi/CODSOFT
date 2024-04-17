package org.example;

import java.util.*;

class QuizQuestion {
    String question;
    List<String> options;
    char answer;

    public QuizQuestion(String question, List<String> options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}

public class Quiz {
    public static void main(String[] args) {
        // Store quiz questions
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("What is the capital of Germany?",
                Arrays.asList("A. London", "B. Paris", "C. Rome", "D. Berlin"), 'D'));
        quizQuestions.add(new QuizQuestion("How many states are in the US?",
                Arrays.asList("A. 48", "B. 49", "C. 50", "D. 52"), 'C'));

        // Set time limit for each question in seconds
        int timeLimit = 30;

        // Score calculation
        int score = 0;
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        Scanner scanner = new Scanner(System.in);

        // Display questions and handle answers
        for (QuizQuestion question : quizQuestions) {
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            String userAnswer = scanner.nextLine().toUpperCase();

            long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            if (elapsedTime > timeLimit) {
                System.out.println("Time's up!");
                continue;
            }

            if (userAnswer.charAt(0) == question.answer) {
                System.out.println("Correct!");
                score++;
                correctAnswers++;
            } else {
                System.out.println("Incorrect!");
                incorrectAnswers++;
            }
        }

        // Display final score
        System.out.println("Your score: " + score);

        // Display summary of correct/incorrect answers
        System.out.println("Summary:");
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + incorrectAnswers);
    }
}
