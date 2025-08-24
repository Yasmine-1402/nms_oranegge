package nmsproject.nmsorange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerDTO {
    private Long id;
    private String ipAddress;
    private String ipType;
    private String osName;
    private String serverType;
    private String dataCenterName;
    private Integer xCoord;
    private Integer yCoord;
    private String roomName;
    private String brand;
    private Long rackId;
    private String vendorContact;
    private String supportStatus;
    private String title;
    private String internalOrExternal;
    private String supportEndOfServiceDate; // format YYYY-MM-DD
}
