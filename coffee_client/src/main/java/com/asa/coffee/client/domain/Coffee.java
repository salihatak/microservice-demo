package com.asa.coffee.client.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Coffee {

    private String typeName;
    private int hardnessRate;
    private Date productionDate;
}
