package com.example.crossyroad;

import android.widget.ImageView;

public class Car extends Vehicle {
    private float x;
    private float y;
    private int width;
    private int height;
    private ImageView carImage;

    public Car(float x, float y, int width, int height, ImageView image) {
        this.width = width;
        this.height = height;
        this.carImage = image;
        this.setX(x);
        this.setY(y);
    }
    @Override
    public void moveCar(int change) {
        this.driveLeft(this.getX() - change);
    }

    private void driveLeft(float newX) {
        if (newX < -171) {
            this.setX(990);
        } else {
            this.setX(newX);
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ImageView getCarImage() {
        return carImage;
    }

    public void setX(float x) {
        this.x = x;
        this.carImage.setX(x);
    }

    public void setY(float y) {
        this.y = y;
        this.carImage.setY(y);
    }

    public void setCarImage(ImageView carImage) {
        this.carImage = carImage;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
