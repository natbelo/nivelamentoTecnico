package enums;

public enum Destinos {
    CAMPINAS("Campinas"),
    CURITIBA("Curitiba"),
    RECIFE("Recife"),
    MARINGA("Maringá"),
    NATAL("Natal"),
    MIAMI("Miami"),
    ACAPULCO("Acapulco");

    private String cidade;

    Destinos(String cidade){
        this.cidade = cidade;

    }

    public String getCidade(){
        return this.cidade;
    }
}
