package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.PersonModel;
import br.com.si.CrudApp.model.ProductModel;
import br.com.si.CrudApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public Optional<ProductModel> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public ProductModel save(@RequestBody ProductModel model){
        return service.save(model);
    }

    @GetMapping
    public List<ProductModel> findAll(){
        return service.findAll();
    }

    @PutMapping
    public ProductModel update(@RequestBody ProductModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/brand/{brand}")
    public List<ProductModel> findByBrand(@PathVariable("brand") String brand){
        return service.findByBrand(brand);
    }

    @GetMapping("/find/value/{val1}/{val2}")
    public List<ProductModel> findByValue(@PathVariable("val1") double val1, @PathVariable("val2") double val2){
        return service.findByValue(val1, val2);
    }

}
