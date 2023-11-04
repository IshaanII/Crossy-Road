package com.example.crossyroad;

import android.graphics.Rect;
import android.widget.ImageView;


public class Player implements Person {
    //UI separated from game logic

    private String username;
    private int character;
    private int score;
    private float x;
    private float y;
    private int difficulty = 0;
    private int lives;
    private ImageView playerSprite;
    private int width;
    private int height;

    private static int highestYPosition = 0;
    private static int currYPosition = 0;
    private static int highestScore = 0;
    private boolean onLog = false;

    private boolean onBigLog = false;

    private boolean onSmallLog = false;


    public Player(String username, int character, int difficulty, int lives,
                  int width, int height, ImageView playerSprite) {
        this.username = username;
        this.character = character;
        this.difficulty = difficulty;
        this.lives = lives;
        this.playerSprite = playerSprite;
        this.setX(370);
        this.setY(1730);
        this.width = width;
        this.height = height;
    }
    public void moveUp(float y) {
        float newY = Math.max(80, y);
        this.setY(newY);
    }
    public void moveDown(float y, float customHeight, float imageHeight) {
        float newY = Math.min(y, customHeight - imageHeight);
        this.setY(newY);

    }
    public void moveLeft(float x) {
        float newX = Math.max(0, x);
        this.setX(newX);
    }

    public void moveRight(float x, float customWidth, float imageWidth) {
        float newX = Math.min(x, customWidth - imageWidth);
        this.setX(newX);
    }

    public void moveLeftOnLog(float x) {
        this.setX(x);
        if (x < -130) {
            onLog = false;
            onSmallLog = false;
            onBigLog = false;
            if (lives - 1 == 0) {
                if (score > highestScore) {
                    Player.setHighestScore(score);
                }
                GameScreen.setIsRunning(false);
            } else {
                lives--;
                restart();
            }
        }
    }

    public void scoreUpdate(int currYPosition) {
        currYPosition = Math.min(currYPosition, 19);
        Player.highestYPosition = Math.max(Player.highestYPosition, currYPosition);
        currYPosition = Player.highestYPosition;
        if (currYPosition < 11 || currYPosition > 15) {
            onLog = false;
            onSmallLog = false;
            onBigLog = false;
        }
        if (currYPosition > 15) {
            System.out.println("YOU WON");
            setScore(15);
            highestScore = score;
            GameScreen.setIsRunning(false);
        } else if (currYPosition >= 10) { // Pass Car 3 (+6)
            setScore(6);
        } else if (currYPosition >= 7) { // Pass Car 2 (+3)
            setScore(3);
        } else if (currYPosition >= 5) { // Pass Car 1 (+2)
            setScore(2);
        }


    }
    public void restart() {
        if (score > highestScore) {
            highestScore = score;
        }
        this.score = 0;
        highestYPosition = 0;
        currYPosition = 0;
        this.setX(370);
        this.setY(1730);
    }

    public boolean checkCollision(Car car1, Car car2, Car car3) {
        boolean hasCollided = false;
        if ((((x + width >= car1.getX()) && (x + width <= car1.getX() + car1.getWidth()))
                || (x >= car1.getX() && x <= car1.getX() + car1.getWidth()))
                && ((y >= car1.getY() && y <= car1.getY() + car1.getHeight())
                || (y + height >= car1.getY() && y + height <= car1.getY() + car1.getHeight()))) {

            if (lives - 1 == 0) {
                if (score > highestScore) {
                    Player.setHighestScore(score);
                }
                GameScreen.setIsRunning(false);
            }  else {
                lives--;
                hasCollided = true;
                restart();
            }
        }
        if ((((x + width >= car2.getX()) && (x + width <= car2.getX() + car2.getWidth()))
                || (x >= car2.getX() && x <= car2.getX() + car2.getWidth()))
                && ((y >= car2.getY() && y <= car2.getY() + car2.getHeight())
                || (y + height >= car2.getY() && y + height <= car2.getY() + car2.getHeight()))) {
            if (lives - 1 == 0) {
                if (score > highestScore) {
                    Player.setHighestScore(score);
                }
                GameScreen.setIsRunning(false);
            } else {
                lives--;
                hasCollided = true;
                restart();
            }
        }
        if ((((x + width >= car3.getX()) && (x + width <= car3.getX() + car3.getWidth()))
                || (x >= car3.getX() && x <= car3.getX() + car3.getWidth()))
                && ((y >= car3.getY() && y <= car3.getY() + car3.getHeight())
                || (y + height >= car3.getY() && y + height <= car3.getY() + car3.getHeight()))) {
            if (lives - 1 == 0) {
                if (score > highestScore) {
                    Player.setHighestScore(score);
                }
                GameScreen.setIsRunning(false);
            } else {
                lives--;
                hasCollided = true;
                restart();
            }
        }
        return hasCollided;
    }
    public boolean checkLogCollision(Log log1, Log log2) {
        if (currYPosition >= 11 && currYPosition <= 15) {
            Rect playerRect = new Rect();
            playerSprite.getHitRect(playerRect);

            Rect logRect1 = new Rect();
            log1.getLogImage().getHitRect(logRect1);

            Rect logRect2 = new Rect();
            log2.getLogImage().getHitRect(logRect2);


            if (Rect.intersects(playerRect, logRect2) && currYPosition <= 15) {
                onLog = true;
                onBigLog = true;
                onSmallLog = false;
            } else if (Rect.intersects(playerRect, logRect1)) {
                onLog = true;
                onSmallLog = true;
            } else {
                if (lives - 1 == 0) {
                    if (score > highestScore) {
                        Player.setHighestScore(score);
                    }
                    GameScreen.setIsRunning(false);
                } else {
                    onLog = false;
                    onSmallLog = false;
                    onBigLog = false;
                    lives--;
                    restart();
                }
            }
        } else {
            onLog = false;
            onSmallLog = false;
            onBigLog = false;
        }
        return onLog;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public void setX(float x) {
        this.x = x;
        this.playerSprite.setX(x);
    }

    public void setY(float y) {
        this.y = y;
        this.playerSprite.setY(y);
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getUsername() {
        return username;
    }

    public int getCharacter() {
        return character;
    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ImageView getPlayerSprite() {
        return playerSprite;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static int getHighestYPosition() {
        return highestYPosition;
    }

    public static void setHighestYPosition(int highestYPosition) {
        Player.highestYPosition = highestYPosition;
    }

    public static int getCurrYPosition() {
        return currYPosition;
    }

    public static void setCurrYPosition(int currYPosition) {
        Player.currYPosition = currYPosition;
    }

    public static void setHighestScore(int highestScore) {
        Player.highestScore = highestScore;
    }

    public static int getHighestScore() {
        return highestScore;
    }

    public boolean isOnLog() {
        return onLog;
    }

    public void setOnLog(boolean onLog) {
        this.onLog = onLog;
    }

    public boolean isOnBigLog() {
        return onBigLog;
    }

    public void setOnBigLog(boolean onBigLog) {
        this.onBigLog = onBigLog;
    }

    public boolean isOnSmallLog() {
        return onSmallLog;
    }

    public void setOnSmallLog(boolean onSmallLog) {
        this.onSmallLog = onSmallLog;
    }
}