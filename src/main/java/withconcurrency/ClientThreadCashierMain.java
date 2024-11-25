package withconcurrency;

import com.iudigital.parallel.concurrency.activity.client.Product;
import com.iudigital.parallel.concurrency.activity.client.ProductClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que simula un proceso de compra de productos en una tienda
 * utilizando concurrencia. Crea dos clientes y asigna productos a cada uno. 
 * Utiliza dos hilos (representados por instancias de la clase `ProductThreadCashier`)
 * para simular el procesamiento paralelo de las compras.
 * 
 * @author Danilo Valderrama
 */
public class ClientThreadCashierMain {

    /**
     * Método principal que ejecuta el proceso de compra para dos clientes, 
     * utilizando dos hilos para simular el procesamiento concurrente por parte 
     * de los cajeros.
     * 
     * Se crean dos clientes con productos asignados y se inician los hilos 
     * correspondientes para procesar sus compras.
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

        // Crear dos cajeros (hilos) para procesar las compras de los clientes
        ProductThreadCashier cashierOne = new ProductThreadCashier("Maria", clientOne, initialTime);
        ProductThreadCashier cashierTwo = new ProductThreadCashier("Martha", clientTwo, initialTime);

        // Iniciar los hilos de los cajeros
        cashierOne.start();
        cashierTwo.start();
    }

    /**
     * Método para agregar productos predefinidos a la lista de productos.
     * 
     * Este método agrega productos como manzanas, arroz, carne, pescado y aceite
     * a la lista de productos, con precios y cantidades definidos.
     * 
     */
    private static void setProducts(List<Product> products) {
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
