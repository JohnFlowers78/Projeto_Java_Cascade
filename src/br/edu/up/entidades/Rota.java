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
    @OneToOne(cascade = CascadeType.PERSIST)                 // QUE PORRA É   (cascade = CascadeType.REMOVE)     ?????????
    private Onibus onibus;
    
 // Relacionamento UmParaUm com Motorista
    @OneToOne(cascade = CascadeType.PERSIST)
    private Motorista motorista;
   
    private String nomeRota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motorista getOnibus() {
        return motorista;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public void setNomeRota(String nomeRota) {
        this.nomeRota = nomeRota;
    }
}




