package br.com.matheus.people.api.configurations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnvironmentType {

    DEV("http://localhost", 8080),
    HOMOLOG("http://localhost", 8080);

    private String baseURI;
    private int port;

}
