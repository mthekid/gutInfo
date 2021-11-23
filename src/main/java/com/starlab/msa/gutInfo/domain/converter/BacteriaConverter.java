package com.starlab.msa.gutInfo.domain.converter;

import com.starlab.msa.gutInfo.domain.BacteriaType;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class BacteriaConverter implements AttributeConverter<BacteriaType, String> {

    @Override
    public String convertToDatabaseColumn(BacteriaType bacteriaType) {
        return bacteriaType.getType();
    }

    @Override
    public BacteriaType convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(BacteriaType.class).stream()
                .filter(e -> e.getType().equals(dbData))
                .findAny()
                .orElseThrow( () -> new NoSuchElementException());
    }
}
