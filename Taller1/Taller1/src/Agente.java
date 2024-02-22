class Agente {
    int id;
    int tiempo_ocupado;

    public Agente(int id) {
        this.id = id;
        this.tiempo_ocupado = 0;
    }

    @Override
    public String toString() {
        return "Agente{id=" + id + ", tiempo_ocupado=" + tiempo_ocupado + '}';
    }
}
