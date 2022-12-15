package entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Oven extends Appliance{
    private int powerConsumption;
    private double weight;
    private double depth;
    private double height;
    private double width;
    private int capacity;
    private double price;
}
