import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class HelloWorldTestWithParameterJUnit {

    //@Parameterized.Parameter(value = 0)
    private String name;

    //@Parameterized.Parameter(value = 1)
    private String expected;

    //Inject with constructor
    public HelloWorldTestWithParameterJUnit(String name, String expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Hello + {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"World", "Hello World"},
                {"User", "Hello User"},
                {"EPAM", "Hello EPAM"},
                {"Test", "Hello Test"}
        });

    }

    @Test
    public void testSayHelloToParameter() {
        assertThat(HelloWorld.sayHelloToParameter(name), is(expected));
    }

}
