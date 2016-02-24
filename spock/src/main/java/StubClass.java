import java.util.HashMap;
import java.util.Map;

public class StubClass {

	public String getMessage() {
		return "from StubClass.getMessage";
	}

	public Map<String, String> getMap() {
		Map<String, String> r = new HashMap<>();
		r.put("1", "one");
		return r;
	}

}
