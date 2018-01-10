import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HelloWorld.class})
public class HelloWorldTestPowerMock {


    @Test
    public void testMockPrivateMethod() throws Exception {
        //given
        HelloWorld spy = spy(new HelloWorld());
        when(spy, method(HelloWorld.class, "printPrivateMessage")).withNoArguments().thenReturn("Hello World!");

        //when
        String result = spy.getPrivateMessage();

        //then
        assertEquals("Hello World!", result);
    }
}
