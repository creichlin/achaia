package ch.kerbtier.achaia.schema.implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.ListEntity;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.UndefinedFieldException;

public class ImpMapEntity extends ImpEntity implements MapEntity {

  private Map<String, Entity> map = new HashMap<>();

  public ImpMapEntity(Entity parent, String name) {
    super(parent, name);
  }

  public ImpMapEntity() {
    super(null, "");
  }

  @Override
  public Iterator<String> iterator() {
    return map.keySet().iterator();
  }

  @Override
  public Entity get(String name) {
    
    if(name.length() == 0) {
      return this;
    }
    
    if(name.indexOf(".") != -1) {
      return getByPath(name);
    }
    
    
    Entity e = map.get(name);
    if (e == null) {
      throw new UndefinedFieldException("field " + name + " does not exist in " + this.getName() + " for entity " + getName());
    }
    return e;
  }

  private Entity getByPath(String name) {
    Entity current = this;
    
    for(String part: name.split("\\.")) {
      if(part.equals("_")) {
        current = ((ListEntity)current).get();
      } else {
        current = ((MapEntity)current).get(part);
      }
    }

    return current;
  }

  public void put(String key, Entity type) {
    map.put(key, type);
  }

  @Override
  public Set<String> getProperties() {
    return map.keySet();
  }

  @Override
  public MapEntity getObject(String name) {
    return (MapEntity)get(name);
  }
  
  @Override
  public ListEntity getList(String name) {
    return (ListEntity)get(name);
  }

  @Override
  public Types getType() {
    return Types.MAP;
  }  
}
