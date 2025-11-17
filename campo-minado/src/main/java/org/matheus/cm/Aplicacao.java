package org.matheus.cm;

import org.matheus.cm.modelo.Tabuleiro;
import org.matheus.cm.visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(tabuleiro);
    }
}
