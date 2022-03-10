package automatic.irrigation.system;

import automatic.irrigation.system.dto.PlotConfigurationRequest;
import automatic.irrigation.system.dto.PlotRequest;
import automatic.irrigation.system.dto.SlotRequest;
import automatic.irrigation.system.entity.Plot;
import automatic.irrigation.system.entity.PlotSlots;
import automatic.irrigation.system.entity.Slot;
import automatic.irrigation.system.enums.SlotStatus;

import java.time.LocalDateTime;

public class TestHelper {
    public static Plot createPlot() {

        Plot plot= new Plot();
        plot.setPlotName("test");
        plot.setOwnedBy("test");
        plot.setPlotArea(123l);
        return plot;
    }

    public static PlotRequest createPlotequest() {

        PlotRequest plotRequest= new PlotRequest();
        plotRequest.setPlotArea(123l);
        plotRequest.setPlotName("test");
        return  plotRequest;

    }

    public static Slot createSlot() {
        Slot slot= new Slot();
        slot.setIrrigationStartTime(LocalDateTime.now());
        slot.setIrrigationEndTime(LocalDateTime.now().plusMinutes(30));
        return slot;
    }

    public static SlotRequest createSlotRequest() {
        SlotRequest slotRequest=new SlotRequest();
        slotRequest.setIrrigationStartTime(LocalDateTime.now());
        return slotRequest;
    }

    public static PlotConfigurationRequest createPlotConfigurationRequest(){
        PlotConfigurationRequest plotConfigurationRequest=new PlotConfigurationRequest();
        plotConfigurationRequest.setCropName("Wheat");
        plotConfigurationRequest.setSlotId(1l);
        return plotConfigurationRequest;


    }

    public static PlotSlots createPlotSlots() {
        PlotSlots plotSlots= new PlotSlots();
        plotSlots.setSlotStatus(SlotStatus.IRRIGATION_REQUIRED);
        plotSlots.setPlotId(1);
        return plotSlots;
    }
}
