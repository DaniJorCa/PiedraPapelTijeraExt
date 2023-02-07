package Ppt;

import java.util.Scanner;

public class Parser{
    private MoveWords moves;
    private Scanner reader;


    public Parser(){
        moves = new MoveWords();
        reader = new Scanner(System.in);
    }

    public void showCommands(){

        moves.showWords();
    }

    public Moves newRandomMove(){

        return new Moves(moves.randomMove());
    }


    public Moves getMove(){

        String command = null;
        System.out.print("Tu elección: ");

        String input = reader.nextLine();

        Scanner tokenizer = new Scanner(input);

        if(tokenizer.hasNext()) {
            // get first word
            command = tokenizer.next().toUpperCase();
            if(tokenizer.hasNext()) {
                // note: if the command has two or more words, it is not
                // valid
                return new Moves();
            }
        }

        if ( (command != null) && (moves.isValidMoveCommand(command)) )
            return new Moves(command);

        // we return a move with no associated command, as it is unknown.
        return new Moves();
    }
}
