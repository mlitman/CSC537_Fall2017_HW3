package com.example.awesomefat.shuntingyard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private TextView outputTV;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.outputTV = (TextView)this.findViewById(R.id.outputTV);
    }

    // IBAction onClickMeButtonPressed(UIView sender)
    public void onClickMeButtonPressed(View v)
    {
        ShuntingYard sy = new ShuntingYard(this.inputET.getText().toString());
        this.outputTV.setText(sy.getAnswer());
    }
}
