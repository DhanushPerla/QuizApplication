import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return answer == correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz!");
        System.out.println("Answer the following questions:\n");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.getQuestionText());

            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            int userAnswer = -1;
            while (true) {
                try {
                    System.out.print("Enter your choice (1-" + options.size() + "): ");
                    userAnswer = Integer.parseInt(scanner.nextLine());
                    if (userAnswer < 1 || userAnswer > options.size()) {
                        System.out.println("Invalid choice! Please choose between 1 and " + options.size());
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options.get(question.getOptions().indexOf(options.get(question.getOptions().get(question.correctOption - 1)))) + "\n");
            }
        }

        System.out.println("Quiz Over!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding questions
        quiz.addQuestion(new Question(
            "What is the capital of France?",
            Arrays.asList("Berlin", "Madrid", "Paris", "Rome"),
            3
        ));
        quiz.addQuestion(new Question(
            "Which language runs in a web browser?",
            Arrays.asList("Java", "C", "Python", "JavaScript"),
            4
        ));
        quiz.addQuestion(new Question(
            "Who is the father of Computer Science?",
            Arrays.asList("Charles Babbage", "Alan Turing", "John von Neumann", "Ada Lovelace"),
            1
        ));

        // Start the quiz
        quiz.start();
    }
}
