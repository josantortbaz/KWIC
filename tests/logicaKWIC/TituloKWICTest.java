/*
 * Test unitarios de la clase TituloKWIC.
 */
package logicaKWIC;

import poo.TituloKWIC;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaort
 */
public class TituloKWICTest {
    
    public TituloKWICTest() {
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

    /**
     * Test of getTitulo method, of class TituloKWIC.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        TituloKWIC instance = new TituloKWIC();
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class TituloKWIC.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String titulo = "";
        TituloKWIC instance = new TituloKWIC();
        instance.setTitulo(titulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class TituloKWIC.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = null;
        TituloKWIC instance = new TituloKWIC();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TituloKWIC.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        TituloKWIC instance = new TituloKWIC();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TituloKWIC.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TituloKWIC instance = new TituloKWIC();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TituloKWIC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TituloKWIC instance = new TituloKWIC();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
