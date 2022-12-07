package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    public Optional<ProductModel> findById(long id);

    List<ProductModel> findByBrand(String brand);

    List<ProductModel> findByValueBetween(double val1, double val2);
}
