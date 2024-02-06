package com.example.dependencyInjection.tax;


public interface Taxable {

    abstract double getSimpleTaxRate();
    abstract double getMiddleTaxRate();
    abstract double getUpperTaxRate();
}
