package com.Duoc.SceneIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Duoc.SceneIt.modelo.Productora;
import com.Duoc.SceneIt.service.ProductoraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/productoras")
public class ProductoraController{

    @Autowired
    private ProductoraService productoraService;

    @GetMapping
    public ResponseEntity<List<Productora>> getAllProductoras(){
        return ResponseEntity.ok(productoraService.getProductora());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productora> findProductora(@PathVariable Integer id){
        Productora productora = productoraService.getProductoraId(id);
        if(productora == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productora);
    }

    @PostMapping
    public ResponseEntity<Productora> saveProductora(@PathVariable Productora productora){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoraService.saveProductora(productora));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productora> updateProductora(@PathVariable Integer id, @Valid @RequestBody Productora productora){
        productora.setId_productora(id);
        Productora actualizado = productoraService.updateProductora(productora);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProductora(@PathVariable Integer id){
        productoraService.deleteProductora(id);
        return ResponseEntity.noContent().build();
    }
}

 


