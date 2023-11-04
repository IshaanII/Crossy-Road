package com.example.crossyroad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GameScreen extends AppCompatActivity {


    private Player player;
    private Car car1;
    private Car car2;
    private Car car3;

    private Log log1;

    private Log log2;

    private TileView customView;
    private Handler handler = new Handler();


    private int lives;
    private TextView scoreTextBox;
    private TextView livesTextBox;
    private static boolean isRunning = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isRunning = true;
        Player.setHighestScore(0);
        Player.setHighestYPosition(0);
        Player.setCurrYPosition(0);

        String[] difficulties = {"Easy", "Medium", "Hard"};
        int[] initialLives = {5, 3, 1};
        String[] characters = {"Lion", "Panda", "Horse"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        int difficulty = intent.getIntExtra("difficulty", 0);
        lives = initialLives[difficulty];
        int character = intent.getIntExtra("character", 0);

        TextView userNameTextBox = findViewById(R.id.userName);
        userNameTextBox.setText("Username: " + username);

        TextView difficultyTextBox = findViewById(R.id.difficulty);
        difficultyTextBox.setText("Difficulty: " + difficulties[difficulty]);

        TextView characterSpriteTextBox = findViewById(R.id.characterSprite);
        characterSpriteTextBox.setText("Character: " + characters[character]);

        scoreTextBox = findViewById(R.id.score);
        scoreTextBox.setText("Score: " + 0);


        livesTextBox = findViewById(R.id.lives);
        livesTextBox.setText("Lives: " + lives);

        ImageView image = findViewById(R.id.playerSprite);

        if (character == 0) {
            image.setImageResource(R.drawable.lion_nobg);
        } else if (character == 1) {
            image.setImageResource(R.drawable.panda_nobg);
        } else {
            image.setImageResource(R.drawable.horse_nobg);
        }

        customView = findViewById(R.id.tile_view);
        customView.setBackgroundColor(Color.TRANSPARENT);
        customView.invalidate();

        player = new Player(username, character, difficulty, lives, 60, 55, image);
        player.getPlayerSprite().setMaxWidth(customView.getWidth() / 10);
        player.getPlayerSprite().setMaxHeight(customView.getHeight() / 20);



        ImageView c1 = findViewById(R.id.car1);
        ImageView c2 = findViewById(R.id.car2);
        ImageView c3 = findViewById(R.id.car3);
        car1 = new Car(990, 1200, 62, 66, c1); //blue
        car2 = new Car(990, 950, 79, 64, c2); //orange
        car3 = new Car(990, 1400, 72, 89, c3); //red

        ImageView l1 = findViewById(R.id.log2);
        ImageView l2 = findViewById(R.id.log1);

        log1 = new Log(525, 600, l1); // small log
        log2 = new Log(375, 325, l2); // big log

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int change = customView.getWidth() / 30;
                log2.driveLeftBiggerLog(change);
                player.checkLogCollision(log1, log2);
                if (player.isOnBigLog() && !player.isOnSmallLog()) {
                    player.moveLeftOnLog(player.getX() - customView.getWidth() / 30);
                }
                if (isRunning) {
                    handler.postDelayed(this, 300);
                }
            }
        }, 500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int change = customView.getWidth() / 40;
                log1.driveLeftSmallerLog(change);
                player.checkLogCollision(log1, log2);
                if (player.isOnSmallLog() && !player.isOnBigLog()) {
                    player.moveLeftOnLog(player.getX() - customView.getWidth() / 40);
                }
                if (isRunning) {
                    handler.postDelayed(this, 300);
                }
            }
        }, 500);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int change = customView.getWidth() / 20;
                car1.moveCar(change);
                player.checkCollision(car1, car2, car3);
                resetUI();
                if (isRunning) {
                    handler.postDelayed(this, 300);
                }
            }
        }, 500);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int change = customView.getWidth() / 20;
                car2.moveCar(change);
                player.checkCollision(car1, car2, car3);
                resetUI();
                if (isRunning) {
                    handler.postDelayed(this, 100);
                } else {
                    gameOver();
                }
            }
        }, 500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int change = customView.getWidth() / 20;
                car3.moveCar(change);
                player.checkCollision(car1, car2, car3);
                resetUI();
                if (isRunning) {
                    handler.postDelayed(this, 250);
                }
            }
        }, 500);
    }
    public void upHandler() {
        Player.setCurrYPosition(Player.getCurrYPosition() + 1);
        player.scoreUpdate(Player.getCurrYPosition());
        scoreTextBox.setText("Score: " + player.getScore());
        int change = customView.getHeight() / 20;
        player.moveUp(player.getY() - change);
    }
    public void downHandler() {
        Player.setCurrYPosition(Math.max(Player.getCurrYPosition() - 1, 0));
        int change = customView.getHeight() / 20;
        player.moveDown(player.getY() + change, customView.getHeight(),
                player.getPlayerSprite().getHeight());
    }



    public void leftHandler() {
        int change = customView.getWidth() / 10;
        if (!player.isOnLog()) {
            player.moveLeft(player.getX() - change);
        } else {
            player.moveLeftOnLog(player.getX() - change);
        }

    }

    public void rightHandler() {
        int change = customView.getWidth() / 10;
        player.moveRight(player.getX() + change, customView.getWidth(),
                player.getPlayerSprite().getWidth());
    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_W) {
            if (!isRunning) {
                gameOver();
            }
            upHandler();
            player.checkCollision(car1, car2, car3);
            resetUI();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_S) {
            if (!isRunning) {
                gameOver();
            }
            downHandler();
            player.checkCollision(car1, car2, car3);
            resetUI();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_A) {
            if (!isRunning) {
                gameOver();
            }
            leftHandler();
            player.checkCollision(car1, car2, car3);
            resetUI();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_D) {
            if (!isRunning) {
                gameOver();
            }
            rightHandler();
            player.checkCollision(car1, car2, car3);
            resetUI();
            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }


    private void resetUI() {
        scoreTextBox.setText("Score: " + player.getScore());
        livesTextBox.setText("Lives: " + player.getLives());
    }
    private void gameOver() {
        Intent intent = new Intent(GameScreen.this, GameOver.class);
        int score = Player.getHighestScore();
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    public static boolean isIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean isRunning) {
        GameScreen.isRunning = isRunning;
    }
}