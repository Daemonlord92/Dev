package com.blitmatthew.DemonBook.service;

import com.blitmatthew.DemonBook.entity.Demon;

import java.util.List;

public interface DemonService {
    Demon saveDemon(Demon demon);
    List<Demon> getAllDemons();
}
