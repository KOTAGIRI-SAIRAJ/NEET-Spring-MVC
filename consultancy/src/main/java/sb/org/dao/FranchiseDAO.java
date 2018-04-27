package sb.org.dao;

import sb.org.model.Franchise;

import java.util.List;

public interface FranchiseDAO {

    public void addFranchise(Franchise franchise);

    public List<Franchise> getAllFranchises();

    public void deleteFranchise(Integer franchiseId);

    public Franchise updateFranchise(Franchise franchise);

    public Franchise getFranchise(int franchiseId);
}
