package cn.edu.cqvie.guice;

import cn.edu.cqvie.guice.helloworld.*;
import com.google.inject.AbstractModule;

import java.io.PrintStream;

/**
 * @author ZAKJ_ASUS
 */
public class MainModule extends AbstractModule {

    private String args;

    @Override
    protected void configure() {

        install(new HelloWorldModule());
        install(new PrintLineModule());

//        bind(MyApplet.class).to(StringWritingApplet.class);
//        bind(MyDestination.class).to(PrintStreamWriter.class);
//        bind(PrintStream.class).toInstance(System.out);
//        bind(String.class).toInstance("Hello World!");
        //bind(String.class).toProvider(() -> "Hello World!");
    }

//    @Provides
//    private String getString() {
//        return "Hello World!";
//    }
}
