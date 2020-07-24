package ru.melandra.react;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season {

    @Expose
    @SerializedName("time_of_year")
    public String timeOfYear;

    @Expose
    public int year;
}
