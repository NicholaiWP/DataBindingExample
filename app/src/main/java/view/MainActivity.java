package view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.application.databindingexample.R;
import com.application.databindingexample.databinding.ActivityMainBinding;
import java.util.ArrayList;
import adapters.MyRecyclerViewAdapter;
import model.Person;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

         setupRecyclerView();

        //step 1: enable databinding in the build.gradle file (module:app)
        /*
        android {
    ...
    defaultConfig {
       ...
    }
    dataBinding {
        enabled = true
    }
         */
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = mainBinding.viewPersonList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> dataModelList = new ArrayList<>();
        dataModelList.add(new Person("Peter", 11));
        dataModelList.add(new Person("Richard", 15));
        dataModelList.add(new Person("Bob", 18));
        dataModelList.add(new Person("Lenny", 20));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }

}
