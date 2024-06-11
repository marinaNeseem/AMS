package com.AMS.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.AMS.Enums.Type;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String user_name;
    private String email;
    private String password;
    private Type type;
}
