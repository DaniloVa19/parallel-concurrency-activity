package com.iudigital.parallel.concurrency.activity.client;

/**
 * La clase {@code Product} representa un producto el supermercado.
 * Contiene atributos como el nombre del producto, su precio y la cantidad que lleva un cliente.
 * Esta clase proporciona métodos para obtener y modificar estos atributos.
 * 
 * 
 * @author Danilo Valderrama
 */
public class Product {
    
    /**
     * El nombre del producto.
     */
    private String name;
    
    /**
     * El precio del producto.
     */
    private float price;
    
    /**
     * La cantidad que el cliente compra.
     */
    private int count;

    /**
     * Constructor para crear un nuevo producto con el nombre, precio y cantidad a comprars.
     * 
     * @param name El nombre del producto.
     * @param price El precio del producto.
     * @param count La cantidad a comprar.
     */
    public Product(String name, float price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param name El nombre que se desea asignar al producto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param price El precio que se desea asignar al producto.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Obtiene la cantidad disponible de este producto.
     * 
     * @return La cantidad disponible del producto.
     */
    public int getCount() {
        return count;
    }

    /**
     * Establece la cantidad disponible de este producto.
     * 
     * @param count La cantidad que el cliente compra.
     */
    public void setCount(int count) {
        this.count = count;
    }
}
