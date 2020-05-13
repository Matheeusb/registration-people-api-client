package br.com.matheus.people.api.configurations;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Environment {

    public String environmentExecution;

    public String getBaseURI(String environment) {
        return selectEnvironment(environment).getBaseURI();
    }

    public int getPort(String environment) {
        return selectEnvironment(environment).getPort();
    }

    private EnvironmentType selectEnvironment(String environment) {
        return EnvironmentType.valueOf(environment.toUpperCase());
    }
}
