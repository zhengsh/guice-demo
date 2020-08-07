package cn.edu.cqvie.guice;

import cn.edu.cqvie.guice.helloworld.MyApplet;
import cn.edu.cqvie.guice.helloworld.PrintStreamWriter;
import cn.edu.cqvie.guice.helloworld.StringWritingApplet;

/**
 * @author ZAKJ_ASUS
 */
public class Configuration {

    public static MyApplet getMainApplet() {
        return new StringWritingApplet(
                new PrintStreamWriter(System.out),
                () -> "Hello World!");
    }
}
