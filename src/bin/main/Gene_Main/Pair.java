package bin.main.Gene_Main;

public class Pair<E>{
    private E p1;
    private E p2;

    public Pair(E p1, E p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public E getP1() {
        return p1;
    }

    public E getP2() {
        return p2;
    }
}
