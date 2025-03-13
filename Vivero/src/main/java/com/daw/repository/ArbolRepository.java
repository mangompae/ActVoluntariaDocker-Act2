package com.daw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.daw.model.Arbol;

@Repository
public interface ArbolRepository extends JpaRepository<Arbol, Long>{

	@Query("SELECT a FROM Arbol a "
			+ " WHERE (:tipoArbol IS NULL OR a.tipoArbol = :tipoArbol) "
			+ " AND (:tallaje IS NULL OR a.tallaje = :tallaje) "
			+ " AND (:mesFloracion IS NULL OR :mesFloracion = '' OR a.mesFloracion = :mesFloracion)")
	public List<Arbol> findArboles(@Param("tipoArbol") String tipoArbol, Integer tallaje, String mesFloracion);
	
	public Arbol findByCodigo(String codigo);
	
}
