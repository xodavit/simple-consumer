package ru.xodavit.simple.consumer.app.dto;

import lombok.Value;

import java.util.Set;

@Value
public class SimpleRequestDto {
  long id;
  String name;
  Set<String> tags;
}
