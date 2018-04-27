package sb.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.org.dao.FranchiseDAOImpl;
import sb.org.model.Franchise;

import java.util.List;

@Service
@Transactional
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    FranchiseDAOImpl franchiseDAO;

    public void addFranchise(Franchise franchise) {
        franchiseDAO.addFranchise(franchise);
    }

    public List<Franchise> getAllFranchises() {

        return franchiseDAO.getAllFranchises();
    }

    public void deleteFranchise(Integer franchiseId) {
        franchiseDAO.deleteFranchise(franchiseId);
    }

    public Franchise updateFranchise(Franchise franchise) {

        return franchiseDAO.updateFranchise(franchise);
    }

    public Franchise getFranchise(int franchiseId) {

        return franchiseDAO.getFranchise(franchiseId);
    }
}
