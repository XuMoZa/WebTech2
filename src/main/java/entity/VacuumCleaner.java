package entity;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VacuumCleaner extends Appliance{
    private String type;
    private int suctionPower;
    private String pipeLength;
    private String powerAdjustment;
    private double price;
}
