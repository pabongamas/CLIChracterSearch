package com.platzi.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CLIFunctions {

    public static Map<String,Object> toMap(CLIArguments cliArguments){
        Map<String,Object> params=new HashMap<>();
        params.put("species",cliArguments.getSpecies());
        params.put("name",cliArguments.getNameCharacter());
        params.put("page",cliArguments.getPage());

        return  params;
    }
}
