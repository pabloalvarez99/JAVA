/**
 * Strategy Pattern: Normal driving mode
 * Efficiency is nominal (1.0x)
 */
public class ModoNormal implements ModoManejo {

    @Override
    public double calcularEficienciaAjustada(double eficienciaNominal) {
        return eficienciaNominal * 1.0;
    }

    @Override
    public String getNombre() {
        return "N";
    }
}
