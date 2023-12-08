package com.example.stc.test.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class CreateRequestDTO {
    String name;
    String type;
    String group;
    String userEmail;
    String permission;


}
