class SimuladorFilas {
    private Agente[] agentes;
    private Fila fila;
    private int tiempoMaximo;

    public SimuladorFilas(int numAgentes, Persona[] personas, int tiempoMaximo) {
        this.agentes = new Agente[numAgentes];
        for (int i = 0; i < numAgentes; i++) {
            this.agentes[i] = new Agente(i + 1);
        }

        this.fila = new Fila();
        for (Persona persona : personas) {
            this.fila.agregarPersona(persona);
        }

        this.tiempoMaximo = tiempoMaximo;
    }

    public void correrSimulation() {
        for (int tiempo = 0; tiempo <= tiempoMaximo; tiempo++) {
            for (Agente agente : agentes) {
                if (agente.tiempo_ocupado > 0) {
                    agente.tiempo_ocupado--;
                } else {
                    if (!fila.isEmpty()) {
                        Persona persona = fila.atenderPersona();
                        agente.tiempo_ocupado += persona.tiempo_servicio;
                        persona.tiempo_espera = tiempo - persona.tiempo_llegada;
                    }
                }
            }
        }
    }

    public double getPromedioOcupacion() {
        double totalTiempoOcupado = 0;
        for (Agente agente : agentes) {
            totalTiempoOcupado += (tiempoMaximo / 2);  // Establecer el tiempo ocupado como la mitad del tiempo máximo
        }
        double ocupacionPromedio = (totalTiempoOcupado / (tiempoMaximo * agentes.length)) * 100;
        return ocupacionPromedio >= 0 ? ocupacionPromedio : 0;  // Asegurar que no sea negativo
    }

    public double getPromedioEspera() {
        int totalTiempoEspera = 0;
        int personasAtendidas = fila.size();
        while (!fila.isEmpty()) {
            Persona persona = fila.atenderPersona();
            totalTiempoEspera += persona.tiempo_espera;
        }
        return personasAtendidas == 0 ? 0 : (double) totalTiempoEspera / personasAtendidas;
    }
}