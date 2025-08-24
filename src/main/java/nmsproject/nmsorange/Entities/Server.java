package nmsproject.nmsorange.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "rack_id")
    private Rack rack;

    private String vendorContact;
    private String supportStatus;
    private String title;
    private String internalOrExternal;
    private LocalDate supportEndOfServiceDate;
}
