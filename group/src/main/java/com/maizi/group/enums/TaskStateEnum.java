package com.maizi.group.enums;

import lombok.Getter;

/**
 * @Author create by fanwenhao
 */
@Getter
public enum TaskStateEnum {

    INIT,

    PROCESS,

    CANCEL,

    EXCEPTION,

    FINISH
    ;

    public static TaskStateEnum of(String name) {
        for (TaskStateEnum stateEnum : TaskStateEnum.values()) {
            if (stateEnum.name().equals(name)) {
                return stateEnum;
            }
        }
        return null;
    }

}
