/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import cst8218.base0001.entity.Sprite;
import java.awt.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zach
 */
public class SpriteTest {
    
    public SpriteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

     @Test
     public void testSpriteConstructors() {
         //Test Sprite constructors
        
         Sprite testSprite = new Sprite(500,500, Color.red);
         //Test constructo that accepts the width, height, and color
         assertNotNull(testSprite);
      
         //Test Default constructor
         Sprite test2Sprite = new Sprite();
         
         assertNotNull(test2Sprite);
         //Default color is BLUE
         assertNotEquals(test2Sprite.getColor(), Color.red);
         
         
         //Test constructor that accepts width and height
         Sprite test3Sprite = new Sprite(500,500);
         
        assertNotNull(test3Sprite);

        
     }
     
     @Test
     public void testSpriteGetters() {
         Sprite testSprite = new Sprite(500,500, Color.red);
         
         //Test all the getters in Sprite
         assertEquals(testSprite.getColor(), Color.red);
         assertEquals(500, testSprite.getPanelWidth());
         assertEquals(500, testSprite.getPanelHeight());
         assertNotNull(testSprite.getDx());
         assertNotNull(testSprite.getDy());
         assertNotNull(testSprite.getX());
         assertNotNull(testSprite.getY());
     }
     
      @Test
     public void testSpriteMove(){
         
         //Test the sprites move function
         Sprite testSprite = new Sprite(500,500);
         testSprite.setX(0);
         testSprite.setY(0);
         testSprite.setDx(5);
         testSprite.setDy(5);
         
         testSprite.move();
         
         assertEquals(testSprite.getX(),5);
         assertEquals(testSprite.getY(),5);
     }
}
