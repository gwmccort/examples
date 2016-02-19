import java.util.HashMap;
import java.util.Map;

public class DomObjImpl implements DomObj {

	public Map<String, String> getInfo() {
		Map<String, String> results = new HashMap<>();
		results.put("1", "one");
		return results;
	}

}
