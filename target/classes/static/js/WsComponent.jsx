class WSClient extends React.Component {
  constructor(props) {
    super(props);
    this.state = { status: "Conectando...", last: "" };
  }

  componentDidMount() {
    const scheme = location.protocol === "https:" ? "wss" : "ws";
    this.ws = new WebSocket(`${scheme}://${location.host}/timer`);

    this.ws.onopen = () => this.setState({ status: "Conectado. Esperando mensajes..." });
    this.ws.onmessage = (e) => this.setState({ last: e.data });
    this.ws.onerror = (e) => this.setState({ status: "Error de WebSocket (ver consola)" });
    this.ws.onclose = () => this.setState({ status: "Conexión cerrada" });
  }

  componentWillUnmount() {
    if (this.ws) this.ws.close();
  }

  render() {
    return (
      <div style={{ fontFamily: "system-ui, Arial", padding: 16 }}>
        <h1>The server status is:</h1>
        <p><strong>{this.state.status}</strong></p>
        <p>{this.state.last}</p>
      </div>
    );
  }
}

ReactDOM.render(<WSClient />, document.getElementById("timer"));
