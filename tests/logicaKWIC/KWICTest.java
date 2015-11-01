/*
 * Test unitarios de la clase logicaKWIC.KWIC
 */
package logicaKWIC;

import KWIC.KWIC;
import poo.TituloKWIC;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
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
public class KWICTest {
    
    public KWICTest() {
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
     * Test of getSEPARADORES_NS method, of class KWIC.
     */
    @Test
    public void testGetSEPARADORES_NS() {
        System.out.println("getSEPARADORES_NS");
        KWIC instance = new KWIC();
        String expResult = "";
        String result = instance.getSEPARADORES_NS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSEPARADORES_T method, of class KWIC.
     */
    @Test
    public void testGetSEPARADORES_T() {
        System.out.println("getSEPARADORES_T");
        KWIC instance = new KWIC();
        String expResult = "";
        String result = instance.getSEPARADORES_T();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoSignificativas method, of class KWIC.
     */
    @Test
    public void testGetNoSignificativas() {
        System.out.println("getNoSignificativas");
        KWIC instance = new KWIC();
        Set<TituloKWIC> expResult = null;
        Set<TituloKWIC> result = instance.getNoSignificativas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDiccionario method, of class KWIC.
     */
    @Test
    public void testGetDiccionario() {
        System.out.println("getDiccionario");
        KWIC instance = new KWIC();
        Map<TituloKWIC, Set<String>> expResult = null;
        Map<TituloKWIC, Set<String>> result = instance.getDiccionario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoSignificativas method, of class KWIC.
     */
    @Test
    public void testSetNoSignificativas() {
        System.out.println("setNoSignificativas");
        TreeSet<TituloKWIC> noSignificativas = null;
        KWIC instance = new KWIC();
        instance.setNoSignificativas(noSignificativas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDiccionario method, of class KWIC.
     */
    @Test
    public void testSetDiccionario() {
        System.out.println("setDiccionario");
        Map<TituloKWIC, Set<String>> diccionario = null;
        KWIC instance = new KWIC();
        instance.setDiccionario(diccionario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class KWIC.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        KWIC instance = new KWIC();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
