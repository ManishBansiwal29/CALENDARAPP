package com.manish.calendarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int currentYear = 0, currentMonth = 0, currentDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CalendarView calendarView = findViewById(R.id.calendarView);

        final Button saveEvent = findViewById(R.id.saveEvent);
        final TextView selectedDay= findViewById(R.id.selectedDay);
        final TextView selectedMonth = findViewById(R.id.selectedMonth);
        final TextView selectedYear= findViewById(R.id.selectedYear);

        final List<String> calendarString = new ArrayList<>();
        final int[] days= new int[30];
        final EditText textInput = findViewById(R.id.textInput);

        final View dayContent = findViewById(R.id.dayContent);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedDay.setText("Selected Day : " + dayOfMonth);
                selectedMonth.setText("Selected Month : "+ month);
                selectedYear.setText("Selected Year : "+year);
                currentYear=year;
                currentMonth=month;
                currentDay=dayOfMonth;
                if (dayContent.getVisibility()==View.GONE){
                    dayContent.setVisibility(View.VISIBLE);
                }
                if (currentDay==days[0]){
                    textInput.setText(calendarString.get(0));
                }
            }
        });


        saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                days[0]=currentDay;
                calendarString.add(textInput.getText().toString());
                textInput.setText("");
            }
        });
    }
}
