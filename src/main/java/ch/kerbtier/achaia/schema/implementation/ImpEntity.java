package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;

public abstract class ImpEntity implements Entity {
  
  private Entity parent;
  private String name;
  
  public ImpEntity(Entity parent, String name) {
    this.parent = parent;
    this.name = name;
  }
  
  @Override
  public boolean is(Types type) {
    return getType() == type;
  }

  @Override
  public boolean is(Class<?> type) {
    return getType().getJavaType().isAssignableFrom(type);
  }

  @Override
  public Entity getParent() {
    return parent;
  }
  
  @Override
  public String getName() {
    return name;
  }
}
