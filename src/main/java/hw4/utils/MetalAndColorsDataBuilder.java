package hw4.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class MetalAndColorsDataBuilder {
    private List<String> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetable;
}

