package br.edu.up.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Onibus {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String nomeLinha;
    private int numeroLinha;
    
    public Onibus() {
        // Construtor sem parâmetros
    }
    
    public Onibus(int id) {
        this.id = id;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeLinha() {
		return nomeLinha;
	}
	public void setNomeLinha(String nomeLinha) {
		this.nomeLinha = nomeLinha;
	}
	public int getNumeroLinha() {
		return numeroLinha;
	}
	public void setNumeroLinha(int númeroLinha) {
		this.numeroLinha = númeroLinha;
	}
    

}
