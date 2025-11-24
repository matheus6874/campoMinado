package swing.modelo;
import java.util.ArrayList;
import java.util.List;

public class Campo {
    public final int linha;
    public final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;


    private List<Campo> vizinhos = new ArrayList<>();
    private List<CampoObservador> observadores = new ArrayList<>();


    public Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public void registrarObservador(CampoObservador observador){
        observadores.add(observador);
    }

    private void notificarObservadores(CampoEvento evento){
        observadores.stream()
                .forEach(o -> o.eventoOcorrou(this,evento));
    }




    public boolean adicionarVizinho(Campo vizinho){
        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunDiferente;

        int deltaLinha = Math.abs(this.linha  - vizinho.linha);
        int deltaColuna = Math.abs(this.coluna  - vizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        if (deltaGeral == 1 && !diagonal){
            vizinhos.add(vizinho);
            return true;
        }else if (deltaGeral == 2 && diagonal){
            vizinhos.add(vizinho);
            return true;
        }else {
            return false;
        }
    }

    public void alternarMarcacao(){
        if (!aberto){
            marcado = !marcado;
            if (marcado){
                notificarObservadores(CampoEvento.MARCAR);
            }else{
                notificarObservadores(CampoEvento.DESMARCAR);
            }
        }
    }

    public boolean abrir(){
        if (!aberto && !marcado){
            if (minado){
                notificarObservadores(CampoEvento.EXPLODIR);
                return true;
            }
            setAberto(true);
            if (vizinhancaSegura()){
                vizinhos.forEach(v -> v.abrir());
            }
            return true;
        }else{
            return false;
        }
    }

    boolean vizinhancaSegura(){
        return vizinhos.stream().noneMatch(v -> v.minado);
    }

    public boolean isMarcado(){
        return marcado;
    }

    public void minar(){
        minado = true;
    }

    public boolean isMinado(){
        return minado;
    }

    void setAberto(boolean aberto){
        this.aberto = aberto;
        if (aberto){
            notificarObservadores(CampoEvento.ABRIR);
        }
    }

    public boolean isAberto(){
        return aberto;
    }

    public boolean isFechado(){
        return !isAberto();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetivoAlcancado(){
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    long minasNaVizinhanca(){
        return vizinhos.stream().filter(v -> v.minado).count();
    }

    void reiniciar(){
        aberto = false;
        minado = false;
        marcado = false;
    }
}
