public enum CategoriaPrenda {
    CAMISETA (0),
    PANTALON (0),
    VESTIDO (0.10),
    CHAQUETA (0.15),
    CALZADO (0.05);
    private double valor;
    CategoriaPrenda(double valor) {
        this.valor = valor;
    }
    public double getValor() {
        return valor;
    }
}
