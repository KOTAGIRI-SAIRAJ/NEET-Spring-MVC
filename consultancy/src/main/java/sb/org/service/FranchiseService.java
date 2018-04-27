package sb.org.service;

import sb.org.model.Franchise;

import java.util.List;

public interface FranchiseService {

    public void addFranchise(Franchise franchise);

    public List<Franchise> getAllFranchises();

    public void deleteFranchise(Integer franchiseId);

    public Franchise updateFranchise(Franchise franchise);

    public Franchise getFranchise(int franchiseId);

}
