package com.mang.grh.Statistiques;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor
public class statisticsEmplinsc {

    private int month;
    private int year;
    private long count;

    public statisticsEmplinsc(int year, long count) {
        this.year = year;
        this.count = count;
    }
}
