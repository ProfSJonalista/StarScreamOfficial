package dao;

import domain.Profile;
import domain.Repair;

import java.util.List;

public interface IRepairRepository extends IRepository<Repair>{
    public List<Repair> byProfile(Profile profile);
}
