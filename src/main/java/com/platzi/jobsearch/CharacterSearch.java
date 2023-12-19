package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.CommanderFunctions.*;

public class CharacterSearch {
    public static void main(String[] args) {
        JCommander jCommander =CommanderFunctions.buildCommanderWithName("Character-Search",CLIArguments::newInstance);
        System.out.println(jCommander);
    }
}
