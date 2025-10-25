package arsw.components;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import arsw.endpoints.TimerEndpoint;

@Component
public class TimedMessageBroker {
  private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 5000)
  public void tick() {
    TimerEndpoint.broadcast("The time is now " + fmt.format(new Date()));
  }
}