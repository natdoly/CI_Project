package service;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article {
    private int id;
    private String name;
    private String color;
    private String size;
    private double price;
    private boolean soldOut;
    private Float discount;
}
