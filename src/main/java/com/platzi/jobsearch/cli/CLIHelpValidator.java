package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIHelpValidator implements IParameterValidator {

    @Override
    public void validate(String s, String s1) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean(s1);
        if(actualValue) {
            throw new ParameterException("Ayuda solicitada");
        }
    }
}
