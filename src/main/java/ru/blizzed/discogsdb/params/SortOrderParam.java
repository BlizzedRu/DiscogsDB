package ru.blizzed.discogsdb.params;

public class SortOrderParam extends EnumParam<SortOrderParam.Type> {

    public enum Type {
        DESC, ASC
    }

    public SortOrderParam() {
        super("sort_order");
    }

}
