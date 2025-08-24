package nmsproject.nmsorange.Services;

import nmsproject.nmsorange.Entities.Rack;
import nmsproject.nmsorange.Repositories.RackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RackService {

    @Autowired
    private RackRepository rackRepository;

    public Rack addRack(Rack rack) {
        return rackRepository.save(rack);
    }

    public List<Rack> getAllRacks() {
        return rackRepository.findAll();
    }

    public Rack getRackById(Long id) {
        return rackRepository.findById(id).orElse(null);
    }

    public Rack updateRack(Rack rack) {
        return rackRepository.save(rack);
    }

    public void deleteRack(Long id) {
        rackRepository.deleteById(id);
    }
}
