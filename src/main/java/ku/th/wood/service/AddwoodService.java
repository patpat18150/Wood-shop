package ku.th.wood.service;
import ku.th.wood.data.WoodRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ku.th.wood.model.*;

import java.util.List;

@Service
public class AddwoodService {
    private WoodRepository repository;

    public AddwoodService(WoodRepository repository) {
        this.repository = repository;
    }

    public List<Wood> woodInStock(String woodname){
        List<Wood> wood = repository.findByWoodName(woodname);
        return wood;
    }
    public void createWood(Wood wood) {
        repository.saveWood(wood);
    }
    public Wood findWood(String woodId){
        try {
            return repository.findByWoodId(woodId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public void deleteWoodByWoodId(String woodId){
        System.out.println("try to delete wood Id" + woodId + " ");
        repository.deleteByWoodId(woodId);
    }
    public List<Wood> getWoods() {
        return repository.findAllwood();
    }
}
