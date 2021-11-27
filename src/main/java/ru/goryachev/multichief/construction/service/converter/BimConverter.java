package ru.goryachev.multichief.construction.service.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.CommonDto;
import ru.goryachev.multichief.construction.model.dto.common.BimCommonDto;
import ru.goryachev.multichief.construction.model.entity.Bim;

/**
 * BimConverter. Converter is used for converting Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 1.1
 */

@Component
public class BimConverter implements Converter {
    private ModelMapper modelMapper;

      public BimConverter() {
            this.modelMapper = new ModelMapper();
      }

    @Override
    public CommonDto entityToDto (Object bim){
          return modelMapper.map(bim, BimCommonDto.class);
    }

    @Override
    public Object dtoToEntity (CommonDto bimCommonDto) {
          return modelMapper.map(bimCommonDto, Bim.class);
    }
}
