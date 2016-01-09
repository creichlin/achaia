package ch.kerbtier.achaia.schema.implementation;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.ListEntity;
import ch.kerbtier.achaia.schema.MapEntity;

public class ImpListEntity extends ImpEntity implements ListEntity {

  public ImpListEntity(Entity parent, String name) {
    super(parent, name);
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
  public Types getType() {
    return Types.LIST;
  }

}
