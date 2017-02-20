package com.ccc.main.enums;

public enum Gender {

    MALE('M'),
    FEMALE('F'),
    ;

    public final char code;

    Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Gender fromCode(char code){
        if(code == 'M' || code == 'm'){
            return MALE;
        }
        if(code == 'F' || code == 'f'){
            return FEMALE;
        }
        throw new UnsupportedOperationException();
    }
}
