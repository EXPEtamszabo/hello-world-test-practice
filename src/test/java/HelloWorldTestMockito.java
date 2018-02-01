import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

public class HelloWorldTestMockito {
    private HelloWorld helloWorld;

    @Before
    public void setUp(){
        helloWorld = mock(HelloWorld.class);
    }

    @Test
    public void testPrintHelloWorldMockito(){
        //given
        HelloWorldService helloWorldService = new HelloWorldService();
        when(helloWorld.printHelloWorld()).thenReturn("Hello World!");

        //when
        String result = helloWorldService.getHelloWord(helloWorld);

        //then
        assertEquals("Hello World!", result );
        verify(helloWorld);

    }
    
    @Test
    public void testThenAnswer() {
        HelloWorldService helloWorldService = new HelloWorldService();

        Mockito.when(helloWorld.printHelloWorld()).thenAnswer(new Answer() {
            public int count = 0;
            public String[] names = {"Hello User1", "Hello User2", "Hello User3"};

            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return names[count++];
            }
        });

        assertEquals("Hello User1", helloWorldService.getHelloWord(helloWorld));
        assertEquals("Hello User2", helloWorldService.getHelloWord(helloWorld));
        assertEquals("Hello User3", helloWorldService.getHelloWord(helloWorld));
    }
}
