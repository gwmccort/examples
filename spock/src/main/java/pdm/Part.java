package pdm;
import java.util.Map;

public class Part {
	
	DomObj domObj;
	
	public Part(DomObj domObj) {
		super();
		this.domObj = domObj;
	}

	public void setDomObj(DomObj domObj) {
		this.domObj = domObj;
	}

	public String getInfo() {
		return "from getInfo";
	}
	
	public String getPartMessage() {
		return domObj.getMessage();
	}
	
	public Map<String,String> getPartMap() {
		return domObj.getMap();
	}
}
