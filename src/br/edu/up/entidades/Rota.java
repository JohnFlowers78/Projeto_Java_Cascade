package br.edu.up.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Entity
public class Rota {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
    // Relacionamento UmParaUm com Ônibus
    @OneToOne(cascade = CascadeType.REMOVE)
    private Onibus onibus;
    
 // Relacionamento UmParaUm com Motorista
    @OneToOne(cascade = CascadeType.REMOVE)
    private Motorista motorista;
   
    private String nomeRota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motorista getIdOnibus() {
        return motorista;
    }

    public void setIdOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Motorista getIdMotorista() {
        return motorista;
    }

    public void setIdMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public void setNomeRota(String nomeRota) {
        this.nomeRota = nomeRota;
    }
}




