package com.example.njshoppingservice.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Summary {

private UUID id;
private Date date;
private BigDecimal totalCost;
private BigDecimal totalCostApples;
private BigDecimal totalCostOranges;
private int totalApplesOrd;
private int totalOrangesOrd;

public Summary(@JsonProperty("id") UUID id,
@JsonProperty("date") Date date,
@JsonProperty("totalCost")BigDecimal totalCost,
@JsonProperty("totalCostApples")BigDecimal totalCostApples,
@JsonProperty("totalCostOranges")BigDecimal totalCostOranges,
@JsonProperty("totalApplesOrd")int totalApplesOrd,
@JsonProperty("totalOrangesOrd")int totalOrangesOrd){
    this.id = id;
    this.date = date;
    this.totalCost = totalCost;
    this.totalCostApples = totalCostApples;
    this.totalCostOranges = totalCostOranges;
    this.totalApplesOrd = totalApplesOrd;
    this.totalOrangesOrd = totalOrangesOrd;
}

public UUID getId(){
    return id;
}

public void setId(UUID id){
    this.id = id;
}
public Date getDate() {
    return date;
}

public void setDate(Date date) {
    this.date = date;
}

public BigDecimal getTotalCost() {
    return totalCost;
}

public void setTotalCost(BigDecimal totalCost) {
    this.totalCost = totalCost;
}

public BigDecimal getTotalCostApples() {
    return totalCostApples;
}

public void setTotalCostApples(BigDecimal totalCostApples) {
    this.totalCostApples = totalCostApples;
}

public BigDecimal getTotalCostOranges() {
    return totalCostOranges;
}

public void setTotalCostOranges(BigDecimal totalCostOranges) {
    this.totalCostOranges = totalCostOranges;
}

public int getTotalApplesOrd() {
    return totalApplesOrd;
}

public void setTotalApplesOrd(int totalApplesOrd) {
    this.totalApplesOrd = totalApplesOrd;
}

public int getTotalOrangesOrd() {
    return totalOrangesOrd;
}

public void setTotalOrangesOrd(int totalOrangesOrd) {
    this.totalOrangesOrd = totalOrangesOrd;
}
    
}
