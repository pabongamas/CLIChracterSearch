package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {
    CLIArguments(){

    }

    private String keyword;
    private String nameCharacter;
    private int page=0;
    private String species;
    private boolean isHelp;

    @Parameter(
        required = true,
        descriptionKey = "KEYWORD",
        description="KEYWORD"
    )
    public String getKeyword() {
        return keyword;
    }
    @Parameter(
        names={"--character","-c"},
        description = "Cada busqueda puede incluir un caracter "
    )
    public String getNameCharacter() {
        return nameCharacter;
    }
    @Parameter(
        names={"--page","-p"},
        description = "La API devuelve 50 resultados , usa un numero para la pagina"
    )
    public int getPage() {
        return page;
    }
    @Parameter(
        names={"--especie"},
        description ="Agregar si queremos buscar por especie"
    )
    public String getSpecies() {
        return species;
    }
    @Parameter(
        names="--help",
        help = true,
        validateWith = CLIHelpValidator.class,
        description = "Mostrar esta ayuda"
    )
    public boolean isHelp() {
        return isHelp;
    }
    @Override
    public String toString() {
        return "CLIArguments [keyword=" + keyword + ", nameCharacter=" + nameCharacter + ", page=" + page + ", species="
                + species + ", isHelp=" + isHelp + "]";
    }
    
    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
    
    

}
