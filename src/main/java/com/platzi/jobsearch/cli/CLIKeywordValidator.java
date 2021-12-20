package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String s, String s1) throws ParameterException {
        if(!s1.matches( "^[a-zA-Z]+[0-9]*$")) {
            System.err.println("El criterio de busqueda no es válido.");
            throw new ParameterException("Unicamente letras y numeros");
        }
    }
}
