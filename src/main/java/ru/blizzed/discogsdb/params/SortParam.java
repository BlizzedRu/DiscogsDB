package ru.blizzed.discogsdb.params;

public class SortParam extends EnumParam<SortParam.Type> {

    public enum Type {
        YEAR, TITLE, FORMAT
    }

    public SortParam() {
        super("sort");
    }

}
