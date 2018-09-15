/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.marketplace.dto;

import edu.konrad.marketplace.entities.ProductoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada del mapeo objeto relacional de la entidad Producto
 *
 * @author Steephen Alexander Nicholls
 */
public class ProductoDTO {

    /**
     * Atributo que hace referencia a la id del producto
     */
    private Long id;

    /**
     * Atributo que hace referencia a la nombre del producto
     */
    private String nombreProducto;

    /**
     * Atributo que hace referencia al precio unitario del producto
     */
    private double precioUnitario;

    /**
     * Atributo que hace referencia a la marca del producto
     */
    private String marca;

    /**
     * Atributo que hace referencia al stock del objeto del producto
     */
    private int stock;

    public ProductoDTO() {
    }

    public ProductoDTO(ProductoEntity productoEntity) {
        this.id = productoEntity.getIdProducto();
        this.nombreProducto = productoEntity.getNombreProducto();
        this.precioUnitario = productoEntity.getPrecioUnitario();
        this.marca = productoEntity.getMarcaProducto();
        this.stock = productoEntity.getStock();
    }
    
    /**
     * Transformacion objeto - entidad
     * @return ProductoEntity
     */
    public ProductoEntity toEntity(){
        ProductoEntity entity = new ProductoEntity();
        entity.setIdProducto(this.id);
        entity.setNombreProducto(this.nombreProducto);
        entity.setPrecioUnitario(this.precioUnitario);
        entity.setMarcaProducto(this.marca);
        entity.setStock(this.stock);
        return entity;
    }

    public static List<ProductoDTO> toProductoList(List<ProductoEntity> listaProductos){
        List<ProductoDTO> listaProductosDTO = new ArrayList<>();
        for(ProductoEntity entity : listaProductos){
            listaProductosDTO.add(new ProductoDTO(entity));
        }
        return listaProductosDTO;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
