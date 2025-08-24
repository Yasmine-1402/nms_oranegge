package nmsproject.nmsorange.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfServers;
    private Integer numberOfPdus;
    private Integer numberOfSwitches;

    @OneToMany(mappedBy = "rack", cascade = CascadeType.ALL)
    private List<Server> servers;
}
