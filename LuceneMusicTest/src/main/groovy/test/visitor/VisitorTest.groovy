package test.visitor;
/**
 * http://groovy-lang.org/design-patterns.html#_visitor_pattern
 * @author gwmccort
 *
 */
public class VisitorTest {

	public static void main(String[] args) {

		NodeType1 root = new NodeType1()
		root.children = new Visitable[2];
		root.children[0] = new NodeType1();
		root.children[1] = new NodeType2();

		def ntc = new NodeType1Counter()

	}

}

class DefaultVisitor {
    void visit(Visitable v) {
        doIteraton(v)
    }
    void doIteraton(Visitable v) {
        v.children.each {
            visit(it)
        }
    }
}

interface Visitable {
    Visitable[] getChildren()
}

class NodeType1 implements Visitable {
    Visitable[] children = []
}

class NodeType2 implements Visitable {
    Visitable[] children = []
}

class NodeType1Counter extends DefaultVisitor {
    int count = 0
    void visit(NodeType1 n1) {
        count++
        super.visit(n1)
    }
}
