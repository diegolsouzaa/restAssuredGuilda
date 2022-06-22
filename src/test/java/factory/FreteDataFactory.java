package factory;

import entities.Frete;

public class FreteDataFactory {

    public static Frete criarFreteValido(){

        Frete frete = new Frete();
        frete.setTransportadora("transComunidade");
        frete.setProduto("televisao");
        frete.setQuantidade(3);
        frete.setLocalDeEntrega("Joao Pessoa");

        return frete;
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
