package view;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.application.databindingexample.R;
import model.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.application.databindingexample.databinding.ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

         mainBinding.setModel(new Person("Example Name", "Example Last name"));
    }



}
