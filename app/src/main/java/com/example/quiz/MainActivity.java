package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView question,progress;
    private Button Next,optionA,optionB,optionC,optionD;
    private ImageView quiz_image;
    private ProgressBar progressBar;
    private ArrayList<Question> QuizQuestion;
    int currentPos=0,Progress=1,score=0;
    String selectedOption="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         question = findViewById(R.id.question);
         progress = findViewById(R.id.progress);
         optionA = findViewById(R.id.optionA);
         optionB = findViewById(R.id.optionB);
         optionC = findViewById(R.id.optionC);
         optionD = findViewById(R.id.optionD);
         Next = findViewById(R.id.Next);
         quiz_image = findViewById(R.id.quiz_image);
         progressBar = findViewById(R.id.progressBar);
         QuizQuestion= new ArrayList<>();
         getQuizQuestion(QuizQuestion);
         setDataToViews(currentPos);

         optionA.setOnClickListener(this);
         optionB.setOnClickListener(this);
         optionC.setOnClickListener(this);
         optionD.setOnClickListener(this);
         Next.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
          optionA.setBackgroundColor(Color.WHITE);
          optionB.setBackgroundColor(Color.WHITE);
          optionC.setBackgroundColor(Color.WHITE);
          optionD.setBackgroundColor(Color.WHITE);

          Button clicked=(Button) view;
          if(clicked.getId()==R.id.Next)
              {
                  Progress++;
                  currentPos++;
                  setDataToViews(currentPos);
              }
          else
              {
                  selectedOption=clicked.getText().toString();
                  clicked.setBackgroundColor(Color.YELLOW);
              }

    }

    private void setDataToViews(int currentPos) {

        question.setText(QuizQuestion.get(currentPos).getQuestion());
        quiz_image.setImageResource(QuizQuestion.get(currentPos).getImage());
        progress.setText(Progress+"/10");
        progressBar.setProgress(Progress);
        optionA.setText(QuizQuestion.get(currentPos).getOptionA());
        optionB.setText(QuizQuestion.get(currentPos).getOptionB());
        optionC.setText(QuizQuestion.get(currentPos).getOptionC());
        optionD.setText(QuizQuestion.get(currentPos).getOptionD());


    }

    private void getQuizQuestion( ArrayList<Question> QuizQuestion) {
        QuizQuestion.add(new Question(1,"Which animal is in the picture?",R.drawable.ic_rhino,
                "Lion",
                "Cat",
                "Rhino",
                "Horse",
                3));
        QuizQuestion.add(new Question(2,"Which animal is in the picture?",R.drawable.ic_chimpanzee,
                "Tiger",
                "Chimpanzee",
                "Leopard",
                "Hippo",
                2));
        QuizQuestion.add(new Question(3,"Which animal is in the picture?",R.drawable.ic_dog,
                "Dog",
                "Cat",
                "Rhino",
                "Horse",
                1));
        QuizQuestion.add(new Question(4,"Which animal is in the picture?",R.drawable.ic_giraffe,
                "Lion",
                "Cat",
                "Giraffe",
                "Horse",
                3));
        QuizQuestion.add(new Question(5,"Which animal is in the picture?",R.drawable.ic_kangaroo,
                "Lion",
                "Cat",
                "Kangaroo",
                "Horse",
                3));
        QuizQuestion.add(new Question(6,"Which animal is in the picture?",R.drawable.ic_panda,
                "Lion",
                "Cat",
                "Cheetah",
                "Panda",
                4));
        QuizQuestion.add(new Question(7,"Which animal is in the picture?",R.drawable.ic_peacock,
                "Lion",
                "Peacock",
                "Rhino",
                "Horse",
                2));
        QuizQuestion.add(new Question(8,"Which animal is in the picture?",R.drawable.ic_zebra,
                "zebra",
                "Cat",
                "Rhino",
                "Horse",
                1));
        QuizQuestion.add(new Question(9,"Which animal is in the picture?",R.drawable.ic_lion,
                "Lion",
                "Cat",
                "Rhino",
                "Horse",
                1));
        QuizQuestion.add(new Question(10,"Which animal is in the picture?",R.drawable.ic_rabbit,
                "Lion",
                "Cat",
                "Rabbit",
                "Horse",
                3));

    }

}