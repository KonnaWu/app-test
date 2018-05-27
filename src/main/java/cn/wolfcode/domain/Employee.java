package cn.wolfcode.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    public static final int USER_TYPE_ADMIN = 1;
    public static final int USER_TYPE_GENERAL = 0;

    public static final int USER_STATE_NORMAL = 0;
    public static final int USER_STATE_LOCKED = 1;

    private Long id;
    private String username;
    private String password;
    private int state = USER_STATE_NORMAL;
    private int admin = USER_TYPE_GENERAL;
}
