package nmsproject.nmsorange.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatabaseDTO {
    private Long id;
    private String name;
    private String urlAddress;
    private int port;
    private String type;
    private String username;
    private String password;
    private String currentVersion;
    private String lastUpdate;
    private String plannedUpdate;
    private Long applicationId; // maps to Application.id
}