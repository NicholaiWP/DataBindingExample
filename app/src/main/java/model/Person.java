package model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.application.databindingexample.BR;

public class Person extends BaseObservable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }


    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public String getName() {
        return name;
    }
}
