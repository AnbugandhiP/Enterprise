package Interview.MyCar.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Interview.MyCar.Model.Car;
import Interview.MyCar.Service.CarService;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void testAddCar() {
        // Mock input
        List<Car> cars = Arrays.asList(new Car(1, "Toyota"), new Car(2, "Honda"));
        
        // Mock service behavior
        when(carService.addCars(anyList())).thenReturn(cars);

        // Call method
        List<Car> response = carController.addCar(cars);

        // Validate
        assertEquals(2, response.size());
        assertEquals("Toyota", response.get(0).getName());
    }

    @Test
    void testRemoveCar() {
        // Mock service behavior
        when(carService.removeCar(1)).thenReturn("Car removed");

        // Call method
        String response = carController.removeCar(1);

        // Validate
        assertEquals("Car removed", response);
    }
}
