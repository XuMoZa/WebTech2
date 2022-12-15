package entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teapot extends Appliance{
    private double volumeInLiters;
    private String material;
    private String teaСompartment;
    private int maxTemperature;
    private double price;
}
