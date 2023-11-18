package com.vuluong.designpattern.builder.hierarchies;

import static com.vuluong.designpattern.builder.hierarchies.NyPizza.Size.SMALL;
import static com.vuluong.designpattern.builder.hierarchies.Pizza.Topping.*;

public class PizzaApplication {

    public static void main(String[] args) {
        NyPizza nyPizza = NyPizza.builder(SMALL)
            .addTopping(SAUSAGE)
            .addTopping(ONION)
            .build();
        
        Calzone calzone = Calzone.builder()
            .addTopping(HAM)
            .sauceInside()
            .build();
    }
}
