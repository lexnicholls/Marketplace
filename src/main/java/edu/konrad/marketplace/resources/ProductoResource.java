/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.marketplace.resources;

import edu.konrad.marketplace.dto.ProductoDTO;
import edu.konrad.marketplace.entities.ProductoEntity;
import edu.konrad.marketplace.logic.ProductoLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Recurso de producto
 * @author Alexander N.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/productos")
public class ProductoResource {
    
    @EJB
    private ProductoLogic productoLogic;
    
    /**
     * Metodo que retorna
     */
    
    @GET
    public List<ProductoDTO> getProductoList(){
        List<ProductoEntity> productos = productoLogic.obtenerProductos();
        return ProductoDTO.toProductoList(productos);
    }
    
    @GET
    @Path("{id: \\d+}")
    public ProductoDTO getProducto(@PathParam("id") Long id){
        ProductoEntity producto = productoLogic.obtenerProducto(id);
        if (producto == null){
            throw new RuntimeException("El producto no existe");
        }
        return new ProductoDTO(producto);
    }
    
    @POST
    public ProductoDTO createProducto(ProductoDTO productoDTO){
        return new ProductoDTO(productoLogic.crearProducto(productoDTO.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ProductoDTO updateProducto(@PathParam("id") Long id, ProductoDTO productoDTO){
        ProductoEntity productoEntity = productoLogic.obtenerProducto(id);
        if(productoEntity == null){
            throw new RuntimeException("El producto no existe.");
        }
        return new ProductoDTO(productoLogic.actualizarProducto(id, productoDTO.toEntity()));
    }
    
    @DELETE
    @Path("{productoId: \\d+}")
    public void deleteProducto(@PathParam("productoId") Long id){
        ProductoEntity productoEntity = productoLogic.obtenerProducto(id);
        if(productoEntity == null){
            throw new RuntimeException("El producto no existe.");
        }
        productoLogic.eliminarProducto(id);
    }
}
