package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultData {
    private String src;
    private String dest;
    private int arrivalTime;
    private double distance;
    private int calorie;

    public ResultData(){}
}
