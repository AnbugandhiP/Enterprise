package Interview.MyCar.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Interview.MyCar.Controller.OwnerController;
import Interview.MyCar.Model.CarOwner;
import Interview.MyCar.Service.OwnerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private List<CarOwner> ownerList;

    @BeforeEach
    void setUp() {
        ownerList = Arrays.asList(new CarOwner(1L, "Alice"), new CarOwner(2L, "Bob"));
        when(ownerService.addOwner(anyList())).thenReturn(ownerList);
    }

    @Test
    void testAddOwner() {
        List<CarOwner> result = ownerController.addOwner(ownerList);
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("Bob", result.get(1).getName());
    }
}
