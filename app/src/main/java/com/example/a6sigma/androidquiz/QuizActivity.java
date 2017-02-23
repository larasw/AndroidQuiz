package com.example.a6sigma.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestion;

    private RadioGroup mRadioGroup;
    private RadioButton mButton1;
    private RadioButton mButton2;
    private RadioButton mButton3;
    private RadioButton mButton4;

    private RadioButton mChoosenButton;
    private Button mNext;
    private int mCurrentIndex = 0;


    Question[] listOfQuestion = new Question[]{
            new Question(R.string.question_1,R.string.answer_1_1,R.string.answer_1_2,R.string.answer_1_3,R.string.answer_1_4,3),
            new Question(R.string.question_2,R.string.answer_2_1,R.string.answer_2_2,R.string.answer_2_3,R.string.answer_2_4,1),
            new Question(R.string.question_3,R.string.answer_3_1,R.string.answer_3_2,R.string.answer_3_3,R.string.answer_3_4,2),
            new Question(R.string.question_4,R.string.answer_4_1,R.string.answer_4_2,R.string.answer_4_3,R.string.answer_4_4,3),
            new Question(R.string.question_5,R.string.answer_5_1,R.string.answer_5_2,R.string.answer_5_3,R.string.answer_5_4,4),
            new Question(R.string.question_6,R.string.answer_6_1,R.string.answer_6_2,R.string.answer_6_3,R.string.answer_6_4,2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Question Text
        mQuestion = (TextView) findViewById(R.id.questionText);

        //Next Button
        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = mRadioGroup.getCheckedRadioButtonId();
                mChoosenButton = (RadioButton) findViewById(selectedId);

                int selectedNumber = numberSelectedAnswer();
                checkAnswer(selectedNumber);
            }
        });


        //Answer Radio Group
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        //Answer Button 1
        mButton1 = (RadioButton) findViewById(R.id.buton_1);

        //Answer Button 2
        mButton2 = (RadioButton) findViewById(R.id.buton_2);

        //Answer Button 3
        mButton3 = (RadioButton) findViewById(R.id.buton_3);

        //Answer Button 4
        mButton4 = (RadioButton) findViewById(R.id.buton_4);

        updateQuestion();
    }

    private int numberSelectedAnswer(){
        int number = 0;

        if(mButton1.isChecked()){
            number = 1;
        } else if (mButton2.isChecked()){
            number = 2;
        } else if (mButton3.isChecked()){
            number = 3;
        } else if (mButton4.isChecked()){
            number = 4;
        }
        return number;
    }

    private void updateQuestion(){
        int question = listOfQuestion[mCurrentIndex].getmTextRestId();
        mQuestion.setText(question);

        int answer1 = listOfQuestion[mCurrentIndex].getmButton1();
        mButton1.setText(answer1);

        int answer2 = listOfQuestion[mCurrentIndex].getmButton2();
        mButton2.setText(answer2);

        int answer3 = listOfQuestion[mCurrentIndex].getmButton3();
        mButton3.setText(answer3);

        int answer4 = listOfQuestion[mCurrentIndex].getmButton4();
        mButton4.setText(answer4);
    }

    private void checkAnswer(int userChoice){
        int answerIs = listOfQuestion[mCurrentIndex].getmAnswer();

        if(userChoice == answerIs){
            Toast.makeText(this, "GREAT", Toast.LENGTH_SHORT).show();

            if(mCurrentIndex==5){
                Intent intent = new Intent(QuizActivity.this,FinishActivity.class);
                startActivity(intent);
            } else {
                mCurrentIndex = (mCurrentIndex + 1) % listOfQuestion.length;
                updateQuestion();
            }
        } else {
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show();
        }
    }
}
