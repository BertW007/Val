package pl.rxstudio.valuationofwork;

public class Table8Item {
    private String Table8Add;
    private String Table8Use;
    private double Table8Size;

    public Table8Item(String table8Add, String table8Use, double table8size) {
        Table8Add = table8Add;
        Table8Size = table8size;
        Table8Use = table8Use;
    }

    public String getTable8Add() {
        return Table8Add;
    }

    public String getTable8Use() {
        return Table8Use;
    }

    public double getTable8Size() {
        return Table8Size;
    }
}
