package nmsproject.nmsorange.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)  // name cannot be null
    private String name;

    private String description;

    @Column(name = "added_by_user_id")
    private Long addedByUserId;

    @Column(name = "vendor_id")
    private Long vendorId;
}