package hellocucumber;

import io.cucumber.java.en.*;
import currency.Rate;
import currency.Currency;
import static currency.Main.solveCurrency;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class StepDefinitions {
    ArrayList<Rate> rates = new ArrayList<Rate>();
    Rate wanted;
    Double result;

    @Given("currency rate {string} to {string} is {double}")
    @And("{string} to {string} is {double}")
    public void add_rate(String string, String string2, Double double1) {
        rates.add(new Rate(string, string2, double1));
    }
    @When("we want {double} {string} to be converted to {string}")
    public void allStepDefinitionsAreImplemented(Double double1, String string, String string2) {
        wanted = new Rate(string, string2, double1);
        result =  solveCurrency(rates, wanted);
    }
    @Then("the result should be {double}")
    public void theScenarioPasses(Double double1) {
        assertEquals(double1, result);
    }
}
