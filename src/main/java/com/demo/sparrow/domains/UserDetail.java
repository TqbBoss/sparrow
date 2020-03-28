package com.demo.sparrow.domains;

import lombok.Data;
import java.util.List;

@Data
public class UserDetail extends Users {

    private static final long serialVersionUID = -3336347565501949248L;

    private List<Cards> cards;
}