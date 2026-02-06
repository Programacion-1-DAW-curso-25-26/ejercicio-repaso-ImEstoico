import java.util.*;

public class Inventario {

    private ArrayList<ProductoInformatico> productos = new ArrayList<>();


    public void listarTodos() {
        for (ProductoInformatico prod : productos){
            System.out.println(productos);


        }
    }

    public void listarSinStock() {

        for (ProductoInformatico prod : productos) {
            if (prod.getStock() == 0) {
                System.out.println(productos);
            }
        }
    }

    public boolean agregarProducto(ProductoInformatico p) {
        if (!productos.contains(p)){
            productos.add(p);
            return true;
        }
        return false;
    }

    public List<ProductoInformatico> buscarPorNombre(String nombre) {
        ArrayList<ProductoInformatico> productosEncontrados = new ArrayList<>();
                for(ProductoInformatico producto : productos){
                    if(producto.getNombre().equals(nombre)) {
                        productosEncontrados.add(producto);
                    }
                }

        return productosEncontrados;
    }

    public List<ProductoInformatico> buscarPorCategoria(String cat) {
        ArrayList<ProductoInformatico> productosEncontrados = new ArrayList<>();
        for(ProductoInformatico producto : productos){
            if(producto.getCategoria().equals(cat)) {
                productosEncontrados.add(producto);
            }
        }

        return productosEncontrados;
    }

    public List<ProductoInformatico> buscarPorPrecio(double min, double max) {
        ArrayList<ProductoInformatico> productosEncontrados = new ArrayList<>();
        for(ProductoInformatico producto : productos){
            if((producto.getPrecio()<= max) && (producto.getPrecio()>= min) ){
                productosEncontrados.add(producto);
            }
        }

        return productosEncontrados;
    }

    public boolean incrementarStock(String cod, int c) {
        boolean encontrado = false;

        for (ProductoInformatico pro: productos)
            if (pro.getCodigo().equals(cod)) {
                pro.setStock(pro.getStock()+c);
                encontrado = true;
            }

        return encontrado;
    }

    public boolean decrementarStock(String cod, int c) {
        boolean encontrado = false;

        for (ProductoInformatico pro: productos)
            if (pro.getCodigo().equals(cod)) {
               if(pro.getStock()-c >= 0){
                   pro.setStock(pro.getStock() -c);
                   encontrado = true;
               }else{
                   System.out.println("stock insuficiente CANCELANDO OPERACION");
            }
    }
        return encontrado;

    }
    public List<ProductoInformatico> ordenarPorPrecioAsc() {
        ArrayList<ProductoInformatico> Ordenadeishon = new ArrayList<>(productos);
        Collections.sort(Ordenadeishon, Comparator.comparingDouble(ProductoInformatico::getPrecio));

        return Ordenadeishon;
    }
}













