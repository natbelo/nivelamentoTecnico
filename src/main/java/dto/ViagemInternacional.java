package dto;

import enums.Destinos;
import interfaces.CalculadorDePrevisao;
import utils.ArquivosUtils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class ViagemInternacional extends Viagem implements CalculadorDePrevisao {
    private String passaporte;

    public ViagemInternacional(Destinos lugarDeDestino){
        super(lugarDeDestino);
    }

    public String getPassaporte(){
        return this.passaporte;
    }

    public void setPassaporte(String passaporte){
        this.passaporte = passaporte;
    }

    public void setAcompanhantes(List<Acompanhante> acompanhantes) throws Exception {

        int limiteDeAcompanhantes = Integer.parseInt(ArquivosUtils.getPropriedades("viagem.internacional.acompanhantes.limite"));

        if (acompanhantes.size() <= limiteDeAcompanhantes){
            super.setAcompanhantes(acompanhantes);
        } else {
            throw new Exception("Viagens internacionais não podem ter mais que" +limiteDeAcompanhantes+ "acompanhante");
        }
    }

    public int calcularPrevisaoDeDiasParaRetorno(){
        if (this.getDestino().equals(Destinos.MIAMI)){
            return 1;
        }
        return 0;
    }
}
