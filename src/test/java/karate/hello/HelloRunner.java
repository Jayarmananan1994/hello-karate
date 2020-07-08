package karate.hello;

import com.intuit.karate.KarateOptions;
import org.junit.runner.RunWith;
import com.intuit.karate.junit4.Karate;

@RunWith(Karate.class)
@KarateOptions(features = "classpath:karate/hello/hello1.feature")
public class HelloRunner {
}