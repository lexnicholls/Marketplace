/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.marketplace.logic;

import edu.konrad.marketplace.entities.ProductoEntity;
import edu.konrad.marketplace.persistence.ProductoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB de producto
 * @author Steephen Alexander Nicholls
 */
@Stateless
public class ProductoLogic {
    
    @Inject
    private ProductoPersistence persistence;
    
    /**
     * Obtener todos los objetos Producto
     * @return
     */
    public List<ProductoEntity> obtenerProductos(){
        List<ProductoEntity> productos = persistence.findAll();
        return productos;
    }
    
    /**
     * Obtener todos los onjetos Producto
     * @return productoEntity
     */
    public ProductoEntity obtenerProducto(Long id){
        ProductoEntity producto = persistence.find(id);
        if(producto == null){
            throw new IllegalArgumentException("El producto solicitado no existe");
        }
        return producto;
    }
    
    /**
     * Metodo que conecta la transaccion para crear un objeto.
     * @param productoCrear
     * @return productoCrear
     */
    public ProductoEntity crearProducto(ProductoEntity productoCrear){
        persistence.create(productoCrear);
        return productoCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar
     * @param productoActualizar
     * @return productoUpdate
     */
    public ProductoEntity actualizarProducto (Long id, ProductoEntity productoActualizar){
        ProductoEntity productoUpdate = persistence.update(productoActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para eliminar un producto
     * @param productoActualizar
     * @return productoUpdate
     */
    public void eliminarProducto(Long id){
        persistence.remove(id);
    }
}
