package com.example.avatarcreator.endpoint;

import com.example.avatarcreator.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserEndPoint {

    String BASE = "user";

    String REGISTER = "usr-add";

    String GETALL = "all";

    String UPDATE = "update/{id}/";

    String DELETE = "delete/{id}/";

}
