import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HelloWorldTestEasyMock {
    private HelloWorld helloWorld;

    @Before
    public void setUp() throws Exception {
        helloWorld = EasyMock.createMock(HelloWorld.class);
    }

    @After
    public void tearDown() throws Exception {
        helloWorld = null;
    }

    @Test
    public void testPrintHelloWorld(){
        //given
        HelloWorldService helloWorldService = new HelloWorldService();
        EasyMock.expect(helloWorld.printHelloWorld()).andReturn("Hello World!");
        EasyMock.replay(helloWorld);

        //when
        String result = helloWorldService.getHelloWord(helloWorld);

        //then
        assertEquals("Hello World!",result);
        EasyMock.verify(helloWorld);
    }

}
