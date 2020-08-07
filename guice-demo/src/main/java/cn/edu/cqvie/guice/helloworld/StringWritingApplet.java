package cn.edu.cqvie.guice.helloworld;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author ZAKJ_ASUS
 */
public class StringWritingApplet implements MyApplet {

    private MyDestination destination;
    private Provider<String> stringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,@Output Provider<String> stringProvider) {
        this.destination = destination;
        this.stringProvider = stringProvider;
    }

    private void printHelloWord() {
        destination.write(stringProvider.get());
    }

    @Override
    public void run() {
        printHelloWord();
    }
}
