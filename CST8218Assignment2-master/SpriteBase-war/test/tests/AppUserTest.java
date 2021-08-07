/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import cst8218.base0001.entity.AppUser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zach
 */
public class AppUserTest {
    
    public AppUserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void appUserConstructorTest() {
    AppUser testUser = new AppUser();
    
    assertNotNull(testUser);
    
    //Test id generation
    assertNotNull(testUser.getId());
    
    //Make sure no password is returned
    assertEquals(testUser.getPassword(), "");
    
    
    }
    
    @Test
    public void appUserGetterTest()
    {
        //Create the test user and set the parameters to test
        AppUser testUser = new AppUser();
        testUser.setgroupName("test");
        testUser.setuserid("testUser");
        
        //Use getters to test the parameters
        assertEquals(testUser.getgroupName(), "test");
        assertEquals(testUser.getuserid(), "testUser");
    }
}
