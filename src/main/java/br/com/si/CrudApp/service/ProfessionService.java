package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.ProfessionModel;
import br.com.si.CrudApp.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionService {

    @Autowired
    private ProfessionRepository repository;

    public Optional<ProfessionModel> findById(long id){
        return repository.findById(id);
    }

    public List<ProfessionModel> findAll(){
        return repository.findAll();
    }

    public List<ProfessionModel> findByName(String name){
        return repository.findByNameContainsIgnoreCase(name);
    }

    public ProfessionModel save(ProfessionModel model){
        return repository.save(model);
    }

    public ProfessionModel update(ProfessionModel model){
        var found = repository.findById(model.getId());
        if(found.isPresent()){
            found.get().setName(model.getName());
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);
        if(found.isPresent()){
            repository.delete(found.get());
        }
    }


}
