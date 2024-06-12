/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.example.kalkulatorsuhu.KalkulatorSuhu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aryaa
 */
public class AppTest {
    
    public AppTest(){}

    @Test
    public void testGetKelvinFromCelcius() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    public void testGetKelvinFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    public void testGetKelvinFromFahrenheit() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(32, "Fahrenheit");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    public void testGetCelciusFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(0, kalkulator.getCelcius());
    }

    @Test
    public void testGetCelciusFromFahrenheit() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(32, "Fahrenheit");
        assertEquals(0, kalkulator.getCelcius());
    }

    @Test
    public void testGetFahrenheitFromCelcius() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        assertEquals(32, kalkulator.getFahrenheit());
    }

    @Test
    public void testGetFahrenheitFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(32, kalkulator.getFahrenheit());
    }

    @Test
    public void testChangeSuhu() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        kalkulator.changeSuhu(100, "Fahrenheit");
        assertEquals(100, kalkulator.suhu);
        assertEquals("Fahrenheit", kalkulator.jenis_satuan_awal);
    }
}
