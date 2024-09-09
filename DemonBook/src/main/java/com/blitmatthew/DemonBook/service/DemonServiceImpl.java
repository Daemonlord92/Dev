package com.blitmatthew.DemonBook.service;

import com.blitmatthew.DemonBook.entity.Demon;
import com.blitmatthew.DemonBook.repository.DemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemonServiceImpl implements DemonService {

    private DemonRepository demonRepository;

    @Autowired
    public DemonServiceImpl(DemonRepository _demonRepository){
        this.demonRepository = _demonRepository;
    }

    @Override
    public Demon saveDemon(Demon demon) {
        return null;
    }

    @Override
    public List<Demon> getAllDemons() {
        return List.of();
    }
}
