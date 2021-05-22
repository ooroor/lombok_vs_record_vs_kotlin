package net.barakiroth.lombok_vs_record_vs_kotlin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode
@ToString
public class MySuperClassDto {
    private final int id;
}
