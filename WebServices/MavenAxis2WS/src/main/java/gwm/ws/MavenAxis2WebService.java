package gwm.ws;

public class MavenAxis2WebService {
  public String ping(String text) {
    if (text == null) {
      return "Service is up and available";
    }
    return "Service is up and available, message: " + text;
  }
}
