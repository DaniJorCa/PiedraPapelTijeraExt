package Ppt;

public class Game {
    private Parser parser;

    public Game() {
        parser = new Parser();
    }

    private void welcome() {
        System.out.println("Bienvenido a nuestro pequeño juego: Piedra Papel Tijeras :-D");
    }

    private void printHelp() {
        System.out.println("");
        System.out.println("Ordenes y comandos válidos para el juego: ");
        parser.showCommands();
    }

    private Moves computerMove() {

        return parser.newRandomMove();
    }

    private void printWinner(int who) {

        if (who == MoveWords.EMPATE)
            System.out.println("Es un empate\n");
        else if (who == MoveWords.GANA)
            System.out.println("Tu ganas!!! :-D \n");
        else
            System.out.println("Tu pierdes!!! :-( \n");
    }

    private void printMoves(Moves player, Moves computer) {
        System.out.println("Y el resultado es...");
        System.out.println("Tu elegiste: " + player.getMove());
        System.out.println("El PC elige: " + computer.getMove());
    }

    private boolean processMove(Moves move) {
        Moves pcMove;

        if (move.isUnknown()) {
            System.out.println("Opción No Válida");
            printHelp();
            return true;
        }

        if (move.getMove().equals("SALIR")) {
            return false;
        }

        if (move.getMove().equals("AYUDA")) {
            printHelp();
            return true;
        }
        pcMove = computerMove();
        printMoves(move, pcMove);
        printWinner(move.beats(pcMove));
        return true;
    }

    public void playGame() {

        boolean continuing = true;
        Moves move;
        int round = 1;
        while (continuing) {
            System.out.println("****** " + round + " turno ******");
            move = parser.getMove();
            continuing = processMove(move);
            round++;
        }
        System.out.println("Adios!!");
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.welcome();
        g.playGame();
    }


}
