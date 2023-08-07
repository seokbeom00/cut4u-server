package antmanclub.cut4userver.user.dto.TsDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JoinDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
}
