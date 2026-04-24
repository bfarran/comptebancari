public class CompteBancari {

    private static final double LLINDAR_SALDO_BAIX = 1000;
    private static final double LLINDAR_SALDO_NORMAL = 5000;

    private String titular;
    private String iban;
    private double saldo;

    public CompteBancari(String titular, String iban, double saldoInicial) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular no pot ser buit");
        }
        if (iban == null || iban.isBlank()) {
            throw new IllegalArgumentException("L'IBAN no pot ser buit");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException(
                    "El saldo inicial no pot ser negatiu");
        }
        this.titular = titular;
        this.iban = iban;
        this.saldo = saldoInicial;
    }

    public void ingressar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException(
                    "La quantitat a ingressar ha de ser positiva");
        }
        saldo += quantitat;
    }

    public void retirar(double quantitat) {
        if (quantitat <= 0) {
            throw new IllegalArgumentException(
                    "La quantitat a retirar ha de ser positiva");
        }
        if (quantitat > saldo) {
            throw new IllegalArgumentException(
                    "Saldo insuficient per retirar " + quantitat);
        }
        saldo -= quantitat;
    }

    public void mostrarDades() {
        System.out.println("Titular: " + titular);
        System.out.println("IBAN: " + iban);
        System.out.println("Saldo: " + saldo);
        System.out.println(obtenirEstatSaldo());
    }

    // Mètode extret per eliminar el codi duplicat
    private String obtenirEstatSaldo() {
        if (saldo < LLINDAR_SALDO_BAIX) {
            return "Saldo baix";
        }
        if (saldo < LLINDAR_SALDO_NORMAL) {
            return "Saldo normal";
        }
        return "Saldo alt";
    }

    public String getTitular() {
        return titular;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
}