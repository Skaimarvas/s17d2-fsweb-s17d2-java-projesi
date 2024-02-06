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




    @Override
    public double getSimpleTaxRate() {
        return 99.5 ;
    }

    @Override
    public double getMiddleTaxRate() {
        return 99.0;
    }

    @Override
    public double getUpperTaxRate() {
        return  98.5;
    }
}
