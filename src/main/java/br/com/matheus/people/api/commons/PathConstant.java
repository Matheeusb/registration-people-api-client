package br.com.matheus.people.api.commons;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PathConstant {

    public String PATH = "/people";
    public final String PATH_WITH_ID = "/people/{id}";
    public final String PATH_ACTUATOR = "/actuator/health";
    public final String PATH_PARAM_ID = "id";
}
