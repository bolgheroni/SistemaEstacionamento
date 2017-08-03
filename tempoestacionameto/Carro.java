/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempoestacionameto;

import java.time.LocalDateTime;

/**
 *
 * @author John
 */
public class Carro {
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Carro(String placa, LocalDateTime entrada) {
        this.placa = placa;
        this.entrada = entrada;
    }
    
    
    
    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
