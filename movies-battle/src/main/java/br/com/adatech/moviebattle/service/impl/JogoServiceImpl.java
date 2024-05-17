package br.com.adatech.moviebattle.service.impl;

import org.springframework.stereotype.Service;

import br.com.adatech.moviebattle.entities.Jogo;
import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.exceptions.BusinessException;
import br.com.adatech.moviebattle.exceptions.PartidaNaoIniciadaException;
import br.com.adatech.moviebattle.repository.JogoRepository;
import br.com.adatech.moviebattle.service.interfaces.JogoService;
import br.com.adatech.moviebattle.service.interfaces.UsuarioService;
import br.com.adatech.moviebattle.utils.ConstantesUtils;

@Service
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;
    private final UsuarioService usuarioService;

    public JogoServiceImpl(JogoRepository jogoRepository, UsuarioService usuarioService) {
        this.jogoRepository = jogoRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public Jogo inicializarJogo() {
     var usuario = usuarioService.getUsuario(usuarioService.getUsernameUsuarioLogado());
     if (verificarSeHaJogosEmAndamento(usuario)) {
         throw new BusinessException("Não é possível iniciar um novo jogo com outro em andamento");
     }
     return salvarJogo(new Jogo(usuarioService.getUsuario(usuarioService.getUsernameUsuarioLogado())));
    }

    @Override
    public Jogo findJogoByUsuario() {
        return jogoRepository.findByUsuarioUsernameAndIsFinalizadoFalse(usuarioService.getUsernameUsuarioLogado())
                .orElseThrow(() -> new PartidaNaoIniciadaException("Não há nenhuma partida em andamento"));
    }

    @Override
    public String finalizarJogo(Jogo jogo) {
        jogo.setFinalizado(true);
        atualizarScoreFinal(jogo);
        salvarJogo(jogo);
        return ConstantesUtils.mensagemDeDespedida(jogo.getScoreFinal());
    }

    private void atualizarScoreFinal(Jogo jogo) {
        var scoreFinal = jogo.calcularPontuacaoFinal();
        jogo.setScoreFinal(scoreFinal);
        var melhorScoreUsuario = jogo.getUsuario().getMelhorScore();
        if (melhorScoreUsuario < scoreFinal) {
            jogo.getUsuario().setMelhorScore((Double.parseDouble(String.valueOf(scoreFinal))));
        }
    }

    private Jogo salvarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    private boolean verificarSeHaJogosEmAndamento(Usuario usuario) {
        return usuario.getJogos().stream().anyMatch(jogo -> {
            if(jogo.isFinalizado()) {
                return false;
            }
            return true;
        });
    }


}
