package factory;

import entities.Frete;

public class FreteDataFactory {

    public static Frete criarFreteValido(){

        Frete freteValido = new Frete();
        freteValido.setLocalDeEntrega("Araraquara");
        freteValido.setProduto("Notebook");
        freteValido.setQuantidade(2);
        freteValido.setTransportadora("Trans Comunidade QA");

        return freteValido;

    }

    public static Frete criarFreteComLocalDeEntregaInvalido(){
        Frete freteLocalDeEntregaInvalido = new Frete();
        freteLocalDeEntregaInvalido.setLocalDeEntrega("AB");
        freteLocalDeEntregaInvalido.setProduto("Notebook");
        freteLocalDeEntregaInvalido.setQuantidade(3);
        freteLocalDeEntregaInvalido.setTransportadora("Trans Comunidade QA");

        return freteLocalDeEntregaInvalido;

    }

    public static Frete criarFreteSemQuantidade(){
        Frete freteSemQuantidade = new Frete();
        freteSemQuantidade.setLocalDeEntrega("Recife");
        freteSemQuantidade.setProduto("Laranja cravo");
        freteSemQuantidade.setTransportadora("Trans Praia Grande");

        return freteSemQuantidade;


    }
}
