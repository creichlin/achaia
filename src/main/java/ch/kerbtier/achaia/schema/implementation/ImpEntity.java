package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;

public abstract class ImpEntity implements Entity {
  
  private Entity parent;
  private String path;
  
  public ImpEntity(Entity parent, String path) {
    this.parent = parent;
    this.path = path;
  }
  
  @Override
  public boolean is(Type type) {
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
  public String getPath() {
    return path;
  }

  @Override
  public String getName() {
    return path.substring(path.lastIndexOf(".") + 1);
  }
}
