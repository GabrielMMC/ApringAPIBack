package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.ProfessionModel;
import br.com.si.CrudApp.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private ProfessionService service;

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml" })
    public ProfessionModel findById(@PathVariable("id") long id){
        return service.findById(id).get();
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml" })
    public List<ProfessionModel> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/find/{name}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml" })
    public List<ProfessionModel> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

    @PostMapping
    public ProfessionModel save(@RequestBody ProfessionModel model){
        return service.save(model);
    }

    @PutMapping
    public ProfessionModel update(@RequestBody ProfessionModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
