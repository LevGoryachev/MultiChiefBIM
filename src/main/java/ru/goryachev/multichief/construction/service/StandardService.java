package ru.goryachev.multichief.construction.service;

import ru.goryachev.multichief.construction.model.dto.CommonDto;

/**
 * StandardService provides CRUD operations for common DTO.
 * @author Lev Goryachev
 * @version 1.1
 */
public interface StandardService {
    Iterable<CommonDto> getAll();
    Object create(CommonDto dto);
    Object update(CommonDto dto);
    Object delete(Long id);
}
