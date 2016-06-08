import org.junit.Test
import org.junit.Assert.assertEquals

class TestGreet() {
    @Test
    fun testGreetings() {
        assertEquals("Greeting should be 'Hello World!'",
                "Hello World!", greetings())
    }
}