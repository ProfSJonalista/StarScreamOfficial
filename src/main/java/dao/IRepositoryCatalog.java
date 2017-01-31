package dao;

public interface IRepositoryCatalog {
    public IProfileRepository profiles();
    public IRepairRepository repairs();
    public void save();
    public void saveAndClose();
}
