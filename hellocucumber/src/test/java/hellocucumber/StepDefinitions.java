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
    Double expectedResult;

    @Given("add rate {string}, {string}, {double}")
    public void add_rate(String string, String string2, Double double1) {
        rates.add(new Rate(string, string2, double1));
    }

    @Given("add wanted {string}, {string}, {double}")
    public void add_wanted(String string, String string2, Double double1) {
        wanted = new Rate(string, string2, double1);
    }

    @Given("expected result {double}")
    public void add_wanted(Double double1) {
        expectedResult = double1;
    }

    @When("solve the problem")
    public void allStepDefinitionsAreImplemented() {
        result =  solveCurrency(rates, wanted);
    }

    @Then("the results match")
    public void theScenarioPasses() {
        assertEquals(expectedResult, result);
    }

}
