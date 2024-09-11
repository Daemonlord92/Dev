package com.blitmatthew.DemonBook.service;

import com.blitmatthew.DemonBook.entity.Demon;
import com.blitmatthew.DemonBook.repository.DemonRepository;
import jakarta.el.MethodNotFoundException;
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
}
