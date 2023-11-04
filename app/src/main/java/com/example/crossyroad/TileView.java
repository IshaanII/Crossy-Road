package com.example.crossyroad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class TileView extends View {

    private final int horizontalTiles = 10;
    private static int currRow = 0;
    private Paint paintColor;


    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintColor = new Paint();
    }
    private List<Tile> tiles = new ArrayList<>();

    private void drawSection(int rows, String type) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < horizontalTiles; j++) {
                tiles.add(new Tile(type, currRow, j, 100));
            }
            currRow++;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int tileSize = getHeight() / 20;
        int tileWidth = getWidth() / 10;

        drawSection(4, "goal");
        drawSection(4, "water");
        drawSection(2, "safe");
        drawSection(8, "road");
        drawSection(2, "safe");

        for (Tile tile : tiles) {
            int left = tile.getColumn() * tileWidth;
            int top = tile.getRow() * tileSize;
            int right = left + tileWidth;
            int bottom = top + tileSize;
            if (tile.getType().equals("goal")) {
                paintColor.setColor(Color.rgb(255, 191, 105));
            } else if (tile.getType().equals("water")) {
                paintColor.setColor(Color.rgb(72, 202, 228));
            } else if (tile.getType().equals("safe")) {
                paintColor.setColor(Color.rgb(125, 205, 133));
            } else {
                paintColor.setColor(Color.rgb(35, 35, 35));
            }
            canvas.drawRect(left, top, right, bottom, paintColor);
        }
        currRow = 0;
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setTextSize(20);

    }

}


