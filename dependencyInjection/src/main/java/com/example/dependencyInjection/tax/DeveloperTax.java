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
        return 0.05 ;
    }

    @Override
    public double getMiddleTaxRate() {
        return 0.10;
    }

    @Override
    public double getUpperTaxRate() {
        return  0.15;
    }
}
