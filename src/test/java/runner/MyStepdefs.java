package runner;

import clientApi.FactoryRequest;
import clientApi.RequestInformation;
import clientApi.ResponseInformation;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static configuration.Configuration.*;


/**
 * @autor: Boris.Perez
 **/
public class MyStepdefs {

    ResponseInformation response = new ResponseInformation();
    Map<String, String> variables = new HashMap<>();

    @Given("^I have authentication to todo\\.ly$")
    public void iHaveAuthenticationToTodoLy() {
    }

    @When("^I send (POST|PUT|DELETE|GET) request '(.*)' with json and (TOKEN|BASIC) authentication$")
    public void iSendRequestApiUserJsonWithJson(String method, String url, String authentication, String jsonBody) {
        RequestInformation request = new RequestInformation();
        request.setUrl(HOST + this.replaceVariables(url));
        request.setBody(this.replaceVariables(jsonBody));
        if (authentication.equals("TOKEN")) {
            request.addHeaders(TOKEN_AUTHENTICATION_HEADER, this.replaceVariables(authentication));
        } else {
            request.addHeaders(BASIC_AUTHENTICATION_HEADER, BASIC_AUTHENTICATION);
        }
        response = FactoryRequest.make(method.toLowerCase()).send(request);
    }

    @Then("^I expected the response code (\\d+)$")
    public void iExpectedTheResponseCode(int expectResponseCode) {
        System.out.println(" Response Code "+ response.getResponseCode());
        Assert.assertEquals("ERROR !! The response code es incorrect", expectResponseCode , response.getResponseCode() );
    }

    private String replaceVariables(String value) {
        for (String key : this.variables.keySet()) {
            value = value.replace(key, this.variables.get(key));
        }
        return value;
    }
}
