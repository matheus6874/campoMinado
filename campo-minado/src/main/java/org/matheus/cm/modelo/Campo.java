package org.matheus.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    public final int linha;
    public final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;


    private List<Campo> vizinhpos = new ArrayList<>();

    Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    //TODO
    boolean adicionarVizinho(Campo vizinho){
        return true;
    }
}
