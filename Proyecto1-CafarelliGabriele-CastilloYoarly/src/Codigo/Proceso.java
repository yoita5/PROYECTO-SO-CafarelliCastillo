/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author yoita5
 */
public class Proceso {
    private String nombre; // Nombre del proceso
    private int cantidadInstrucciones; // Total de instrucciones a ejecutar
    private String tipo; // Tipo de proceso: "CPU bound" o "I/O bound"
    private int ciclosParaGenerarExcepcion; // Ciclos para generar una excepción (solo para I/O bound)
    private int ciclosParaSatisfacerExcepcion; // Ciclos para satisfacer una excepción (solo para I/O bound)
    private int ciclosRestantesBloqueado; // Ciclos restantes para desbloquear un proceso I/O bound
    private int ciclosEjecutadosDesdeUltimoBloqueo; // Ciclos ejecutados desde el último bloqueo
    private int id; // Identificador único del proceso
    private String estado; // Estado del proceso (por defecto "Listo")
    private int PC; // Program Counter, por defecto 0
    private int MAR; // Memory Address Register, por defecto 0
    private int cpuIdThread; // Identificador del hilo de CPU que está manejando el proceso
    private int cicloEnqueCola; // Ciclo de encolado para la política HRRN
    private int instruccionesEjecutadas; // Contador de instrucciones ejecutadas (para SRT)
    private boolean tomado = false; // Indica si el proceso ha sido tomado por un CPU

    // Contador de ID único para cada proceso
    private static int contadorID = 1;

    // Constructor del proceso
    public Proceso(String nombre, int cantidadInstrucciones, String tipo,
                   Integer ciclosParaGenerarExcepcion, Integer ciclosParaSatisfacerExcepcion) {
        // Validaciones de los parámetros de entrada
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }

        if (cantidadInstrucciones <= 0) {
            throw new IllegalArgumentException("La cantidad de instrucciones debe ser mayor que 0.");
        }

        if (tipo == null || (!tipo.equals("CPU bound") && !tipo.equals("I/O bound"))) {
            throw new IllegalArgumentException("El tipo debe ser 'CPU bound' o 'I/O bound'.");
        }

        this.nombre = nombre;
        this.cantidadInstrucciones = cantidadInstrucciones;
        this.tipo = tipo;

        // Si el tipo es I/O bound, los parámetros de excepciones son obligatorios
        if (tipo.equals("I/O bound")) {
            if (ciclosParaGenerarExcepcion == null || ciclosParaSatisfacerExcepcion == null) {
                throw new IllegalArgumentException("Ciclos para generar y satisfacer excepción son obligatorios para procesos I/O bound.");
            }
            this.ciclosParaGenerarExcepcion = ciclosParaGenerarExcepcion;
            this.ciclosParaSatisfacerExcepcion = ciclosParaSatisfacerExcepcion;
        } else {
            // Si no es I/O bound, los valores son por defecto
            this.ciclosParaGenerarExcepcion = 0;
            this.ciclosParaSatisfacerExcepcion = 0;
        }
        // Inicialización de otros atributos
        this.ciclosRestantesBloqueado = 0;
        this.ciclosEjecutadosDesdeUltimoBloqueo = 0;
        this.id = contadorID++; // Asignar un ID único
        this.estado = "Listo"; // Estado inicial
        this.PC = 0; // Valor inicial por defecto
        this.MAR = 0; // Valor inicial por defecto
        this.cpuIdThread = 0; // Inicialización del hilo de CPU
        this.cicloEnqueCola = -1; // Inicialización del ciclo en cola
        this.instruccionesEjecutadas = 0; // Inicialización de instrucciones ejecutadas
    }

    // Métodos Getters y Setters para acceder y modificar atributos

    public int getCicloEnqueCola() {
        return cicloEnqueCola;
    }

    public void setCicloEnqueCola(int cicloEnqueCola) {
        this.cicloEnqueCola = cicloEnqueCola;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadInstrucciones() {
        return cantidadInstrucciones;
    }
    
    public void setCantidadInstrucciones(int cantidadInstrucciones) {
        this.cantidadInstrucciones = cantidadInstrucciones;
    }

    public String getTipo() {
        return tipo;
    }
    
    public int getCiclosRestantesBloqueado() {
        return ciclosRestantesBloqueado;
    }
    
    public void setCiclosRestantesBloqueado(int ciclosRestantesBloqueado) {
        this.ciclosRestantesBloqueado = ciclosRestantesBloqueado;
    }
    
    public int getCiclosEjecutadosDesdeUltimoBloqueo() {
        return ciclosEjecutadosDesdeUltimoBloqueo;
    }

    public void setCiclosEjecutadosDesdeUltimoBloqueo(int ciclosEjecutadosDesdeUltimoBloqueo) {
        this.ciclosEjecutadosDesdeUltimoBloqueo = ciclosEjecutadosDesdeUltimoBloqueo;
    }
    
    public void incrementarCiclosEjecutados() {
        this.ciclosEjecutadosDesdeUltimoBloqueo++;
    }

    public int getCiclosParaGenerarExcepcion() {
        return ciclosParaGenerarExcepcion;
    }

    public int getCiclosParaSatisfacerExcepcion() {
        return ciclosParaSatisfacerExcepcion;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int ID) {
        this.id = ID;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getMAR() {
        return MAR;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }
    
    public int getcpuIdThread() {
        return cpuIdThread;
    }
    
    public int getInstruccionesEjecutadas() {
        return instruccionesEjecutadas;
    }

    public void setInstruccionesEjecutadas(int instruccionesEjecutadas) {
        this.instruccionesEjecutadas = instruccionesEjecutadas;
    }

    // Calcula el tiempo restante para la política SRT
    public int getTiempoRestante() {
        return cantidadInstrucciones - instruccionesEjecutadas;
    }

    public void setcpuIdThread(int cpuIdThread) {
        this.cpuIdThread = cpuIdThread;
    }
    
    public boolean isTomado() {
        return tomado;
    }

    public void setTomado(boolean tomado) {
        this.tomado = tomado;
    }

    // Método toString() para imprimir la información del proceso
    @Override
    public String toString() {
        return "Proceso{" +
                "nombre='" + nombre + '\'' +
                ", cantidadInstrucciones=" + cantidadInstrucciones +
                ", tipo='" + tipo + '\'' +
                ", ciclosParaGenerarExcepcion=" + ciclosParaGenerarExcepcion +
                ", ciclosParaSatisfacerExcepcion=" + ciclosParaSatisfacerExcepcion +
                ", id=" + id +
                ", estado='" + estado + '\'' +
                ", PC=" + PC +
                ", MAR=" + MAR +
                ", Ciclo=" + cicloEnqueCola +
                ", InstruccionesEjecutadas=" + instruccionesEjecutadas +
                '}';
    }
}