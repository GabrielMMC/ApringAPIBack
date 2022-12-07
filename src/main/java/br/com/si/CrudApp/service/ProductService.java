package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.PersonModel;
import br.com.si.CrudApp.model.ProductModel;
import br.com.si.CrudApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<ProductModel> findById(long id){
        return repository.findById(id);
    }

    public List<ProductModel> findAll(){
        return repository.findAll();
    }

    public ProductModel save(ProductModel model){
        return repository.save(model);
    }

    public ProductModel update(ProductModel model){
        Optional<ProductModel> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setName(model.getName());
            p.get().setBrand(model.getBrand());
            p.get().setValue(model.getValue());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<ProductModel> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<ProductModel> findByBrand(String brand){
        return repository.findByBrand(brand);
    }

    public List<ProductModel> findByValue(double val1, double val2){
        return repository.findByValueBetween(val1, val2);
    }
}
