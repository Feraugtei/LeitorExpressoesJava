
package com.mycompany.leitorexpressoes;

// Adicionar função de reconheçer ou não palavras, a entrada abaixo não deve ser reconhecida por erro nos parênteses
// Algumas entradas que não podem ser reconhecidas: dois operadores "oo", parênteses sem fechar ou abrir, palavra sem ";" no final.
public class LeitorExpressoes {

    public static void main(String[] args) {    //Declara uma instância JFrame e a torna visível.
        LeitorJFrame f = new LeitorJFrame();    
        f.setVisible(true);
        /*
        String expressao = "A= ((B + 300)/39.78778)*T – (X));";

        ExpressaoSimplificada expressaoSimplificada = new ExpressaoSimplificada();
        String resultado = expressaoSimplificada.converterExpressao(expressao);

        System.out.println("Expressão simplificada: " + resultado);
        */
    }
}