package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getHeight() > 145 && visitor.getAge() > 11;
    }

    @Override
    public double defaultPrice() {
        return 8.40;
    }

    @Override
    public double price(Visitor visitor) {
        if (visitor.getHeight()>20){
            return defaultPrice()*2;
        }
        return defaultPrice();
    }
}
