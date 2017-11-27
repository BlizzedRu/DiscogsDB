package ru.blizzed.discogsdb.params;

public class TypeParam extends EnumParam<TypeParam.Type> {

    public enum Type {
        RELEASE, MASTER, ARTIST, LABEL
    }

    public TypeParam() {
        super("type");
    }

}
