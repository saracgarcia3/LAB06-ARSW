package arsw;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class WebController {

  @GetMapping("/status")
  public Map<String, Object> status() {
    Map<String, Object> out = new LinkedHashMap<>();
    out.put("status", "Greetings from Spring Boot. The server is Running!");
    out.put("date", LocalDate.now().toString());
    out.put("time", LocalTime.now().toString());
    return out;
  }
}
