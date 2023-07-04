package antmanclub.cut4userver.user.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinForm {
    private String joinEmail;
    private String joinPassword;
    private String joinConfirmPassword;
    private String joinName;
}
