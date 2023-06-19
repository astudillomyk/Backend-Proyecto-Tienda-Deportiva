package com.ufro.tiendasport.services;

import com.ufro.tiendasport.models.Producto;
import com.ufro.tiendasport.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listAll(){
        return productoRepository.findAll();
    }

    public void save(Producto producto){
        productoRepository.save(producto);
    }

    public Producto get(Integer id){
        return productoRepository.findById(id).get();
    }

    public void delete(Integer id){
        productoRepository.deleteById(id);
    }

}