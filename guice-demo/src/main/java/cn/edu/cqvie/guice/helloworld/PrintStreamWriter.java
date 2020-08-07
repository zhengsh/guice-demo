package cn.edu.cqvie.guice.helloworld;

import com.google.inject.Inject;

import java.io.PrintStream;

/**
 * @author ZAKJ_ASUS
 */
public class PrintStreamWriter implements  MyDestination {
    private PrintStream destination;

    @Inject
    public PrintStreamWriter(PrintStream destination) {
        this.destination = destination;
    }

    @Override
    public void write(String s) {
        destination.println(s);
    }
}
