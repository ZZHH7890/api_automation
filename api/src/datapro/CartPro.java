package datapro;

import org.testng.annotations.DataProvider;

public class CartPro {

  @DataProvider(name ="cart")
  public Object[][] dp() {
    return new Object[][] {
    	{  "13714672775" } 		
    };
  }
}
