package automatic.irrigation.system.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.TimerTask;


@Slf4j
@Component
public abstract class Scheduler extends TimerTask {

    @Override
    @Scheduled(cron = "0 0/30 * * * * ?")
    public void run() {
        log.info("Current time is :: " + Calendar.getInstance().getTime());
    }

}
