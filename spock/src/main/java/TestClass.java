import java.util.Map;

public class TestClass {
	
	StubClass sc;
	
	public void setSc(StubClass sc) {
		this.sc = sc;
	}

	public String getInfo() {
		return "from getInfo";
	}
	
	public String getStubClassInfo() {
		return sc.getMessage();
	}
	
	public Map<String,String> getStubClassMap() {
		return sc.getMap();
	}
}
