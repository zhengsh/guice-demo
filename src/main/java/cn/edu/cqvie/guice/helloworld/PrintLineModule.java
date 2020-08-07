package cn.edu.cqvie.guice.helloworld;

import cn.edu.cqvie.guice.Applets;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class PrintLineModule extends AbstractModule {
    @Override
    protected void configure() {
        //bind(MyApplet.class).annotatedWith(Names.named("println")).to(PrintLineApplet.class);
        Applets.register(binder()).named("println").to(PrintLineApplet.class);

    }
}
