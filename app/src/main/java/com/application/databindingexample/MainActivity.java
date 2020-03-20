package com.application.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.application.databindingexample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Person person = new Person("Ben", 25);
        mainBinding.setPerson(person);
        mainBinding.setClick("click me");

        mainBinding.setHandlers(this);
    }

    public void notifyUser(View view){
        Toast.makeText(this, "it worked!", Toast.LENGTH_SHORT).show();

    }
}
