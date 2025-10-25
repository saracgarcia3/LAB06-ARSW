package arsw.endpoints;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/timer")
public class TimerEndpoint {

  private static final Logger logger = Logger.getLogger(TimerEndpoint.class.getName());
  private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

  public static void broadcast(String msg) {
    for (Session s : sessions) {
      if (s.isOpen()) {
        try {
          s.getBasicRemote().sendText(msg);
        } catch (IOException e) {
          logger.log(Level.WARNING, "Error enviando mensaje", e);
        }
      }
    }
  }

  @OnOpen
  public void onOpen(Session session) {
    sessions.add(session);
    try {
      session.getBasicRemote().sendText("Connection established.");
    } catch (IOException e) {
      logger.log(Level.SEVERE, "Error enviando saludo inicial", e);
    }
    logger.log(Level.INFO, "WebSocket abierto: {0}", session.getId());
  }

  @OnClose
  public void onClose(Session session) {
    sessions.remove(session);
    logger.log(Level.INFO, "WebSocket cerrado: {0}", session.getId());
  }

  @OnError
  public void onError(Session session, Throwable t) {
    sessions.remove(session);
    logger.log(Level.WARNING, "Error en WebSocket " + (session != null ? session.getId() : ""), t);
  }

  @OnMessage
  public void onMessage(String message, Session session) {
    logger.info("Mensaje recibido de " + session.getId() + ": " + message);
  }
}
