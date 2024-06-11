

import org.junit.jupiter.api.Test;

import com.example.kalkulatorsuhu.KalkulatorSuhu;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testGetKelvinFromCelcius() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    void testGetKelvinFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    void testGetKelvinFromFahrenheit() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(32, "Fahrenheit");
        assertEquals(273, kalkulator.getKelvin());
    }

    @Test
    void testGetCelciusFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(0, kalkulator.getCelcius());
    }

    @Test
    void testGetCelciusFromFahrenheit() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(32, "Fahrenheit");
        assertEquals(0, kalkulator.getCelcius());
    }

    @Test
    void testGetFahrenheitFromCelcius() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        assertEquals(32, kalkulator.getFahrenheit());
    }

    @Test
    void testGetFahrenheitFromKelvin() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(273, "Kelvin");
        assertEquals(32, kalkulator.getFahrenheit());
    }

    @Test
    void testChangeSuhu() {
        KalkulatorSuhu kalkulator = new KalkulatorSuhu(0, "Celcius");
        kalkulator.changeSuhu(100, "Fahrenheit");
        assertEquals(100, kalkulator.suhu);
        assertEquals("Fahrenheit", kalkulator.jenis_satuan_awal);
    }
}
