package dto;

import enums.Destinos;
import interfaces.CalculadorDePrevisao;
import utils.ArquivosUtils;


import java.util.List;


public class ViagemNacional extends Viagem implements CalculadorDePrevisao {
    private String cpf;

    public ViagemNacional(Destinos lugarDeDestino){
        super(lugarDeDestino);
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setAcompanhantes(List<Acompanhante> acompanhantes) throws Exception {

        int limiteDeAcompanhantes = Integer.parseInt(ArquivosUtils.getPropriedades("viagem.nacional.acompanhantes.limite"));

        if (acompanhantes.size() <= limiteDeAcompanhantes){
            super.setAcompanhantes(acompanhantes);
        } else {
            throw new Exception("Viagens nacionais não podem ter mais que" + limiteDeAcompanhantes + "acompanhante");
        }
    }

    public int calcularPrevisaoDeDiasParaRetorno(){
        int quantidadeDeDias = 0;

        switch (this.getDestino()){
            case CAMPINAS: quantidadeDeDias = 4; break;
            case RECIFE: quantidadeDeDias = 3; break;
            case CURITIBA: quantidadeDeDias = 2; break;
            case NATAL: quantidadeDeDias = 1; break;

        }

        return quantidadeDeDias;
    }
}
