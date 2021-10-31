package com.softtech.microservice.limitservice.dto;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

/**
 * Created by N.Bimeri on 06/08/2021.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limit {
    private int minimum;
    private  int maximum;
}
