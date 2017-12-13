package ap.appoty.viktorsegers.jonaskoppen.resistorcalculator;

import java.util.List;

/**
 * Created by Viktor on 13-12-2017.
 */

public class CalculatorDummyRepository implements ICalculatorRepository{

    private static ICalculatorRepository repo = null;

    public static ICalculatorRepository getInstance() {
        if (repo == null) {
            repo = new CalculatorDummyRepository() {

            };
        }
        return repo;
    }

    public List<Calculater> getCalculater(){

    }

}
