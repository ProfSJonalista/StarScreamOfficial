package dao;

import domain.Profile;

import java.util.List;

public interface IProfileRepository
        extends IRepository<Profile>{

    public List<Profile> withName(String name);
}
