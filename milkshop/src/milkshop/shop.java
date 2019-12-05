package milkshop;

import milkshop.Ingredient;

import java.util.*;

public interface shop {
    public abstract void addIngredient(Ingredient ingredient);
    public abstract void soldMilkTea(MilkTea milktea, Calendar date)   throws SoldOutException;
}
