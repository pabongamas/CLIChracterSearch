package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.ApiJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.CommanderFunctions.*;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunctions.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunctions.parseArguments;
import static com.platzi.jobsearch.api.APIFunctions.buildAPI;

public class CharacterSearch {
    public static void main(String[] args) {
        JCommander jCommander =buildCommanderWithName("Character-Search",CLIArguments::newInstance);

        Stream<CLIArguments> streamOFCli=parseArguments(jCommander,args,JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map(obj->(CLIArguments) obj);

        Optional<CLIArguments> cliArgumentsOptional=streamOFCli.filter(cli->!cli.isHelp()).filter(cli->cli.getKeyword()!=null).findFirst();

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(CharacterSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<Character> executeRequest(Map<String,Object> params){
        ApiJobs api=buildAPI(ApiJobs.class,"https://rickandmortyapi.com/api/");

        return Stream.of(params)
                .map(api::character)
                .flatMap(Collection::stream);
    }
}
