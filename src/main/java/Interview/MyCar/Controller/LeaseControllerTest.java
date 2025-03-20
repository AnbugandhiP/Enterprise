package Interview.MyCar.Controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import Interview.MyCar.Controller.LeaseController;
import Interview.MyCar.Service.LeaseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LeaseControllerTest {

    @Mock
    private LeaseService leaseService;

    @InjectMocks
    private LeaseController leaseController;

    @BeforeEach
    void setUp() {
        when(leaseService.takeLease("John", "Tesla")).thenReturn("Lease taken successfully");
        when(leaseService.removeLease("John", "Tesla", 1234)).thenReturn("Lease removed successfully");
    }

    @Test
    void testTakeLease() {
        String result = leaseController.takeLease("John", "Tesla");
        assertEquals("Lease taken successfully", result);
    }

    @Test
    void testRemoveLease() {
        String result = leaseController.removeLease("John", "Tesla", 1234);
        assertEquals("Lease removed successfully", result);
    }
}
