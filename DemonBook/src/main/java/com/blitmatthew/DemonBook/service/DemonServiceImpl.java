package com.blitmatthew.DemonBook.service;

import com.blitmatthew.DemonBook.entity.Demon;
import com.blitmatthew.DemonBook.repository.DemonRepository;
import jakarta.el.MethodNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemonServiceImpl implements DemonService {

    private DemonRepository demonRepository;

    private Logger logger = LoggerFactory.getLogger(DemonServiceImpl.class);

    @Autowired
    public DemonServiceImpl(DemonRepository _demonRepository){
        this.demonRepository = _demonRepository;
    }

    @Override
    public Demon saveDemon(Demon demon) {
        return demonRepository.save(demon);
    }

    @Override
    public List<Demon> getAllDemons() {
        return demonRepository.findAll();
    }

    @Override
    public void updateDemon(Demon demon, Long id) {
//        if (!demonRepository.existsById(id)) {
//            throw new EntityNotFoundException("Demon with id of " + id + " does not exist!");
//        }
        Demon oldDemon = demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + " does not exist!"));
        oldDemon = demon;
        demonRepository.save(oldDemon);
    }

    @Override
    public Demon getDemonById(Long id) {
        return demonRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Demon with id of " + id + " does not exist!"));
    }
}
