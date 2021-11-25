package ru.goryachev.multichief.construction.exception;
/**
 * MultiChiefObjectNotFoundException is a custom MultiChief application exception
 * (informs about DTO/entity type and id/property name of object having problems)
 * @author Lev Goryachev
 * @version 1.1
 */
public class MultiChiefObjectNotFoundException extends Exception {

    public MultiChiefObjectNotFoundException(String entityTypeName, Long id) {
        super(String.format("%s with ID %d not found in database", entityTypeName, id));
    }
}
