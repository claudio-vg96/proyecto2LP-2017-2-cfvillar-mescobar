package pocion;

public class Pocion {
    private int nivel;
    private int potencia;

    public void setNivel(int nivel) {

        this.nivel = nivel;
    }

    public void setPotencia() {

        potencia = nivel*5 + 20;
    }

    public int getPotencia() {
        return potencia;
    }
}
