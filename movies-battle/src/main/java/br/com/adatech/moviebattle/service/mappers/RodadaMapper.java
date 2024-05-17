package br.com.adatech.moviebattle.service.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.adatech.moviebattle.entities.Rodada;
import br.com.adatech.moviebattle.utils.ConstantesUtils;

@Mapper
public interface RodadaMapper {

    RodadaMapper INSTANCE = Mappers.getMapper(RodadaMapper.class);

    Rodada map(br.com.adatech.moviebattle.openapi.model.Rodada openApiModel);

    br.com.adatech.moviebattle.openapi.model.Rodada map(Rodada entity);

    @AfterMapping
    default void setMessage(@MappingTarget br.com.adatech.moviebattle.openapi.model.Rodada openApiModel, Rodada rodada) {
        openApiModel.setMessage(ConstantesUtils.getMensagemRodada(rodada.getUsuario()));
    }
}
