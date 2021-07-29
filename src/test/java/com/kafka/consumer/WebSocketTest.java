package com.kafka.consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.kafka.consumer.config.WebSocketConfigTest;
import io.restassured.RestAssured;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class WebSocketTest extends WebSocketConfigTest {

  String STOMP_URL = "ws://localhost:";

  @LocalServerPort
  int port;

  @BeforeEach
  void setUp() {
    RestAssured.port = port;
    STOMP_URL = STOMP_URL + port + "/ws";
  }

  @DisplayName("Stomp Socket 연결 테스트")
  @Test
  public void websocketConnectionTest() {

    // given // when
    final StompSession session = getStompSession();

    // then
    assertAll(
      () -> assertThat(session).isNotNull(),
      () -> assertThat(session.isConnected()).isTrue()
    );
  }

  private StompSession getStompSession() {
    WebSocketStompClient webSocketStompClient = new WebSocketStompClient(new SockJsClient(createTransport()));

    StompSessionHandler stompSessionHandler
    return webSocketStompClient
      .connect(STOMP_URL, new StompSessionHandler() {
      })

  }

  private List<Transport> createTransport() {
    List<Transport> transports = new ArrayList<>();
    transports.add(new WebSocketTransport(new StandardWebSocketClient()));
    return transports;
  }


}
