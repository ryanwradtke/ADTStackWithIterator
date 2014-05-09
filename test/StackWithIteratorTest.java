/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan W Radtke <RyanWRadtke@gmail.com>
 */
public class StackWithIteratorTest {

    public StackWithIteratorTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void StackWithIteratorTest() {
        StackIteratorOuter test = new StackIteratorOuter();
        Integer test1 = 123;

        while (test1 < 134) {
            test1 += 1;
            test.push(test1);
        }

        assert (!test.isEmpty());

        assertEquals(test1, test.peek());

        while (!test.isEmpty()) {
            assertEquals(test1, test.pop());
            test1 -= 1;
        }
        assert (test.isEmpty());

        test.push(123);

        test.clear();

        assert (test.isEmpty());
    }
}
