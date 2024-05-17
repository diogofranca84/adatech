package br.com.adatech.moviebattle.config;

import br.com.adatech.moviebattle.exceptions.GameOverException;
import br.com.adatech.moviebattle.exceptions.PartidaNaoIniciadaException;
import br.com.adatech.moviebattle.openapi.model.Mensagem;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem genericHandler(Exception e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mensagem illegalArgumentHandler(IllegalArgumentException e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(GameOverException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem gameOverHandler(GameOverException e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(PartidaNaoIniciadaException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem partidaNaoIniciadaHandler(PartidaNaoIniciadaException e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

}
