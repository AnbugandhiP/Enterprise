package Interview.MyCar.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Interview.MyCar.Controller.UserController;
import Interview.MyCar.Model.EndUser;
import Interview.MyCar.Service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private List<EndUser> userList;

    @BeforeEach
    void setUp() {
        userList = Arrays.asList(new EndUser(1L, "John"), new EndUser(2L, "Doe"));
        when(userService.addUser(anyList())).thenReturn(userList);
    }

    @Test
    void testAddUser() {
        List<EndUser> result = userController.addUser(userList);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Doe", result.get(1).getName());
    }
}
