package com.example.crossyroad;

public class Tile {

    private String type;
    private int row;
    private int column;
    private int width;

    public Tile(String type, int x, int y, int width) {
        this.type = type;
        this.row = x;
        this.column = y;
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }
}


