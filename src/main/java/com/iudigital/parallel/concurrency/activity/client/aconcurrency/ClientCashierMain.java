package com.iudigital.parallel.concurrency.activity.client.aconcurrency;

import com.iudigital.parallel.concurrency.activity.client.Product;
import com.iudigital.parallel.concurrency.activity.client.ProductClient;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que simula un proceso de compra en una tienda con múltiples cajeros
 * y clientes si utilizando concurrencia.
 * 
 * La clase crea varios productos, los asigna a clientes y luego simula el proceso
 * de compra a través de los cajeros.
 * 
 * @author Danilo Valderrama
 */
public class ClientCashierMain {
    
    /**
     * Método principal que ejecuta el proceso de compra para dos clientes, utilizando
     * dos cajeros y mostrando el tiempo de ejecución.
     * 
     */
    public static void main(String[] args) {
        
        // Crear una lista de productos
        List<Product> products = new ArrayList<>();
        
        // Asignar productos a la lista
        setProducts(products);
        
        // Crear dos clientes con los productos disponibles
        ProductClient clientOne = new ProductClient("Peter", products);
        ProductClient clientTwo = new ProductClient("Juan", products);
        
        // Registrar el tiempo inicial para medir el rendimiento
        long initialTime = System.currentTimeMillis();
        
        // Crear dos cajeros
        ProductCashier cashierOne = new ProductCashier("Maria");
        ProductCashier cashierTwo = new ProductCashier("Martha");
        
        // Simular el proceso de compra para ambos clientes con el primer cajero
        cashierOne.buyProcess(clientOne, initialTime);
        cashierTwo.buyProcess(clientTwo, initialTime);
    }
    
    /**
     * Método para agregar productos predefinidos a la lista de productos.
     * 
     */
    public static void setProducts(List<Product> products){
        // Crear productos con nombre, precio y cantidad
        Product productOne = new Product("apple", 250, 10);
        Product productTwo = new Product("rice", 350, 20);
        Product productThree = new Product("beef", 250, 10);
        Product productFour = new Product("fish", 550, 20);
        Product productFive = new Product("oil", 350, 4);
        
        // Agregar los productos a la lista
        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
        products.add(productFour);
        products.add(productFive);
    }
}
