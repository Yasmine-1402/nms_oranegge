package nmsproject.nmsorange.Controllers;


import nmsproject.nmsorange.Entities.Rack;
import nmsproject.nmsorange.Services.RackService;
import nmsproject.nmsorange.dto.RackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/racks")
public class RackController {

    @Autowired
    private RackService rackService;

    @PostMapping
    public Rack addRack(@RequestBody RackDTO dto) {
        Rack rack = new Rack();
        rack.setNumberOfServers(dto.getNumberOfServers());
        rack.setNumberOfPdus(dto.getNumberOfPdus());
        rack.setNumberOfSwitches(dto.getNumberOfSwitches());
        return rackService.addRack(rack);
    }

    @GetMapping
    public List<Rack> getAllRacks() {
        return rackService.getAllRacks();
    }

    @GetMapping("/{id}")
    public Rack getRackById(@PathVariable Long id) {
        return rackService.getRackById(id);
    }

    @PutMapping("/{id}")
    public Rack updateRack(@PathVariable Long id, @RequestBody RackDTO dto) {
        Rack existing = rackService.getRackById(id);
        if (existing != null) {
            existing.setNumberOfServers(dto.getNumberOfServers());
            existing.setNumberOfPdus(dto.getNumberOfPdus());
            existing.setNumberOfSwitches(dto.getNumberOfSwitches());
            return rackService.updateRack(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRack(@PathVariable Long id) {
        rackService.deleteRack(id);
    }
}
