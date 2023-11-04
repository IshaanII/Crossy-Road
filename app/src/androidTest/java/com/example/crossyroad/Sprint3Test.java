//package com.example.crossyroad;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.platform.app.InstrumentationRegistry;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//@RunWith(AndroidJUnit4.class)
//public class Sprint3Test {
//    @Rule
//    public ActivityScenarioRule<GameScreen> activityScenarioRule = new ActivityScenarioRule<GameScreen>(GameScreen.class);
//
//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.crossyroad", appContext.getPackageName());
//
//    }
//
//
//    @Test
//    public void car1WrapsAround() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car1);
//            //-172 should change X to 990
//            image.setX(GameScreen.decreaseCarX(-172));
//            //Log.d("test",  "" + GameScreen.decreaseCarX(-999));
//            assertEquals(990, (int)image.getX());
//        });
//    }
//    @Test
//    public void car2WrapsAround() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car2);
//            //-172 should change X to 990
//            image.setX(GameScreen.decreaseCarX(-172));
//            assertEquals(990, (int)image.getX());
//        });
//    }
//    @Test
//    public void car3WrapsAround() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car3);
//            //-172 should change X to 990
//            image.setX(GameScreen.decreaseCarX(-172));
//            assertEquals(990, (int)image.getX());
//        });
//    }
//    @Test
//    public void car1RespawnsSameLane() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car1);
//            float initLanePosition = image.getY();
//            image.setX(GameScreen.decreaseCarX(-172)); //force wraparound
//            float finalLanePosition = image.getY();
//            assertEquals((int)initLanePosition, (int)finalLanePosition);
//        });
//    }
//    @Test
//    public void car2RespawnsSameLane() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car2);
//            float initLanePosition = image.getY();
//            image.setX(GameScreen.decreaseCarX(-172)); //force wraparound
//            float finalLanePosition = image.getY();
//            assertEquals((int)initLanePosition, (int)finalLanePosition);
//        });
//    }
//    @Test
//    public void car3RespawnsSameLane() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView image = activity.findViewById(R.id.car3);
//            float initLanePosition = image.getY();
//            image.setX(GameScreen.decreaseCarX(-172)); //force wraparound
//            float finalLanePosition = image.getY();
//            assertEquals((int)initLanePosition, (int)finalLanePosition);
//        });
//    }
//    @Test
//    public void scoreIncrements() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            TextView scoreBox = activity.findViewById(R.id.score);
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            String score = (String)scoreBox.getText();
//            assertNotEquals('0', score.charAt(score.length() - 1));
//        });
//    }
//    @Test
//    public void moveLeftDoesNotIncrementScore() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            TextView scoreBox = activity.findViewById(R.id.score);
//            String scoreInit = (String)scoreBox.getText();
//            activity.leftHandler();
//            activity.leftHandler();
//            String scoreFinal = (String)scoreBox.getText();
//            assertEquals(scoreInit, scoreFinal);
//        });
//    }
//    @Test
//    public void moveRightDoesNotIncrementScore() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            TextView scoreBox = activity.findViewById(R.id.score);
//            String scoreInit = (String)scoreBox.getText();
//            activity.rightHandler();
//            activity.rightHandler();
//            String scoreFinal = (String)scoreBox.getText();
//            assertEquals(scoreInit, scoreFinal);
//        });
//    }
//    @Test
//    public void moveBackDoesNotIncrementScore() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            TextView scoreBox = activity.findViewById(R.id.score);
//            String scoreInit = (String)scoreBox.getText();
//            activity.downHandler();
//            activity.downHandler();
//            String scoreFinal = (String)scoreBox.getText();
//            assertEquals(scoreInit, scoreFinal);
//        });
//    }
//    @Test
//    public void crossingRoadTwiceDoesNotAddPointsTwice() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            TextView scoreBox = activity.findViewById(R.id.score);
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            activity.upHandler();
//            String scoreInit = (String)scoreBox.getText();
//            activity.downHandler();
//            activity.downHandler();
//            activity.downHandler();
//            activity.downHandler();
//            activity.downHandler();
//            activity.downHandler();
//            activity.downHandler();
//            String scoreFinal = (String)scoreBox.getText();
//            assertEquals(scoreInit, scoreFinal);
//        });
//    }
//    @Test
//    public void vehiclesAreDifferentSize() {
//        activityScenarioRule.getScenario().onActivity(activity -> {
//            ImageView car1 = activity.findViewById(R.id.car1);
//            ImageView car2 = activity.findViewById(R.id.car2);
//            ImageView car3 = activity.findViewById(R.id.car3);
//            int areaCar1 = car1.getWidth() * car1.getHeight();
//            int areaCar2 = car2.getWidth() * car2.getHeight();
//            int areaCar3 = car3.getWidth() * car3.getHeight();
//            assertNotEquals(areaCar1, areaCar2);
//            assertNotEquals(areaCar1, areaCar3);
//        });
//    }
//
//}