package ru.goryachev.multichief.construction.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.ConstructionCommonDto;
import ru.goryachev.multichief.construction.model.entity.Construction;


/**
 * ConstructionConverter. Converter is used for converting Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 1.1
 */

@Component
public class ConstructionConverter implements Converter {
    private ModelMapper modelMapper;

      public ConstructionConverter() {
            this.modelMapper = new ModelMapper();
      }

    @Override
    public CommonDto entityToDto (Object construction){
          return modelMapper.map(construction, ConstructionCommonDto.class);
    }

    @Override
    public Object dtoToEntity (CommonDto constructionCommonDto) {
          return modelMapper.map(constructionCommonDto, Construction.class);
    }

}
