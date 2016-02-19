import java.util.Map;

/**
 * Created by Glen on 2/18/2016.
 */
public class RcClass {
	public String myMethod() {
		return "myMethod";
	}
	
	public Map<String, String> testDom() {
		DomObjImpl domObj = new DomObjImpl();
		return domObj.getInfo();
	}
}
