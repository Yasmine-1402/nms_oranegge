package nmsproject.nmsorange.Controllers;

import nmsproject.nmsorange.Entities.Rack;
import nmsproject.nmsorange.Entities.Server;
import nmsproject.nmsorange.Repositories.RackRepository;
import nmsproject.nmsorange.Services.ServerService;
import nmsproject.nmsorange.dto.ServerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @Autowired
    private RackRepository rackRepository;

    @PostMapping
    public Server addServer(@RequestBody ServerDTO dto) {
        return serverService.addServer(mapDtoToEntity(dto));
    }

    @GetMapping
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    @GetMapping("/{id}")
    public Server getServerById(@PathVariable Long id) {
        return serverService.getServerById(id);
    }

    @PutMapping("/{id}")
    public Server updateServer(@PathVariable Long id, @RequestBody ServerDTO dto) {
        Server existing = serverService.getServerById(id);
        if (existing != null) {
            Server updated = mapDtoToEntity(dto);
            updated.setId(existing.getId());
            return serverService.updateServer(updated);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
    }

    private Server mapDtoToEntity(ServerDTO dto) {
        Server server = new Server();
        server.setIpAddress(dto.getIpAddress());
        server.setIpType(dto.getIpType());
        server.setOsName(dto.getOsName());
        server.setServerType(dto.getServerType());
        server.setDataCenterName(dto.getDataCenterName());
        server.setXCoord(dto.getXCoord());
        server.setYCoord(dto.getYCoord());
        server.setRoomName(dto.getRoomName());
        server.setBrand(dto.getBrand());

        if (dto.getRackId() != null) {
            Rack rack = rackRepository.findById(dto.getRackId()).orElse(null);
            server.setRack(rack);
        }

        server.setVendorContact(dto.getVendorContact());
        server.setSupportStatus(dto.getSupportStatus());
        server.setTitle(dto.getTitle());
        server.setInternalOrExternal(dto.getInternalOrExternal());

        if (dto.getSupportEndOfServiceDate() != null && !dto.getSupportEndOfServiceDate().isEmpty()) {
            server.setSupportEndOfServiceDate(LocalDate.parse(dto.getSupportEndOfServiceDate()));
        }

        return server;
    }
}

