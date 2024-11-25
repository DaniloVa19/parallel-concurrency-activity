package com.iudigital.parallel.concurrency.activity.client.aconcurrency;

import com.iudigital.parallel.concurrency.activity.client.ProductClient;
import com.iudigital.parallel.concurrency.activity.client.Product;

/**
 * Representa un cajero de productos en un proceso de compra. Esta clase simula
 * el proceso de compra de un cliente, donde el cajero procesa cada producto
 * de la lista del cliente, mostrando información sobre cada producto y el tiempo
 * que tarda en procesarlo.
 * 
 * El cajero simula un retraso de un segundo por producto, representado por
 * el método `waitXseconds()`.
 * 
 * @author Danilo Valderrama
 */
public class ProductCashier {

    private String name;

    /**
     * Constructor de la clase ProductCashier.
     * 
     * Inicializa un nuevo cajero con el nombre proporcionado.
     * 
     * @param name el nombre del cajero
     */
    public ProductCashier(String name) {
        this.name = name;
    }
    
    /**
     * Simula el proceso de compra de un cliente. Para cada producto en la lista
     * de productos del cliente, el cajero procesa el producto con un retraso de
     * un segundo, mostrando información sobre el producto y el costo total.
     * 
     * El tiempo de inicio se utiliza para calcular el tiempo transcurrido en
     * segundos durante todo el proceso de compra.
     * 
     * @param client el cliente cuya compra está siendo procesada
     * @param timeStamp el tiempo de inicio desde el que se calcula el tiempo transcurrido
     */
    public void buyProcess(ProductClient client, long timeStamp){
        System.out.println("La cajera " + this.name + " comienza a procesar la compra del cliente: "
        + client.getName() + " en el tiempo: "
        + (System.currentTimeMillis() - timeStamp)/1000
        + " segundos");
        
        int contClient = 1;
        
        // Procesar cada producto de la lista del cliente
        for (Product product : client.getProducts()) {
            // Simula el retraso de 1 segundo por cada producto procesado
            this.waitXseconds();
            
            // Imprime información detallada sobre el producto procesado
            System.out.println("Procesado el producto: "+ contClient +" del cliente: "+client.getName()
            +"; nombre producto: "+ product.getName()
            +"; precio del producto: "+ product.getPrice()
            +"; cantidad de productos: "+ product.getCount()
            +"; Costo total del producto: "+ product.getCount() * product.getPrice()
            +" ->Tiempo: " +(System.currentTimeMillis()-timeStamp)/1000 + "seg");
            
            contClient++;
        }
    
        // Imprime el tiempo total transcurrido al finalizar el proceso de compra
        System.out.println("La cajera "+this.name+ " ha terminado de procesar la compra del cliente"
                + client.getName()+ " en el tiempo: "
                + (System.currentTimeMillis()-timeStamp)/1000 + " seg");
    }

    /**
     * Simula un retraso de 1 segundo, representando el tiempo que toma procesar
     * un producto.
     * 
     * Este método es utilizado dentro de `buyProcess` para simular el procesamiento
     * de cada producto.
     */
    private void waitXseconds() {
        try {
            // Pausa el hilo actual por 1 segundo
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Maneja la interrupción del hilo si ocurre
            Thread.currentThread().interrupt();
        }
    }
}
