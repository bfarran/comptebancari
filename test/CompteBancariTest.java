import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompteBancariTest {

    @Test
    void testCreacioCorrecta() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        assertEquals("Anna", compte.getTitular());
        assertEquals("ES12345", compte.getIban());
        assertEquals(500, compte.getSaldo());
    }

    @Test
    void testTitularNullLlancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> new CompteBancari(null, "ES12345", 500));
    }

    @Test
    void testTitularBuitLlancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> new CompteBancari("", "ES12345", 500));
    }

    @Test
    void testIbanNullLlancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> new CompteBancari("Anna", null, 500));
    }

    @Test
    void testSaldoNegatiuLlancaExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> new CompteBancari("Anna", "ES12345", -100));
    }

    @Test
    void testIngressarAumentaSaldo() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        compte.ingressar(200);
        assertEquals(700, compte.getSaldo());
    }

    @Test
    void testIngressarQuantitatNegativaLlancaExcepcio() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        assertThrows(IllegalArgumentException.class, () -> compte.ingressar(-100));
    }

    @Test
    void testRetirarDisminueixSaldo() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        compte.retirar(200);
        assertEquals(300, compte.getSaldo());
    }

    @Test
    void testRetirarMesDelSaldoLlancaExcepcio() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(1000));
    }

    @Test
    void testRetirarQuantitatNegativaLlancaExcepcio() {
        CompteBancari compte = new CompteBancari("Anna", "ES12345", 500);
        assertThrows(IllegalArgumentException.class, () -> compte.retirar(-50));
    }
}