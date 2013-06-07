package org.qsoft.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * User: haopt
 * Date: 6/4/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMathService {

    private MathService mathService;

    @Test
    public void testWithParamNull() throws Exception {
        assertEquals(0, mathService.methodAdd(null));
    }

    @Test
    public void testWithParamEmpty() throws Exception {
        assertEquals(0, mathService.methodAdd(""));
    }

    @Test
    public void testWithOneNumber() throws Exception {
        assertEquals(1, mathService.methodAdd("1"));
    }

    @Test
    public void testWithTwoNumber() throws Exception {
        assertEquals(3, mathService.methodAdd("1,2"));
    }

    @Test
    public void testWithSpecialNumber() throws Exception {
        assertEquals(3, mathService.methodAdd("1\n,2"));
    }

    @Test
    public void testWithMultilSpecialNumber() throws Exception {
        assertEquals(6, mathService.methodAdd("!~#3$;+=_&*%^&*(),_+|?/>.<,1\n,2:;\"'"));
    }

    @Test
    public void testWithNegativesNumber() throws Exception {
        try {
            mathService.methodAdd("1,5,-5");
            fail("Exception ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            assertEquals(e.getMessage(),e.getMessage());
        }
    }

    @Test
    public void testWithNumberLarge() throws Exception {
        assertEquals(5, mathService.methodAdd("1000,2,3"));
    }

    @Test
    public void testWithDelimiterFull() throws Exception {
        assertEquals(6, mathService.methodAdd("//[***]\n1***2***3"));
    }
    @Test
    public void testWithMultilsDelimiterFull() throws Exception {
        assertEquals(6, mathService.methodAdd("//[***][abc3][ab#$%]\n1***2abc3***abc32ab#$%ab#$%1ab#$%"));
    }
}
