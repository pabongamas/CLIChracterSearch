package com.platzi.jobsearch;

import java.util.function.Supplier;

import com.beust.jcommander.JCommander;

public class CommanderFunctions {
    static <T> JCommander buildCommanderWithName(
            String cliName, Supplier<T> argumentSupplier) {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get())
                .build();

        jCommander.setProgramName(cliName);
        return jCommander;
    }

}
