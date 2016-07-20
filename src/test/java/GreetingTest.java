import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingTest {

    @Test
    public void shouldGreetBob() {
        assertThat(Greeter.greet("Bob")).isEqualTo("Hello, Bob.");
    }

    @Test
    public void shouldGreetCharles() {
        assertThat(Greeter.greet("Charles")).isEqualTo("Hello, Charles.");
    }

    @Test
    public void shouldGreetNullAsAFriend() {
        assertThat(Greeter.greet(null)).isEqualTo("Hello, my friend.");
    }

    @Test
    public void shouldShoutToUppercaseName() {
        assertThat(Greeter.greet("JERRY")).isEqualTo("HELLO JERRY!");
    }

    @Test
    public void shouldGreetTwoPeople() {
        assertThat(Greeter.greet("Jill", "Jane")).isEqualTo("Hello, Jill and Jane.");
    }

    @Test
    public void shouldGreetThreePeople() {
        assertThat(Greeter.greet("Jill", "Jane", "Barbara")).isEqualTo("Hello, Jill, Jane, and Barbara.");
    }

    @Test
    public void shouldSayAndShoutGreetingsSeparately() {
        assertThat(Greeter.greet("Amy", "BRIAN", "Charlotte")).isEqualTo("Hello, Amy and Charlotte. AND HELLO BRIAN!");
    }
}
