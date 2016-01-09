package ch.kerbtier.archaia;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ch.kerbtier.achaia.Parse;
import ch.kerbtier.achaia.Types;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.IntegerEntity;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.SlugEntity;
import ch.kerbtier.achaia.schema.StringEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;

public class BasicEntity {
  
  private MapEntity root;
  
  @Before
  public void init() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get("src/test/resources", "post.model"))
  }
  
  @Test()
  public void checkStringType() {
    assertTrue(root["post"]["title"] instanceof StringEntity)
  }
  
  @Test()
  public void checkSlugType() {
    assertTrue(root["post"]["slug"] instanceof SlugEntity)
  }
  
  @Test()
  public void checkIntegerType() {
    assertTrue(root["post"]["count"] instanceof IntegerEntity)
  }
  

  @Test()
  public void checkExistingMapType() {
    Entity entity = root["post"]
    assertTrue(entity instanceof MapEntity)
  }

  @Test()
  public void checkExistingMapTypeWithIsForJavaType() {
    Entity entity = root["post"]
    assertTrue(entity.is(Map.class))
  }
  
  @Test()
  public void checkExistingMapTypeWithIsForArchaiaType() {
    Entity entity = root["post"]
    assertTrue(entity.is(Types.MAP))
  }
  
  @Test()
  public void checkPostName() {
    assertEquals("post", root["post"].name)
  }
  
  @Test()
  public void checkCommentName() {
    assertEquals("post.comments", root["post"]["comments"].name)
  }
  
  @Test()
  public void checkCommentItemName() {
    assertEquals("post.comments._", root["post"]["comments"].get().name)
  }
  
  @Test()
  public void checkCommentFieldName() {
    assertEquals("post.comments._.email", root["post"]["comments"].object["email"].name)
  }
  
  @Test()
  public void checkHitsList() {
    assertEquals("post.hits", root["post"]["hits"].name)
  }

  @Test()
  public void checkHitsField() {
    assertEquals("post.hits._", root["post"]["hits"].get().name)
  }
}

