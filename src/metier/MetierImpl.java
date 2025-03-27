package metier;

import dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao; //Couplage faible
    // injection des dépendences vie le constructeur
    public MetierImpl(IDao dao){
        this.dao=dao;
    }
    @Override
    public double calcul() {
        double t =dao.getData();
        return t=43/3;
    }
}
