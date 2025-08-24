package nmsproject.nmsorange.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "databases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Database {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "url_address")
    private String urlAddress;

    private int port;

    private String type;

    private String username;

    private String password;

    @Column(name = "current_version")
    private String currentVersion;

    @Column(name = "last_update")
    private String lastUpdate;

    @Column(name = "planned_update")
    private String plannedUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false) // required
    private Application application;
}