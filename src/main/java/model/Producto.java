package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_productos")
@Getter
@Setter
@ToString
public class Producto {
	@Id
	@Column(name = "idprod")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "idcategoria")
	private int idcategoria;
	
	@Column(name = "estado")
	private int estado;

}
