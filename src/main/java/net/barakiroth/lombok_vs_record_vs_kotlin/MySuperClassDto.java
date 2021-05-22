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
@EqualsAndHashCode
@ToString
public class MySuperClassDto {
    @Schema(description = "Surrogate instance unique identifier", example = "10378465")
    private final int id;
}
