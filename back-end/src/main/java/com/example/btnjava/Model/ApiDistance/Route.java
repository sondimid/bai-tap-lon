package com.example.btnjava.Model.ApiDistance;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Route {
    private List<Leg> legs;
}
