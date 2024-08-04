package com.mang.grh.Statistiques;

import lombok.*;

@Data
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DemandeAutoStatsDTO {

    private Integer month;
    private String etatdem;
    private long count;



}
