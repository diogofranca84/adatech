package br.com.adatech.moviebattle.service.impl;

import org.springframework.stereotype.Service;

import br.com.adatech.moviebattle.entities.Rodada;
import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.exceptions.PartidaNaoIniciadaException;
import br.com.adatech.moviebattle.repository.RodadaRepository;
import br.com.adatech.moviebattle.service.interfaces.JogoService;
import br.com.adatech.moviebattle.service.interfaces.MovieService;
import br.com.adatech.moviebattle.service.interfaces.RodadasService;
import br.com.adatech.moviebattle.service.interfaces.UsuarioService;
import br.com.adatech.moviebattle.utils.ConstantesUtils;

import java.util.Objects;
import java.util.Optional;

@Service
public class RodadasServiceImpl implements RodadasService {

    private final MovieService movieService;
    private final RodadaRepository rodadaRepository;
    private final JogoService jogoService;
    private final UsuarioService usuarioService;

    public RodadasServiceImpl(MovieService moviePort, RodadaRepository rodadaRepository, JogoService jogoService, UsuarioService usuarioService) {
        this.movieService = moviePort;
        this.rodadaRepository = rodadaRepository;
        this.jogoService = jogoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public Rodada inicializarRodada(Usuario usuario) {
        var jogo = jogoService.findJogoByUsuario();
        if (getRodadaAtivaByUser(jogo.getUsuario().getUsername()).isPresent()) {
            return getRodadaAtivaByUser(jogo.getUsuario().getUsername()).get();
        }
        var rodada = new Rodada(movieService.getTwoRandomMovies(jogo), usuario, jogo);
        return salvarRodada(rodada);
    }

    @Override
    public String jogar(int numeroFilme) {
        var usuarioLogado = usuarioService.getUsernameUsuarioLogado();
        var rodadaAtual = rodadaRepository
                .findByUsuarioUsernameAndIsFinalizadaFalse(usuarioService.getUsuario(usuarioLogado).getUsername()).orElseThrow(() -> new PartidaNaoIniciadaException("Nenhuma partida foi iniciada"));
        var resultadoRodada = verificaAcerto(rodadaAtual, numeroFilme);
        if(verificaErros(rodadaAtual, 3)) {
            return jogoService.finalizarJogo(rodadaAtual.getJogo());
        };
        salvarRodada(rodadaAtual);
        return ConstantesUtils.verificaAcerto(resultadoRodada);

    }

    private Rodada salvarRodada(Rodada rodada) {
        return rodadaRepository.save(rodada);
    }

    private Optional<Rodada> getRodadaAtivaByUser(String usuario) {
        return rodadaRepository.findByUsuarioUsernameAndIsFinalizadaFalse(usuario);
    }

    private boolean verificaAcerto(Rodada rodada, int numeroFilme) {
        var verificaAcerto = rodada.verificarResposta(numeroFilme);
        if (verificaAcerto) {
            rodada.setAcerto(true);
            rodada.getJogo().setScore(rodada.getJogo().getScore() + 1.0d);
        } else {
            rodada.setAcerto(false);
            rodada.getJogo().setErros(rodada.getJogo().getErros() + 1);
        }
        rodada.setFinalizada(true);
        return verificaAcerto;
    }

    private boolean verificaErros(Rodada rodada, int numeroErrosMaximo) {
        if (Objects.equals(rodada.getJogo().getErros(), numeroErrosMaximo)) {
            rodada.getJogo().setFinalizado(true);
            return true;
        }
        return false;
    }
}
