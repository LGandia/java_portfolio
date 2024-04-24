import java.util.*;

class Question {
    String question;
    String answer;

    Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return this.question; }
    public String getAnswer() { return this.answer; }
}

class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public void add(Question question) {
        if (questions.size() < 25) {
            questions.add(question);
        } else {
            System.out.println("Quiz is already full. Can't add more questions.");
        }
    }

    public void giveQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(question.getAnswer())) {
                score++;
            }
        }
        scanner.close();
    }

    public int getScore() {
        return score;
    }
}

public class QuizTime {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.add(new Question("What occasion corresponds to the longest day of the year?", "The summer solstice"));
        quiz.add(new Question("What is the distance from earth to the sun?", "93 million miles"));
        quiz.add(new Question("Which country is the largest in the world?", "Russia"));
        quiz.add(new Question("According to Guinness World Records, what's the best-selling book of all time?", "The Bible"));

        quiz.giveQuiz();

        System.out.println("Final score: " + quiz.getScore());
    }
}