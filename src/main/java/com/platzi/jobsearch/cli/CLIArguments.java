package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeywordValidator.class,
            description = "KEYWORD"
    )
    private String keyword;

    @Parameter(
            names = {"--location", "-l"},
            description = "Cada busqueda puede incluir una ubicación"
    )
    private String location;

    @Parameter(
            names = {"--page", "-p"},
            description = "La API devuelve 50 resultados, usa un numero para la pagina"
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"},
            description = "Agregar si queremos trabajos de tiempo compelto"
    )
    private boolean isFulltime = false;

    @Parameter(
            names = {"--markdown"},
            description = "Obtener los resultados en markdown"
    )
    private boolean isMarkdown = false;

    @Parameter(
            names = {"--help", "-h"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar esta ayuda de CLI"
    )
    private boolean isHelp;

    public CLIArguments() {
    }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFulltime() {
        return isFulltime;
    }

    public boolean isMarkdown() {
        return isMarkdown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFulltime=" + isFulltime +
                ", isMarkdown=" + isMarkdown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }
}
