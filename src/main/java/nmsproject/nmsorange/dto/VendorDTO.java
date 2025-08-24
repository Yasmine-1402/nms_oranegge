package nmsproject.nmsorange.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDTO {

    private Long id;

    @NotBlank(message = "Vendor name is required")
    private String name;

    private String portalTicketingSystem;
    private String portalUsername;
    private String portalPassword;

    @NotBlank(message = "Main contact name is required")
    private String mainContactName;

    @Email(message = "Main contact email should be valid")
    @NotBlank(message = "Main contact email is required")
    private String mainContactEmail;

    @Pattern(regexp = "^[+]?[0-9\\s\\-()]{10,}$", message = "Main contact mobile should be valid")
    private String mainContactMobile;

    private String escalationLevel1ContactName;

    @Email(message = "Escalation level 1 contact email should be valid")
    private String escalationLevel1ContactEmail;

    @Pattern(regexp = "^[+]?[0-9\\s\\-()]{10,}$", message = "Escalation level 1 contact mobile should be valid")
    private String escalationLevel1ContactMobile;

    private String escalationLevel2ContactName;

    @Email(message = "Escalation level 2 contact email should be valid")
    private String escalationLevel2ContactEmail;

    @Pattern(regexp = "^[+]?[0-9\\s\\-()]{10,}$", message = "Escalation level 2 contact mobile should be valid")
    private String escalationLevel2ContactMobile;
}
