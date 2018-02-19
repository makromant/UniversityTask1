package polyclass;

import org.junit.Test;
import polynomial.Poly;

import static org.junit.Assert.*;

public class PolyTest {

    @Test   // does not work without hashСode()
    public void testSum() {
        Poly obj = new Poly(new int[]{1, 1, 1});
        assertEquals(new Poly(new int[]{2, 2, 2}).hashCode(), obj.sum(new Poly(new int[]{1, 1, 1})).hashCode());
        assertEquals(new Poly(new int[]{3, 2, 3}).hashCode(), obj.sum(new Poly(new int[]{2, 1, 2})).hashCode());
        assertEquals(new Poly(new int[]{3, 3, 3}).hashCode(), obj.sum(new Poly(new int[]{2, 2, 2})).hashCode());
        assertEquals(new Poly(new int[]{4, 4, 4}).hashCode(), obj.sum(new Poly(new int[]{3, 3, 3})).hashCode());
        assertEquals(new Poly(new int[]{1, 1, 1}).hashCode(), obj.sum(new Poly(new int[]{})).hashCode());
    }

    @Test
    public void testValue() {
        assertEquals(new Poly(new int[]{1, 1, 1}).value(1), 3);
        assertEquals(new Poly(new int[]{1, 0, 1}).value(1), 2);
        assertEquals(new Poly(new int[]{1, 2, 3}).value(2), 17);
        assertEquals(new Poly(new int[]{1, 0, 3, 1}).value(5), 201);
    }

    @Test   // does not work without hashСode()
    public void testMultiplication() {
        Poly obj = new Poly(new int[]{1, 1, 1});
        assertEquals(obj.multiplication(new Poly(new int[]{1, 4, 2})).hashCode(), new Poly(new int[]{1, 5, 7, 6, 2}).hashCode());
        assertEquals(obj.multiplication(new Poly(new int[]{1, 1, 1})).hashCode(), new Poly(new int[]{1, 2, 3, 2, 1}).hashCode());
    }

    @Test   // does not work without hashСode()
    public void testSubtraction() {
        Poly obj = new Poly(new int[]{1, 1, 1});
        assertEquals(obj.subtraction(new Poly(new int[]{1, 1, 1})).hashCode(), new Poly(new int[]{}).hashCode());
        assertEquals(obj.subtraction(new Poly(new int[]{-1, 1, 1})).hashCode(), new Poly(new int[]{2}).hashCode());
        assertEquals(obj.subtraction(new Poly(new int[]{})).hashCode(), new Poly(new int[]{1, 1, 1}).hashCode());
        assertEquals(obj.subtraction(new Poly(new int[]{-1, -1, -1})).hashCode(), new Poly(new int[]{2, 2, 2}).hashCode());
    }

    @Test   // does not work without hashСode()
    public void testDivision() {
        assertEquals(new Poly(new int[]{1, 1, 1}).division(new Poly(new int[]{1, 1, 1})).hashCode(), new Poly(new int[]{1}).hashCode());
        assertEquals(new Poly(new int[]{1, 1, 1}).division(new Poly(new int[]{1, 1})).hashCode(), new Poly(new int[]{0, 1}).hashCode());
        assertEquals(new Poly(new int[]{1, 1, 1}).division(new Poly(new int[]{0, 1})).hashCode(), new Poly(new int[]{1, 1}).hashCode());
    }

    @Test   // does not work without hashСode()
    public void testRemainder() {
        assertEquals(new Poly(new int[]{1, 1, 1}).remainder(new Poly(new int[]{1, 1, 1})).hashCode(), new Poly(new int[]{}).hashCode());
        assertEquals(new Poly(new int[]{1, 1, 1}).remainder(new Poly(new int[]{1, 1})).hashCode(), new Poly(new int[]{1}).hashCode());
        assertEquals(new Poly(new int[]{1, 1, 1}).remainder(new Poly(new int[]{0, 1})).hashCode(), new Poly(new int[]{1}).hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(new Poly(new int[]{}).equals(new Poly(new int[]{})));
        assertFalse(new Poly(new int[]{}).equals(new Poly(new int[]{1})));
        assertTrue(new Poly(new int[]{0, 1, 0, 1}).equals(new Poly(new int[]{0, 1, 0, 1})));
        assertFalse(new Poly(new int[]{-1, -1, -1, -1}).equals(new Poly(new int[]{1, 1, 1, 1})));
        assertTrue(new Poly(new int[]{1, 1, 1, 1}).equals(new Poly(new int[]{1, 1, 1, 1})));
        assertTrue(new Poly(new int[]{-1, -1, -1, -1}).equals(new Poly(new int[]{-1, -1, -1, -1})));
    }
}
