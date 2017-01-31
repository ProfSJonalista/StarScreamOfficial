package domain;

public class PriceList {
    //wypisanie usług z cenami
    //Diagnosis pobiera ceny stąd
	//Każdej czynności dać określoną ilość dni do wykonywania
	//W ten sposób ustalone czekanie na swoje urządzenie
    private int Replace;
    private int Installation;
    private int Building;
    private int Cleaning;
    private int Repairing;

    public int getReplace() {
        return Replace;
    }

    public void setReplace(int replace) {
        Replace = replace;
    }

    public int getInstalation() {
        return Installation;
    }

    public void setInstallation(int installation) {
        Installation = installation;
    }

    public int getBuilding() {
        return Building;
    }

    public void setBuilding(int building) {
        Building = building;
    }

    public int getCleaning() {
        return Cleaning;
    }

    public void setCleaning(int cleaning) {
        Cleaning = cleaning;
    }

    public int getReparing() {
        return Repairing;
    }

    public void setReparing(int repairing) {
        Repairing = repairing;
    }
}
