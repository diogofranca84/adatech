package br.com.adatech.moviebattle.service.mappers;

import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.openapi.model.ScoreBoardPosition;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ScoreBoardMapper {

    ScoreBoardMapper INSTANCE = Mappers.getMapper(ScoreBoardMapper.class);

    @Mapping(source = "melhorScore", target = "pontuacao")
    ScoreBoardPosition map(Usuario usuario);

    Usuario map(ScoreBoardPosition scoreBoardPosition);

    List<ScoreBoardPosition> map(List<Usuario> usuarios);

}
