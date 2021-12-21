package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;
import com.platzi.jobsearch.dto.JobPosition;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.api.APIFunctions.buildAPI;
import static com.platzi.jobsearch.cli.CommanderFunctions.buildJCommanderWithName;
import static com.platzi.jobsearch.cli.CommanderFunctions.parseArguments;

public class JobSearch {

    public static void main(String[] args) {
        System.out.println("Start job-search");
        JCommander jCommander = buildJCommanderWithName("job-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(object -> (CLIArguments) object);

        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI.filter(cli -> !cli.isHelp())
                .filter(cli -> cli.getKeyword() != null)
                .findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params) {
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");
        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
