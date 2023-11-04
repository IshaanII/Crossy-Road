package com.example.crossyroad;

import android.content.Context;
//import android.util.Log;
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
public class Sprint5Test {
    @Rule
    public ActivityScenarioRule<GameScreen> activityScenarioRule = new ActivityScenarioRule<GameScreen>(GameScreen.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.crossyroad", appContext.getPackageName());

    }


    @Test
    public void checkLog1NoLossLives() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(600);
            int oldLives = player.getLives();
            player.scoreUpdate(14);
            assertEquals(oldLives, player.getLives());
        });
    }

    @Test
    public void checkLog2NoLossLives() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l2.setX(player.getX());
            player.setY(325);
            int oldLives = player.getLives();
            player.scoreUpdate(12);
            assertEquals(oldLives, player.getLives());
        });

    }

    @Test
    public void checkHighestScoreGoalTile() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            player.setY(100);
            player.scoreUpdate(16);
            assertEquals(15, player.getScore());
        });

    }

    @Test
    public void checkLog1NoResetPositionPlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(600);
            int y = (int) player.getY();
            player.scoreUpdate(14);
            assertEquals(600, y);
        });
    }

    @Test
    public void checkLog2NoResetPositionPlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(325);
            int y = (int) player.getY();
            player.scoreUpdate(12);
            assertEquals(325, y);
        });
    }

    @Test
    public void checkLog1NoResetScorePlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(600);
            player.scoreUpdate(14);
            assertEquals(6, player.getScore());
        });
    }

    @Test
    public void checkLog2NoResetScorePlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(325);
            player.scoreUpdate(12);
            assertEquals(6, player.getScore());
        });
    }

    @Test
    public void checkLog1ResetPosition() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(-595);
            l1.driveLeftSmallerLog(30);
            assertEquals(800, (int) l1.getX());
        });
    }

    @Test
    public void checkLog2ResetPosition() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l2.setX(-784);
            l2.driveLeftBiggerLog(30);
            assertEquals(990, (int) l2.getX());
        });
    }

    @Test
    public void checkCollisionLog1AndPlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.setX(player.getX());
            player.setY(600);
            player.setCurrYPosition(14);
            assertEquals(true, player.checkLogCollision(l1, l2));
        });

    }

    @Test
    public void checkCollisionLog2AndPlayer() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView playerSprite = activity.findViewById(R.id.playerSprite);
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Player player = new Player("username", 0, 0, 5, 60, 55, playerSprite);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l2.setX(player.getX());
            player.setY(325);
            player.setCurrYPosition(12);
            assertEquals(true, player.checkLogCollision(l1, l2));
        });

    }

    @Test
    public void checkLog1MovesSlowerThanLog2() {
        activityScenarioRule.getScenario().onActivity(activity -> {
            ImageView log1 = activity.findViewById(R.id.log2);
            ImageView log2 = activity.findViewById(R.id.log1);
            Log l1 = new Log(525, 600, log1);
            Log l2 = new Log(375, 325, log2);
            l1.driveLeftSmallerLog(30);
            l2.driveLeftBiggerLog(46);
            assertEquals(true, l1.driveLeftSmallerLog(30) - l2.driveLeftBiggerLog(46) != 0);
        });

    }



}