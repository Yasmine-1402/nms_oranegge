package nmsproject.nmsorange.Services;



import nmsproject.nmsorange.Entities.Server;
import nmsproject.nmsorange.Repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;


    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Server getServerById(Long id) {
        return serverRepository.findById(id).orElse(null);
    }

    public Server updateServer(Server server) {
        return serverRepository.save(server);
    }

    public void deleteServer(Long id) {
        serverRepository.deleteById(id);
    }

    public Server addServer(Server server) {
        return serverRepository.save(server);
    }
}

