package test.testnggroups;

import org.testng.annotations.Test;

public class Login {

    @Test(groups = {"smoke", "regression"})
    public void LoginWithValidCredentials() {
        System.out.println(this.getClass().getSimpleName() + " - LoginWithValidCredentials");
    }

    @Test(groups = {"regression"})
    public void checkGeneralUI() {
        System.out.println(this.getClass().getSimpleName() + " - checkGeneralUI");
    }
}
