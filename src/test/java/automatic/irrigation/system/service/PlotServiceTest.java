package automatic.irrigation.system.service;

import automatic.irrigation.system.TestHelper;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.mapper.PlotMapper;
import automatic.irrigation.system.repository.PlotRepository;
import automatic.irrigation.system.repository.PlotsSlotsRepository;
import automatic.irrigation.system.repository.SlotRepository;
import automatic.irrigation.system.service.impl.PlotServiceImpl;
import automatic.irrigation.system.service.impl.SlotServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlotServiceTest {


    @InjectMocks
    PlotServiceImpl plotServiceImpl;

    @Mock
    PlotRepository plotRepository;

    @Mock
    PlotMapper plotMapper;

    @Mock
    SlotRepository slotRepository;

    @Mock
    SlotServiceImpl slotServiceImpl;

    @Mock
    PlotsSlotsRepository plotsSlotsRepository;

    @Test
    public void test_create_plot(){
        Plot plot= TestHelper.createPlot();
        when(plotRepository.save(any())).thenReturn(plot);
        Plot plotResponse= plotServiceImpl.createPlot(TestHelper.createPlotequest());
        assertNotNull(plotResponse);
    }

    @Test
    public void test_fetch_plot(){
        List<Plot> plotResponse= plotServiceImpl.listPlots();
        assertNotNull(plotResponse);
    }

 /*   @Test
    public void test_configure_plot(){
        when(plotRepository.findAllById(any())).thenReturn(TestHelper.createPlotList());
        PlotConfigurationResponse plotConfigurationResponse=plotServiceImpl.configurePlot(1l,TestHelper.createPlotConfigurationRequest());

    }*/


}
