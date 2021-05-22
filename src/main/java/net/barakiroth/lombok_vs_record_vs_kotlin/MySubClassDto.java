package net.barakiroth.lombok_vs_record_vs_kotlin;

import io.swagger.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@SuperBuilder(toBuilder = true)
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MySubClassDto extends MySuperClassDto {
    @Schema(description = "The name of the thing", example = "Gageter")
    private final String name;
}
