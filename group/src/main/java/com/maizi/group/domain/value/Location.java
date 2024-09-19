package com.maizi.group.domain.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;
}
