package com.priyam.bmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.priyam.bmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_toolbar);

        TextView textView = getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title);
        textView.setText("Body Mass Index");
        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(binding.editWeight.getText().toString());
                int height_feet = Integer.parseInt(binding.editHeightFeet.getText().toString());
                int height_inch = Integer.parseInt(binding.editHeightInch.getText().toString());

                int total_inches = height_feet*12 + height_inch;
                double total_cm = total_inches*2.53;
                double total_m = total_cm/100;

                double bmi = weight/(total_m*total_m);

                if(bmi>25){
                    binding.textResult.setText("You are Over weight");
                } else if (bmi<18) {
                    binding.textResult.setText("You are Under weight");
                } else{
                    binding.textResult.setText("You are Healthy");
                }

            }
        });

    }
}