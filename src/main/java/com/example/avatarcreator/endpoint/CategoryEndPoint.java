package com.example.avatarcreator.endpoint;

public interface CategoryEndPoint {
    String BASE = "category";

    String REGISTER = "ctg-add";

    String GETALL = "all";

    String UPDATE = "update/{id}/";

    String DELETE = "delete/{id}/";
}
