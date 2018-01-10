import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HelloWorldTestWithParameterTestNG {

    @DataProvider(name = "provideNames")
    public Object[][] provideData() {
        return new Object[][] {
                {"World", "Hello World"},
                {"User", "Hello User"},
                {"EPAM", "Hello EPAM"},
                {"Test", "Hello Test"}
        };
    }

    @Test(dataProvider = "provideNames")
    public void testSayHelloToParameter(String name, String expected) {
        Assert.assertEquals(HelloWorld.sayHelloToParameter(name), expected);
    }
}
