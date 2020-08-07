package cn.edu.cqvie.guice;

import cn.edu.cqvie.guice.annotaion.Args;
import cn.edu.cqvie.guice.helloworld.Output;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.Arrays;
import java.util.List;

public class CommandLineModule extends AbstractModule {
    private final String[] args;

    public CommandLineModule(String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        super.configure();
    }

    @Provides
    @Args
    public List<String> getCommandLineArgs() {
        return Arrays.asList(args).subList(1, args.length);
    }
}
