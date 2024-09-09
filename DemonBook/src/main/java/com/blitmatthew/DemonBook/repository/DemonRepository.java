package com.blitmatthew.DemonBook.repository;

import com.blitmatthew.DemonBook.entity.Demon;
import org.springframework.data.repository.ListCrudRepository;

public interface DemonRepository extends ListCrudRepository<Demon, Long> {
}
