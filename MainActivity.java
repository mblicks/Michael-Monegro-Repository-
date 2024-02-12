package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText grade1EditText, grade2EditText, grade3EditText, grade4EditText, grade5EditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade1EditText = findViewById(R.id.grade1EditText);
        grade2EditText = findViewById(R.id.grade2EditText);
        grade3EditText = findViewById(R.id.grade3EditText);
        grade4EditText = findViewById(R.id.grade4EditText);
        grade5EditText = findViewById(R.id.grade5EditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeGPA();
            }
        });
    }

    private void computeGPA() {
        // Retrieve grades entered by the user
        String grade1Str = grade1EditText.getText().toString();
        String grade2Str = grade2EditText.getText().toString();
        String grade3Str = grade3EditText.getText().toString();
        String grade4Str = grade4EditText.getText().toString();
        String grade5Str = grade5EditText.getText().toString();

        // Check if any field is empty
        if (grade1Str.isEmpty() || grade2Str.isEmpty() || grade3Str.isEmpty() || grade4Str.isEmpty() || grade5Str.isEmpty()) {
            resultTextView.setText("Please enter all grades.");
            resultTextView.setBackgroundColor(Color.WHITE);
            return;
        }

        // Convert grades to doubles
        double grade1 = Double.parseDouble(grade1Str);
        double grade2 = Double.parseDouble(grade2Str);
        double grade3 = Double.parseDouble(grade3Str);
        double grade4 = Double.parseDouble(grade4Str);
        double grade5 = Double.parseDouble(grade5Str);

        // Compute GPA
        double totalGrade = grade1 + grade2 + grade3 + grade4 + grade5;
        double gpa = totalGrade / 5.0;

        // Display GPA
        resultTextView.setText(String.format("Your GPA is: %.2f", gpa));

        // Set background color based on GPA range
        if (gpa < 60) {
            resultTextView.setBackgroundColor(Color.RED);
        } else if (gpa >= 61 && gpa <= 79) {
            resultTextView.setBackgroundColor(Color.YELLOW);
        } else {
            resultTextView.setBackgroundColor(Color.GREEN);
        }

        // Change button text
        calculateButton.setText("Clear Form");
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForm();
            }
        });
    }

    private void clearForm() {
        // Clear EditText fields
        grade1EditText.setText("");
        grade2EditText.setText("");
        grade3EditText.setText("");
        grade4EditText.setText("");
        grade5EditText.setText("");

        // Clear result TextView
        resultTextView.setText("");

        // Change button text back to Compute GPA
        calculateButton.setText("Compute GPA");
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeGPA();
            }
        });

        // Reset background color
        resultTextView.setBackgroundColor(Color.TRANSPARENT);
    }
}
