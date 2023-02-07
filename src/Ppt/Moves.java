package Ppt;

public class Moves {
    private String move;

    public Moves(){

        this.move = null;
    }

    public Moves(String move){

        this.move = move;
    }

    public String getMove(){

        return move;
    }

    public boolean isUnknown(){

        return (move == null);
    }

    public int beats(Moves other){

        return MoveWords.checkWinner(this.move, other.getMove());
    }
}
