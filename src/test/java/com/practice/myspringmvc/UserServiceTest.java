package com.practice.myspringmvc;

import com.practice.myspringmvc.services.UserManager;
import com.practice.myspringmvc.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    /**
     * testing method to return user count using a mock
     */
    @Test
    public void testThenReturn() {
        //creating mock and then stubbing
        UserManager manager = Mockito.mock(UserManager.class);
        when(manager.getUserCount()).thenReturn(50);

        UserService userService = new UserService(manager);
        Assert.assertEquals(50, userService.getUserCount());
    }

    /**
     * test Method to test exception handling scenario
     * It tests that when exception comes from actual method then -1 is returned
     */
    @Test
    public void testThenThrow() {
        //creating mock
        UserManager manager = Mockito.mock(UserManager.class);
        //stubbing to thrown exception when invoked.
        when(manager.getUserCount()).thenThrow(new RuntimeException());

        UserService userService = new UserService(manager);
        Assert.assertEquals(-1, userService.getUserCount());
    }

    /**
     * This tests various return values from a method. Useful when we want multiple return values
     */
    @Test
    public void testThenAnswer() {
        UserManager manager = Mockito.mock(UserManager.class);
        Mockito.when(manager.getUserCount()).thenAnswer(new Answer() {

            int count = 0;

            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return ++count;
            }
        });

        UserService userService = new UserService(manager);
        Assert.assertEquals(1, userService.getUserCount());
        Assert.assertEquals(2, userService.getUserCount());
        Assert.assertEquals(3, userService.getUserCount());
    }
}
