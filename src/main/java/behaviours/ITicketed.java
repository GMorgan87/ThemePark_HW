package behaviours;

import people.Visitor;

public interface ITicketed {

    double defaultPrice();
    double price(Visitor visitor);
}
