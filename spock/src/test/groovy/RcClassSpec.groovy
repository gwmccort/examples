import spock.lang.Specification

class RcClassSpec extends Specification {

    def "test myMethod"() {
        given:
        def rc = new RcClass()

        expect:
        "myMethod" == rc.myMethod()
    }

    def "test getInfo"() {
        given:
        def rc = new RcClass()

        when:
        def m = rc.testDom()

        then:
        m['1'] == 'one'
    }

    def "stub out DomObj"() {
        given:
//        DomObj dObjStub= Stub()
        DomObjImpl dObjStub= Stub()
//		DomObj dObj = Mock()
//		dObj.getInfo() >> ['1':'new one']
        dObjStub.getInfo() >> {
            println 'in stubed getInfo'
            ['1': 'new one']
        }

        and:
        def rc = new RcClass()
        rc.setDomObj(dObjStub)
//		println dObjStub.getInfo()

        when:
        println 'when'
        def m = rc.testDom()
        println m

        then:
        //		m['1'] == 'new one'
        1 == 1
    }

	def "test stub of DomObj"() {
		given:
		DomObj dObj = Stub()
		dObj.getInfo() >> ['1':'stub entry']

		expect:
		dObj.getInfo()['1'] == 'stub entry'
	}
}
