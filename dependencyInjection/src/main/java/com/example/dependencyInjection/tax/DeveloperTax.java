package com.example.dependencyInjection.tax;

import com.example.dependencyInjection.model.JuniorDeveloper;
import com.example.dependencyInjection.model.MidDeveloper;
import com.example.dependencyInjection.model.SeniorDeveloper;
import org.springframework.stereotype.Component;


/**
 * @Component anotasyonu koymadığım için bean? hatası aldım.
 */
@Component
public class DeveloperTax implements Taxable {

    private JuniorDeveloper juniorDeveloper;
    private MidDeveloper midDeveloper;
    private SeniorDeveloper seniorDeveloper;


    @Override
    public double getSimpleTaxRate() {
        return juniorDeveloper.getSalary() * 0.05 ;
    }

    @Override
    public double getMiddleTaxRate() {
        return midDeveloper.getSalary() * 0.10;
    }

    @Override
    public double getUpperTaxRate() {
        return seniorDeveloper.getSalary()* 0.15;
    }
}
