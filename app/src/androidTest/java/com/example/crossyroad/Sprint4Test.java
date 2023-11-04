package com.example.crossyroad;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Sprint4Test {
    @Rule
    public ActivityScenarioRule<GameScreen> activityScenarioRule = new ActivityScenarioRule<GameScreen>(GameScreen.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.crossyroad", appContext.getPackageName());

    }


    @Test
    public void checkWaterTileLoseLife() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            int oldLives = player.getLives();
            player.scoreUpdate(12);
            assertEquals(oldLives, player.getLives() + 1);
        });
    }

    @Test
    public void checkCollisionCar1() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c1.setX(player.getX());
            player.setY(1200);
            assertEquals(true, player.checkCollision(c1, c2, c3));
        });

    }

    @Test
    public void checkCollisionCar2() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c2.setX(player.getX());
            player.setY(950);
            assertEquals(true, player.checkCollision(c1, c2, c3));
        });
    }

    @Test
    public void checkCollisionCar3() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c3.setX(player.getX());
            player.setY(1400);
            assertEquals(true, player.checkCollision(c1, c2, c3));
        });
    }

    @Test
    public void checkCollisionCar1ResetsPlayerPos() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c1.setX(player.getX());
            player.setY(1200);
            assertEquals(370, (int)player.getX());
        });

    }
    @Test
    public void checkCollisionCar2ResetsPlayerPos() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c2.setX(player.getX());
            player.setY(950);
            assertEquals(370, (int) player.getX());
        });
    }
    @Test
    public void checkCollisionCar3ResetsPlayerPos() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c3.setX(player.getX());
            player.setY(950);
            assertEquals(370, (int) player.getX());
        });
    }

    @Test
    public void checkCollisionCar1DecreasesLives() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            int lives = player.getLives();
            c1.setX(player.getX());
            player.setY(1200);
            assertEquals(lives--, player.getLives());
        });

    }

    @Test
    public void checkCollisionCar2DecreasesLives() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            int lives = player.getLives();
            c2.setX(player.getX());
            player.setY(950);
            assertEquals(lives--, player.getLives());
        });
    }

    @Test
    public void checkCollisionCar3DecreasesLives() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            int lives = player.getLives();
            c3.setX(player.getX());
            player.setY(1400);
            assertEquals(lives--, player.getLives());
        });
    }


    public void checkCollisionCar1ResetsScore() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c1.setX(player.getX());
            player.setY(1200);
            assertEquals(0, player.getScore());
        });

    }

    @Test
    public void checkCollisionCar2ResetsScore() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c2.setX(player.getX());
            player.setY(950);
            assertEquals(0, player.getScore());
        });
    }

    @Test
    public void checkCollisionCar3ResetsScore() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView car1 = activity.findViewById(R.id.car1);
            ImageView car2 = activity.findViewById(R.id.car2);
            ImageView car3 = activity.findViewById(R.id.car3);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Car c1 = new Car(990, 1200, 62, 66, car1); //blue
            Car c2 = new Car(990, 950, 79, 64, car2); //orange
            Car c3 = new Car(990, 1400, 72, 89, car3); //red
            c3.setX(player.getX());
            player.setY(1400);
            assertEquals(0, player.getScore());
        });
    }



}