package org.icao.repository;

import org.icao.model.coverter.Converter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRepository extends JpaRepository<Converter, Integer> {

}
