package com.example.crossyroad;
import android.widget.ImageView;
public abstract class Vehicle {
    private float x;
    private float y;
    private ImageView carImage;

    public abstract void moveCar(int change);
}
