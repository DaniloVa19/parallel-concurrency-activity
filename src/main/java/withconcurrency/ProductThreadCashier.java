package withconcurrency;

import com.iudigital.parallel.concurrency.activity.client.Product;
import com.iudigital.parallel.concurrency.activity.client.ProductClient;

/**
 * Representa un cajero que procesa los productos de un cliente en un hilo separado.
 * Este cajero simula un proceso de compra, donde cada producto del cliente es procesado 
 * uno a uno con un retraso de un segundo. Los tiempos de inicio y de procesamiento 
 * son registrados para medir la duración total de la compra.
 * 
 * Esta clase extiende `Thread` y sobrescribe el método `run()` para realizar el procesamiento
 * en un hilo independiente.
 * 
 * @author Danilo Valderrama
 */
public class ProductThreadCashier extends Thread {

    private String name;

    private ProductClient client;

    private long initialTime;

    /**
     * Constructor de la clase `ProductThreadCashier`.
     * 
     * Inicializa el cajero con su nombre, el cliente cuya compra será procesada, 
     * y el tiempo de inicio para medir el tiempo transcurrido durante el proceso.
     * 
     * @param name el nombre del cajero
     * @param client el cliente cuya compra será procesada
     * @param initialTime el tiempo de inicio desde el que se calcula el tiempo transcurrido
     */
    public ProductThreadCashier(String name, ProductClient client, long initialTime) {
        this.name = name;
        this.client = client;
        this.initialTime = initialTime;
    }

    /**
     * Sobrescribe el método `run()` de la clase `Thread`.
     * 
     * Este método simula el procesamiento de la compra de un cliente. Para cada producto,
     * el cajero simula un retraso de un segundo y luego imprime información detallada sobre
     * el producto y su costo total, junto con el tiempo transcurrido en cada paso.
     * 
     * Finalmente, al procesar todos los productos del cliente, el cajero imprime el tiempo 
     * total transcurrido para completar la compra.
     */
    public void run() {
        System.out.println("La cajera " + this.name + " comienza a procesar la compra del cliente "
                + client.getName() + " en el tiempo: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + " segundos");

        int contClient = 1;

        // Procesar cada producto de la lista del cliente
        for (Product product : client.getProducts()) {
            this.waitXseconds();

            // Imprimir detalles del producto procesado
            System.out.println("Procesado el producto " + contClient+" del cliente: "+client.getName()
                    + "; nombre producto: " + product.getName()
                    + "; precio del producto: " + product.getPrice()
                    + "; cantidad de productos: " + product.getCount()
                    + "; Costo total del producto: " + product.getCount() * product.getPrice()
                    + " -> Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
            contClient++;
        }
     
        // Imprimir el tiempo total transcurrido después de procesar todos los productos
        System.out.println("La cajera " + this.name + " ha terminado de procesar el pedido del cliente "
                + client.getName() + " en el tiempo: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    /**
     * Simula un retraso de 1 segundo, representando el tiempo que toma procesar 
     * cada producto.
     * 
     * Este método es utilizado dentro de `run()` para simular el tiempo que toma
     * procesar cada producto de la compra.
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
