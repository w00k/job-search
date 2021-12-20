package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.cli.CLIArguments;

import static com.platzi.jobsearch.cli.CommanderFunctions.buildJCommanderWithName;

public class JobSearch {

    public static void main(String[] args) {
        System.out.println("hello your search");
        JCommander jCommander = buildJCommanderWithName("job-search", CLIArguments::newInstance);;
    }
}
