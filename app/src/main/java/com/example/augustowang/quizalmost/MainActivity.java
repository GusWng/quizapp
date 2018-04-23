package com.example.augustowang.quizalmost;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Declaration
    //Counter of questions
    int currentQuestion = 0;
    int correctAnswers = 0;
    int wrongAnswers = 0;

    //right Answer
    String trueAnswer;

    //Arraylist of sets
    ArrayList<questionSet> questions = new ArrayList<questionSet>();

    //Views
    ImageView rufzeichen;
    ImageView fragezeichen;
    TextView questionView;
    TextView answerA;
    TextView answerB;
    TextView answerC;
    TextView score;
    TextView wrongs;
    TextView scoreTitle;
    Button exitButton;
    Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation of the Views
        questionView = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        exitButton = findViewById(R.id.exitButton);
        resetButton = findViewById(R.id.resetButton);
        scoreTitle = findViewById(R.id.scoreTitle);

        score = findViewById(R.id.score);
        wrongs = findViewById(R.id.wrongs);

        questions.add(new questionSet("How many bones does the adult body include?", "300", "over 9000", "206", "c"));
        questions.add(new questionSet("What Cell compartment includes the human DNA?", "Cytoplasm", "Nucleus", "Mitochondria", "b"));
        questions.add(new questionSet("What size comparison matches the area of the small intestine?", "a soccer/football field", "the Mona Lisa painting", "a small restaurant", "a"));
        questions.add(new questionSet("How many hollow parts does the heart have?", "2", "4", "6", "b"));
        questions.add(new questionSet("What is the powerhouse of the cell?", "Nucleus", "Endoplasmatic Reticule", "Mitochondria", "c"));
        questions.add(new questionSet("What is the longest bone in the human body?", "the femur", "the spine", "the humerus", "a"));
        questions.add(new questionSet("What is not part of the blood?", "leukocytes", "glomeruli", "albumine", "b"));
        questions.add(new questionSet("What are the normal bloodpressure values?", "100/50", "120/80", "80/200", "b"));

        Log.v("ArrayList", "Question List initialised");
        setQuestionSet();
        Log.v("First question", "First set done");
    }

    public void setQuestionSet() {

        questionView.setText(questions.get(currentQuestion).getmQuestion());
        answerA.setText(questions.get(currentQuestion).getmAnswerA());
        answerB.setText(questions.get(currentQuestion).getmAnswerB());
        answerC.setText(questions.get(currentQuestion).getmAnswerC());

        Log.v("Set", "New question is set");
    }

    public void onRadioButtonClick(final View view) {
        //Is the RadioButton checked?
        boolean checked = ((RadioButton) view).isChecked();
        final Handler handler = new Handler();

        //Look for the checked one, if checked and true -> correct, else -> false.
        //Then increment currentQuestion by 1 and set to unchecked.

        switch (view.getId()) {
            /**
             * @answerA
             */
            case (R.id.answerA):
                if (checked && questions.get(currentQuestion).getmTrue() == "a") {
                    correct();

                } else {
                    wrong();
                }
                break;

            /**
             * @answerB
             */
            case (R.id.answerB):
                if (checked && questions.get(currentQuestion).getmTrue() == "b") {
                    correct();
                } else {
                    wrong();
                }
                break;

            /**
             * @answerC
             */
            case (R.id.answerC):
                if (checked && questions.get(currentQuestion).getmTrue() == "c") {
                    correct();
                } else {
                    wrong();
                }
                break;
        }

        currentQuestion++;

        if(currentQuestion<questions.size()){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ((RadioButton) view).setChecked(false);
                    setQuestionSet();
                }
            }, 1500);
        }

        if (currentQuestion == questions.size()) exit(view);
    }

    public void correct() {
        Toast toast = new Toast(getApplicationContext());
        toast.makeText(getApplicationContext(), "CORRECT", Toast.LENGTH_SHORT).show();
        correctAnswers++;
    }

    public void wrong() {
        Toast toast = new Toast(getApplicationContext());
        toast.makeText(getApplicationContext(), "WRONG, sadly", Toast.LENGTH_SHORT).show();
        wrongAnswers++;
    }

    //method for exiting or reaching the final question
    public void exit(View view) {
        rufzeichen = findViewById(R.id.rufzeichen);
        rufzeichen.setVisibility(View.VISIBLE);

        fragezeichen = findViewById(R.id.fragezeichen);
        fragezeichen.setVisibility(View.GONE);

        questionView.setVisibility(View.GONE);
        answerA.setVisibility(View.GONE);
        answerB.setVisibility(View.GONE);
        answerC.setVisibility(View.GONE);
        exitButton.setVisibility(View.GONE);
        scoreTitle.setVisibility(View.VISIBLE);

        score.setText(String.valueOf(correctAnswers));
        score.setVisibility(View.VISIBLE);

        wrongs.setText(String.valueOf(wrongAnswers));
        wrongs.setVisibility(View.VISIBLE);

    }

    //Reset all the things
    public void reset(View view) {
        scoreTitle.setVisibility(View.GONE);
        currentQuestion = 0;
        correctAnswers = 0;
        wrongAnswers = 0;
        setQuestionSet();

        questionView.setVisibility(View.VISIBLE);
        answerA.setVisibility(View.VISIBLE);
        answerB.setVisibility(View.VISIBLE);
        answerC.setVisibility(View.VISIBLE);
        exitButton.setVisibility(View.VISIBLE);
        score.setVisibility(View.GONE);
        wrongs.setVisibility(View.GONE);

        fragezeichen.setVisibility(View.VISIBLE);
        rufzeichen.setVisibility(View.GONE);
    }


}
