package test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Article {
    private String name;
    private String color;
    private String size;
    private double price;
    private boolean soldOut;

}