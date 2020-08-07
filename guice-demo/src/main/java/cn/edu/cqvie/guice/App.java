package cn.edu.cqvie.guice;

import cn.edu.cqvie.guice.helloworld.MyApplet;
import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.Map;

public class App {

    public static void main(String[] args) {
//        MyApplet mainApplet = Configuration.getMainApplet();
//        mainApplet.run();;

        Injector injector = Guice.createInjector(new MainModule(), new CommandLineModule(args));
        Applets.get(injector, args[0]).run();
    }
}
