package co.edu.uniquindio.poo;

// Clase que representa las tarifas por hora para diferentes tipos de vehículos
public class TarifaHora {

    // Atributos que almacenan las tarifas por hora para diferentes tipos de vehículos
    private double clasica;
    private double hibrida;
    private double carro;

    /**
     * Constructor para inicializar las tarifas por hora
     *
     * @param clasica Tarifa por hora para motos clásicas
     * @param hibrida Tarifa por hora para motos híbridas
     * @param carro   Tarifa por hora para carros
     */
    public TarifaHora(double clasica, double hibrida, double carro) {
        this.clasica = clasica;
        this.hibrida = hibrida;
        this.carro = carro;
    }

    /**
     * Obtiene la tarifa por hora para motos clásicas
     *
     * @return La tarifa por hora para motos clásicas
     */
    public double getClasica() {
        return clasica;
    }

    /**
     * Obtiene la tarifa por hora para motos híbridas
     *
     * @return La tarifa por hora para motos híbridas
     */
    public double getHibrida() {
        return hibrida;
    }

    /**
     * Obtiene la tarifa por hora para carros
     *
     * @return La tarifa por hora para carros
     */
    public double getCarro() {
        return carro;
    }

    /**
     * Establece la tarifa por hora para motos clásicas
     *
     * @param clasica La nueva tarifa por hora para motos clásicas
     */
    public void setClasica(double clasica) {
        this.clasica = clasica;
    }

    /**
     * Establece la tarifa por hora para motos híbridas
     *
     * @param hibrida La nueva tarifa por hora para motos híbridas
     */
    public void setHibrida(double hibrida) {
        this.hibrida = hibrida;
    }

    /**
     * Establece la tarifa por hora para carros
     *
     * @param carro La nueva tarifa por hora para carros
     */
    public void setCarro(double carro) {
        this.carro = carro;
    }
}
