package com.beaver.feb171.fruit;

import java.util.List;

public interface FruitMapper {
	public abstract List<Fruit> getAllFruit();
	public abstract List<Fruit> searchFruit(Fruit f);
							//	ㄴ xml ID		ㄴParameter type과 일치 해야함
}	
