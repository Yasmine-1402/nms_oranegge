package nmsproject.nmsorange.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RackDTO {
    private Long id;
    private Integer numberOfServers;
    private Integer numberOfPdus;
    private Integer numberOfSwitches;
}
