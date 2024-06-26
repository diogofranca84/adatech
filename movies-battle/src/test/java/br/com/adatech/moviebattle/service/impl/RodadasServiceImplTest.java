package br.com.adatech.moviebattle.service.impl;

import br.com.adatech.moviebattle.entities.Jogo;
import br.com.adatech.moviebattle.entities.Rodada;
import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.repository.RodadaRepository;
import br.com.adatech.moviebattle.service.impl.RodadasServiceImpl;
import br.com.adatech.moviebattle.service.interfaces.JogoService;
import br.com.adatech.moviebattle.service.interfaces.MovieService;
import br.com.adatech.moviebattle.service.interfaces.RodadasService;
import br.com.adatech.moviebattle.service.interfaces.UsuarioService;
import br.com.adatech.moviebattle.utils.ConstantesUtils;
import br.com.adatech.moviebattle.utils.TestUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RodadasServiceImplTest {

    final String NOME_USUARIO = TestUtils.NOME_USUARIO;

    @Mock
    MovieService movieService;
    @Mock
    RodadaRepository rodadaRepository;
    @Mock
    JogoService jogoService;
    @Mock
    UsuarioService usuarioService;

    RodadasService rodadasService;

    Usuario usuario;
    Jogo jogo;
    Rodada rodada;

    @BeforeEach
    void setUp() {
        rodadasService = new RodadasServiceImpl(movieService, rodadaRepository, jogoService, usuarioService);
        usuario = TestUtils.getUsuarioMock(TestUtils.NOME_USUARIO);
        jogo = TestUtils.getJogoMock(usuario);
        rodada = TestUtils.getRodadaMock(usuario);
    }

    @Test
    void deveSucessoAoIniciarUmaNovaRodada() {
        Mockito.when(jogoService.findJogoByUsuario()).thenReturn(jogo);
        Mockito.when(rodadaRepository.save(Mockito.any(Rodada.class))).thenReturn(rodada);

        var rodada = rodadasService.inicializarRodada(usuario);

        assertFalse(rodada.isFinalizada());
        assertNotNull(rodada.getJogo());
        assertNotNull(rodada.getUsuario());
    }

    @Test
    void deveSucessoQuandoEscolherOFilmeCerto() {
        Mockito.when(usuarioService.getUsernameUsuarioLogado()).thenReturn(NOME_USUARIO);
        Mockito.when(usuarioService.getUsuario(NOME_USUARIO)).thenReturn(usuario);
        Mockito.when(rodadaRepository.findByUsuarioUsernameAndIsFinalizadaFalse(Mockito.anyString())).thenReturn(Optional.of(rodada));
        var scoreAntigo = usuario.getMelhorScore();

        var resultado = rodadasService.jogar(1);

        assertEquals(ConstantesUtils.verificaAcerto(true), resultado);
    }

    @Test
    void deveSucessoQuandoEscolherOFilmeErrado() {
        Mockito.when(usuarioService.getUsernameUsuarioLogado()).thenReturn(NOME_USUARIO);
        Mockito.when(usuarioService.getUsuario(NOME_USUARIO)).thenReturn(usuario);
        Mockito.when(rodadaRepository.findByUsuarioUsernameAndIsFinalizadaFalse(Mockito.anyString())).thenReturn(Optional.of(rodada));
        var scoreAntigo = usuario.getMelhorScore();

        var resultado = rodadasService.jogar(2);

        assertEquals(ConstantesUtils.verificaAcerto(false), resultado);
    }

}