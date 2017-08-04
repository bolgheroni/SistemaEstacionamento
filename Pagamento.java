/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author aluno
 */
public class Pagamento {

    public double pagamento(LocalDateTime entrada, LocalDateTime saida) {

        long tempoEstacionado = 0;
        double valorPagamento = 0;
        tempoEstacionado = ChronoUnit.HOURS.between(entrada, saida);

        if (tempoEstacionado >= 0 && tempoEstacionado <= 3) {
            valorPagamento = 15;
        } else if (tempoEstacionado > 3 && tempoEstacionado <= 24) {
            valorPagamento = 15 + ((tempoEstacionado - 3) * 5);
        } else if (tempoEstacionado > 24) {
            valorPagamento = 120 + (((tempoEstacionado - 24) / 24) * 45);
        } else {
            valorPagamento = 0;
        }

        return valorPagamento;
    }
}
