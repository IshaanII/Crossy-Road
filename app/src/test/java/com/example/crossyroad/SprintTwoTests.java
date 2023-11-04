package com.example.crossyroad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SprintTwoTests {
    // Sohum
    @Test
    public void invalidNameSpace() {
        assertEquals(false, SelectScreen.nameChecker("   "));
    }

    // Sohum
    @Test
    public void validName() {
        assertEquals(true, SelectScreen.nameChecker("bob"));
    }

    //Ishaan
    @Test
    public void nullName() {
        assertEquals(false, SelectScreen.nameChecker(null));
    }

    //Ishaan
    @Test
    public void leftBoundCheck(){
        assertTrue(GameScreen.decreaseX(-100) == 0);
    }

    //Sai
    @Test
    public void rightBoundCheck(){
        assertTrue(GameScreen.increaseX(4000, 1400, 100) == 1300);
    }

    //Sai
    @Test
    public void upperBoundCheck(){
        assertTrue(GameScreen.decreaseY(-100) == 80);
    }

    //Karan
    @Test
    public void lowerBoundCheck(){
        assertTrue(GameScreen.increaseY(4000, 2000, 80) == 1920);
    }
    //Karan
    @Test
    public void moveLeft(){
        assertTrue(GameScreen.decreaseX(250 - 100) == 150);
    }

    //Robert
    @Test
    public void moveRight(){
        assertTrue(GameScreen.increaseX(250 + 200, 1400, 100) == 450);
    }

    //Robert
    @Test
    public void moveUp(){
        assertTrue(GameScreen.decreaseY(300 - 180) == 120);
    }

    //David
    @Test
    public void moveDown(){
        assertTrue(GameScreen.increaseY(670 + 120, 2000, 80) == 790);
    }

    //David
    @Test
    public void difficultyChecker() {
        assertFalse(SelectScreen.difficultyChecker(-1));
    }
}