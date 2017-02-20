package com.ccc.main.hbm;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.ccc.main.enums.Gender;

@Converter
public class GenderConverter implements AttributeConverter<Gender, Character>{
    @Override
    public Character convertToDatabaseColumn(Gender attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Character dbData) {
        if(dbData == null){
            return null;
        }
        return Gender.fromCode(dbData);
    }
}
