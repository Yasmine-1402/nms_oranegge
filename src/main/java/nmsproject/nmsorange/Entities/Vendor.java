package nmsproject.nmsorange.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vendors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "portal_ticketing_system")
    private String portalTicketingSystem;

    @Column(name = "portal_username")
    private String portalUsername;

    @Column(name = "portal_password")
    private String portalPassword;

    @Column(name = "main_contact_name")
    private String mainContactName;

    @Column(name = "main_contact_email")
    private String mainContactEmail;

    @Column(name = "main_contact_mobile")
    private String mainContactMobile;

    @Column(name = "escalation_level_1_contact_name")
    private String escalationLevel1ContactName;

    @Column(name = "escalation_level_1_contact_email")
    private String escalationLevel1ContactEmail;

    @Column(name = "escalation_level_1_contact_mobile")
    private String escalationLevel1ContactMobile;

    @Column(name = "escalation_level_2_contact_name")
    private String escalationLevel2ContactName;

    @Column(name = "escalation_level_2_contact_email")
    private String escalationLevel2ContactEmail;

    @Column(name = "escalation_level_2_contact_mobile")
    private String escalationLevel2ContactMobile;

    // One-to-Many relationship with KnowledgeBase
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<KnowledgeBase> knowledgeBases;
}
