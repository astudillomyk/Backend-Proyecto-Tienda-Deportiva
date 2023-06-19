package com.ufro.tiendasport.controllers;

import com.ufro.tiendasport.models.Producto;
import com.ufro.tiendasport.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/getAll")
    @CrossOrigin(origins = "*")
    public List<Producto> list(){
        return productoService.listAll();
    }

    @PostMapping ("/add")
    public String add(@RequestBody Producto producto){
        productoService.save(producto);
        return "Nuevo producto agregado";
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Producto> get(@PathVariable Integer id){
        try{
            Producto producto = productoService.get(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Integer id){
        try{
            Producto existingProducto = productoService.get(id);
            productoService.save(producto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "Se ha eliminado el producto " + id;
    }
}
