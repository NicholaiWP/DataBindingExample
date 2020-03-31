package model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.application.databindingexample.BR;

public class Person extends BaseObservable {

    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.lastName = lastName;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    @Bindable
    public String getName() {
        return name;
    }
}
