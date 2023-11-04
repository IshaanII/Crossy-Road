package com.example.crossyroad;

import android.widget.ImageView;

public  class Log {
    private float x;
    private float y;
    private ImageView logImage;

    public Log(float x, float y, ImageView logImage) {
        this.x = x;
        this.y = y;
        this.logImage = logImage;
        logImage.setX(x);
        logImage.setY(y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        logImage.setX(x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        logImage.setY(y);
    }

    public ImageView getLogImage() {
        return logImage;
    }

    public void setLogImage(ImageView logImage) {
        this.logImage = logImage;

    }


    public float driveLeftSmallerLog(int change) {
        float newX = x - change;
        if (newX < -624) {
            this.setX(800);
        } else {
            this.setX(newX);
        }
        return newX;
    }

    public float driveLeftBiggerLog(int change) {
        float newX = x - change;
        if (newX < -813) {
            this.setX(990);
        } else {
            this.setX(newX);
        }
        return newX;
    }
}