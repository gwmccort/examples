package pdm;
import java.util.HashMap;
import java.util.Map;

public class DomObj {

	public String getMessage() {
		return "from DomObj.getMessage";
	}

	public Map<String, String> getMap() {
		Map<String, String> r = new HashMap<>();
		r.put("1", "one");
		return r;
	}

}
