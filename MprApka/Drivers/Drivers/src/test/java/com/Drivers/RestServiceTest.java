package com.Drivers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RestServiceTest {
    //Test jednostkowy
    @MockBean
    private DriverRepository driverRepository;

    @InjectMocks
    private MyRestService myRestService;

    @Test
    public void testGetData() {
        DriverDTO driverDTO = new DriverDTO("Yuki Tsunoda", LocalDate.parse("2000-05-11"), "AlphaTauri", "Formula 1");
        myRestService.saveDriver(driverDTO);
        verify(driverRepository, times(1)).save(driverDTO);
    }
    //Test selenium

}
