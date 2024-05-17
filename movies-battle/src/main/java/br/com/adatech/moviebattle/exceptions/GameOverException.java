package br.com.adatech.moviebattle.exceptions;

public class GameOverException extends RuntimeException {

    public GameOverException(String msg, Long scoreFinal) {
        super(msg + " " + scoreFinal);

    }
}