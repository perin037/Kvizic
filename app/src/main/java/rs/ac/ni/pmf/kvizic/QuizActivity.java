package rs.ac.ni.pmf.kvizic;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import rs.ac.ni.pmf.kvizic.model.Question;
import rs.ac.ni.pmf.kvizic.model.QuestionsRepository;

public class QuizActivity extends AppCompatActivity {

    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_SCORE = "SCORE";

    private List<Question> _questions;
    private int _currentQuestionIndex;


    public static final ActivityResultContract<String, Integer> QUIZ_CONTRACT = new ActivityResultContract<String, Integer>() {
        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, String input) {
            final Intent intent = new Intent(context, QuizActivity.class);
            intent.putExtra(KEY_USERNAME, input);
            return intent;
        }

        @Override
        public Integer parseResult(int i, @Nullable Intent intent) {
            if(intent == null){
                return  -1;
            }else{
                intent.getIntExtra(KEY_SCORE, 0);
            }
            return null;
        }
    };

    private TextView _questionText;
    private RadioGroup _radioGroup;
    private RadioButton _radioButton1;
    private RadioButton _radioButton2;
    private RadioButton _radioButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        _questionText = findViewById(R.id.text_view_question);
        _radioGroup = findViewById(R.id.radio_group);
        _radioButton1 = findViewById(R.id.radio_button1);
        _radioButton2 = findViewById(R.id.radio_button2);
        _radioButton3 = findViewById(R.id.radio_button3);

        _questions = QuestionsRepository.findAll();
        _currentQuestionIndex = -1;

        showNextQuestion();
    }

    private void showNextQuestion() {
        _currentQuestionIndex++;

        if(_currentQuestionIndex < _questions.size()){
            displayCurrentQuestion();
        }else{
            finishQuiz();
        }
    }

    private void displayCurrentQuestion() {
        final Question question = _questions.get(_currentQuestionIndex);
        _questionText.setText(question.getQuestion());
        _radioButton1.setText(question.getOption1());
        _radioButton2.setText(question.getOption2());
        _radioButton3.setText(question.getOption3());

    }

    private void finishQuiz() {

    }
}