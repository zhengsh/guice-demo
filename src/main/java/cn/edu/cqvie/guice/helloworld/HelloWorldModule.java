package cn.edu.cqvie.guice.helloworld;

import cn.edu.cqvie.guice.Applets;
import cn.edu.cqvie.guice.annotaion.Args;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import javafx.beans.binding.MapBinding;

import java.io.PrintStream;
import java.util.List;

/**
 * @author ZAKJ_ASUS
 */
public class HelloWorldModule extends AbstractModule {


    @Override
    protected void configure() {

       /* MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
                .addBinding("hello").to(StringWritingApplet.class);*/

        Applets.register(binder()).named("hello").to(StringWritingApplet.class);

        //bind(MyApplet.class).annotatedWith(Names.named("hello")).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        //bind(String.class).annotatedWith(Output.class).toInstance("Hello World!");
    }

    @Provides @Output String getOutputString(@Args List<String> args) {
        return args.get(0);
    }
}
