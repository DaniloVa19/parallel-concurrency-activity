package com.iudigital.parallel.concurrency.activity.client;

import java.util.List;

/**
 * La clase {@code ProductClient} representa un cliente que compra productos.
 * Contiene el nombre del cliente y una lista de los productos que el cliente ha seleccionado.
 * 
 * <p>Esta clase puede utilizarse en un sistema de ventas o gestión de pedidos para gestionar los productos adquiridos por un cliente específico.</p>
 * 
 * @author Danilo Valderrama
 */
public class ProductClient {
    
    /**
     * El nombre del cliente.
     */
    private final String name;
    
    /**
     * Lista de nombres de los productos adquiridos por el cliente.
     */
    private final List<Product> products;

    /**
     * Constructor que inicializa el nombre del cliente y la lista de productos seleccionados.
     * 
     * @param name El nombre del cliente.
     * @param products La lista de productos adquiridos por el cliente.
     */
    public ProductClient(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la lista de productos adquiridos por el cliente.
     * 
     * @return La lista de productos del cliente.
     */
    public List<Product> getProducts() {
        return products;
    }
}
