package com.platzi.jobsearch.cli;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunctions {

    public static <T> JCommander buildJCommanderWithName(String cliname, Supplier<T> argumentSupplier) {
        JCommander jCommander = new JCommander().newBuilder().addCommand(argumentSupplier.get()).build();
        jCommander.setProgramName(cliname);
        return jCommander;
    }
}
