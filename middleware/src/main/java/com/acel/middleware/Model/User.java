package com.acel.middleware.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private String surname;
    private String email;
}
