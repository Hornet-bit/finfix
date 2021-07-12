package by.birukov.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class UserPreferences implements Serializable {
    private String username;
//    private Set<String> fandoms;
    private List<String> fandoms;
}
