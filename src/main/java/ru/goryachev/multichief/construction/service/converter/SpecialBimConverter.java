package ru.goryachev.multichief.construction.service.converter;

import org.springframework.stereotype.Component;
import ru.goryachev.multichief.construction.model.dto.request.BimRequestDto;
import ru.goryachev.multichief.construction.model.dto.response.BimPreformDTO;
import ru.goryachev.multichief.construction.model.entity.Bim;

/**
 * SpecialBimConverter converts Entity to CommonDto and CommonDto to Entity using common fields.
 * @author Lev Goryachev
 * @version 2
 */

@Component
public class SpecialBimConverter {

    public BimPreformDTO entityToDto (Bim bim){
          BimPreformDTO bimPreformDTO = new BimPreformDTO();
          bimPreformDTO.setId(bim.getId());
          bimPreformDTO.setProjectCodeNumber(bim.getProjectCodeNumber());
          bimPreformDTO.setProjectName(bim.getProjectName());
          bimPreformDTO.setLod(bim.getLod());
          bimPreformDTO.setProjectType(bim.getProjectType());
          bimPreformDTO.setEir(bim.getEir());
          bimPreformDTO.setLink(bim.getLink());
          return bimPreformDTO;
    }

    public Bim dtoToEntity (BimRequestDto bimRequestDto) {
          Bim bim = new Bim();
          bim.setId(bimRequestDto.getId());
          bim.setProjectCodeNumber(bimRequestDto.getProjectCodeNumber());
          bim.setProjectName(bimRequestDto.getProjectName());
          bim.setLod(bimRequestDto.getLod());
          bim.setProjectTypeId(bimRequestDto.getProjectTypeId());
          bim.setEirId(bimRequestDto.getEirId());
          bim.setLink(bimRequestDto.getLink());
          return bim;
    }
}
