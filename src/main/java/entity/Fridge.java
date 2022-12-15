package entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Fridge extends Appliance{
    private String manufacturer;
    private String construction;
    private int height;
    private int width;
    private String color;
    private String energyConsumptionClass;
    private double price;
}
