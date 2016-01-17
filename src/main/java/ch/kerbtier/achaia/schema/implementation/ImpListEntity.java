package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.ListEntity;
import ch.kerbtier.achaia.schema.MapEntity;

public class ImpListEntity extends ImpEntity implements ListEntity {

  public ImpListEntity(Entity parent, String path) {
    super(parent, path);
  }

  private Entity type;
  
  @Override
  public Entity get() {
    return type;
  }

  public void setType(ImpEntity type) {
    this.type = type;
  }

  @Override
  public MapEntity getObject() {
    return (MapEntity)type;
  }

  @Override
  public ListEntity getList() {
    return (ListEntity)type;
  }

  @Override
  public Type getType() {
    return Type.LIST;
  }

}
