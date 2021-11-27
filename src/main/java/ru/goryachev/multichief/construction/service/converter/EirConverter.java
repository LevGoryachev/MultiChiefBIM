package ru.goryachev.multichief.construction.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.EirCommonDto;
import ru.goryachev.multichief.construction.model.entity.Eir;

/**
 * EirConverter. Converter is used for converting Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 1.1
 */

@Component
public class EirConverter implements Converter {
    private ModelMapper modelMapper;

      public EirConverter() {
            this.modelMapper = new ModelMapper();
      }

    @Override
    public CommonDto entityToDto (Object eir){
          return modelMapper.map(eir, EirCommonDto.class);
    }

    @Override
    public Object dtoToEntity (CommonDto eirCommonDto) {
          return modelMapper.map(eirCommonDto, Eir.class);
    }
}
