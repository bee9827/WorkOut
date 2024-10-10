package GraduationProject.WorkOut.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TypeStatus {
    PUSH_UP,
    SQUAT,
    PULL_UP;

    @JsonCreator
    public static TypeStatus from(String s) {
        return TypeStatus.valueOf(s.toUpperCase());
    }
}
