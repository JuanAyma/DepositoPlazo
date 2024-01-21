package com.bbva.productmicroservice.controller;

import com.bbva.productmicroservice.entity.ProductEntity;
import com.bbva.productmicroservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/producto")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/listar-productos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarProductos() {
        Object products = productService.findAll();
        if (products != null) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron productos");
    }

    @GetMapping("/buscar-producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarProducto(@PathVariable Long id) {
        ProductEntity productEntity = productService.findById(id);
        if (productEntity != null) {
            return ResponseEntity.ok(productEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el producto");
    }

    @PostMapping("/registrar-producto")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarProducto(@RequestBody ProductEntity productoEntity) {
        productService.save(productoEntity);
    }

    @DeleteMapping("/eliminar-producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarProducto(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
