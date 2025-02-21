/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author yoita5
 */

/**
 * Clase genérica que implementa una Cola como estructura de datos.
 * @param <T> Tipo de dato que almacenará la cola.
 */
public class Cola<T> {
    private Nodo<T> frente; // Nodo al frente de la cola
    private Nodo<T> finalCola; // Nodo al final de la cola
    private int tamano; // Número de elementos en la cola

    // Constructor
    public Cola() {
        this.frente = null;
        this.finalCola = null;
        this.tamano = 0;
    }

    /**
     * Inserta un elemento al final de la cola.
     * @param elemento El elemento a insertar.
     */
    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Crear un nuevo nodo
        if (isEmpty()) {
            frente = nuevoNodo; // Si la cola está vacía, el nuevo nodo es el frente
        } else {
            finalCola.setSiguiente(nuevoNodo); // El último nodo apunta al nuevo nodo
        }
        finalCola = nuevoNodo; // Actualizamos el final de la cola
        tamano++;
       
    
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * @return El elemento eliminado.
     * @throws IllegalStateException Si la cola está vacía.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        T elemento = frente.getDato(); // Obtenemos el dato del nodo frente
        frente = frente.getSiguiente(); // Avanzamos el frente al siguiente nodo
        if (frente == null) {
            finalCola = null; // Si la cola queda vacía, final también es null
        }
        tamano--;
        return elemento;
    }

    /**
     * Devuelve el elemento al frente de la cola sin eliminarlo.
     * @return El elemento al frente.
     * @throws IllegalStateException Si la cola está vacía.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return frente.getDato();
    }
    
    
    public Nodo<T> peekNode() {
    return isEmpty() ? null : frente;
}

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía; false en caso contrario.
     */
    public boolean isEmpty() {
        return frente == null;
    }

    /**
     * Devuelve el número de elementos en la cola.
     * @return El tamaño de la cola.
     */
    public int size() {
        return tamano;
    }
//
    /**
     * Imprime los elementos de la cola desde el frente hasta el final.
     */
    public void imprimirCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo<T> actual = frente;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    /**
     * Vacía la cola eliminando todos los elementos.
     */
    public void vaciar() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    /**
     * Convierte la cola en un arreglo.
     * @return Un arreglo con los elementos de la cola en orden.
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Object[tamano];
        Nodo<T> actual = frente;
        int index = 0;
        while (actual != null) {
            array[index++] = actual.getDato();
            actual = actual.getSiguiente();
        }
        return array;
    }

    /**
     * Reconstruye la cola desde un arreglo, sobrescribiendo el contenido actual.
     * @param array Un arreglo con los elementos en el orden deseado.
     */
    public void reconstruirDesdeArray(T[] array) {
        vaciar(); // Vaciar la cola actual
        for (T elemento : array) {
            enqueue(elemento); // Reinsertar los elementos en el orden del arreglo
        }
    }
    
    //BUSCAR UN NODO QUE NO HAYA SIDO TOMADO 
    public Proceso buscarNoTomado() {
    Nodo<Proceso> actual = (Nodo<Proceso>) frente; // Comienza desde el frente de la cola
    while (actual != null) {
        if (!actual.getDato().isTomado()) {
            return actual.getDato(); // Retorna el proceso no tomado
        }
        actual = actual.getSiguiente(); // Avanza al siguiente nodo
    }
    return null; // No se encontró ningún proceso no tomado
}
    
    
    
    // BUSCAR EL FUCKING PROCESO EN TODA LA COLA PARA SACARLO.
    public void remove(Proceso proceso) {
    if (isEmpty()) {
        return; // La cola está vacía
    }

    // Si el proceso está en el frente
    if (((Proceso)frente.getDato()).getId() == proceso.getId()) {
        frente = frente.getSiguiente(); // Mover el frente al siguiente nodo
        if (frente == null) {
            finalCola = null; // Si la cola quedó vacía
        }
        tamano--;
        return;
    }

    // Buscar el proceso en toda la cola para sacarlo
    Nodo<Proceso> actual = (Nodo<Proceso>) frente;
    while (actual.getSiguiente() != null) {
        if (actual.getSiguiente().getDato().getId() == proceso.getId()) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            if (actual.getSiguiente() == null) {
                finalCola = (Nodo<T>) actual; // Actualizar el final de la cola
            }
            tamano--;
            return;
        }
        actual = actual.getSiguiente();
    }
}


    
}