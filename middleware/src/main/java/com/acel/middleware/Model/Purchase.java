package com.acel.middleware.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Purchase {
    private Long id;
    private Date date;
    private float amount;
}
