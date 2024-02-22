class Persona {
    int id;
    int tiempo_llegada;
    int tiempo_servicio;
    int tiempo_espera;

    public Persona(int id, int tiempo_llegada, int tiempo_servicio) {
        this.id = id;
        this.tiempo_llegada = tiempo_llegada;
        this.tiempo_servicio = tiempo_servicio;
        this.tiempo_espera = 0;
    }

    @Override
    public String toString() {
        return "Persona{id=" + id + ", tiempo_llegada=" + tiempo_llegada +
                ", tiempo_servicio=" + tiempo_servicio + ", tiempo_espera=" + tiempo_espera + '}';
    }
}
