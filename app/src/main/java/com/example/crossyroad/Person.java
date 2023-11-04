package com.example.crossyroad;

public interface Person {

    public abstract void moveUp(float pos);
    public abstract void moveDown(float y, float customHeight, float imageHeight);
    public abstract void moveLeft(float pos);
    public abstract void moveRight(float x, float customWidth, float imageWidth);
}
