import java.util.Map;

/**
 * Created by Glen on 2/18/2016.
 */
public class RcClass {

    private DomObj domObj;

//	public RcClass(DomObj domObj){
//		System.out.println("in RcClass const:" + domObj.getClass().getName());
//		this.domObj = domObj;
//	}

    public String myMethod() {
        return "myMethod";
    }

    public Map<String, String> testDom() {
        DomObjImpl domObj = new DomObjImpl();
        return domObj.getInfo();
    }

    public void setDomObj(DomObj domObj) {
        this.domObj = domObj;
    }
}
