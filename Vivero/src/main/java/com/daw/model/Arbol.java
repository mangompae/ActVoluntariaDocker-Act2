package com.daw.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ARBOL")
public class Arbol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "ID")
	private Long id;

	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "TALLAJE")
	private Integer tallaje;

	@Column(name = "FLORAL")
	private String floral;

	@Column(name = "TIPO_ARBOL")
	private String tipoArbol;
	
	@Column(name = "ESPECIE")
	private String especie;
	
	@Column(name = "MES_FLORACION")
	private String mesFloracion;
	
	public Arbol() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getTallaje() {
		return tallaje;
	}

	public void setTallaje(Integer tallaje) {
		this.tallaje = tallaje;
	}

	public String getFloral() {
		return floral;
	}

	public void setFloral(String floral) {
		this.floral = floral;
	}

	public String getTipoArbol() {
		return tipoArbol;
	}

	public void setTipoArbol(String tipoArbol) {
		this.tipoArbol = tipoArbol;
	}

	public String getMesFloracion() {
		return mesFloracion;
	}

	public void setMesFloracion(String mesFloracion) {
		this.mesFloracion = mesFloracion;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
}
