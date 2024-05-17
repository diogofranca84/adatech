package br.com.adatech.moviebattle.service.mappers;

import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.openapi.model.ScoreBoardPosition;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-17T14:21:04+0100",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class ScoreBoardMapperImpl implements ScoreBoardMapper {

    @Override
    public ScoreBoardPosition map(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        ScoreBoardPosition scoreBoardPosition = new ScoreBoardPosition();

        if ( usuario.getMelhorScore() != null ) {
            scoreBoardPosition.setPontuacao( usuario.getMelhorScore().longValue() );
        }
        scoreBoardPosition.setNome( usuario.getNome() );
        scoreBoardPosition.setPosicao( usuario.getPosicao() );

        return scoreBoardPosition;
    }

    @Override
    public Usuario map(ScoreBoardPosition scoreBoardPosition) {
        if ( scoreBoardPosition == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( scoreBoardPosition.getNome() );
        if ( scoreBoardPosition.getPosicao() != null ) {
            usuario.setPosicao( scoreBoardPosition.getPosicao() );
        }

        return usuario;
    }

    @Override
    public List<ScoreBoardPosition> map(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<ScoreBoardPosition> list = new ArrayList<ScoreBoardPosition>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( map( usuario ) );
        }

        return list;
    }
}
