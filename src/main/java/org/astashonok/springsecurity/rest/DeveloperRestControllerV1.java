package org.astashonok.springsecurity.rest;

import java.util.Arrays;
import java.util.List;
import org.astashonok.springsecurity.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestControllerV1 {

  private List<Developer> developers = Arrays.asList(
      new Developer(1L, "Ivan", "Ivanov"),
      new Developer(2L, "Petr", "Petrov"),
      new Developer(3L, "Srge", "Sergeev")
  );

  @GetMapping
  public List<Developer> getAll() {
    return developers;
  }

  @GetMapping("/{id}")
  public Developer getAll(@PathVariable Long id) {
    return id == null
        ? null
        : developers.stream()
            .filter(developer -> id.equals(developer.getId()))
            .findFirst()
            .orElse(null);
  }
}
