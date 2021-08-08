package org.astashonok.springsecurity.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {

  DEVELOPERS_READ("developers:read"),
  DEVELOPERS_WRITE("developers:write");

  private final String permission;
}
