package net.barakiroth.lombok_vs_record_vs_kotlin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MySubClassDtoTest {

    private static final int ID = 29;
    private static final String NAME1 = "John Doe";
    private static final String NAME2 = "Kari Normann";

    @Test
    void when_set_with_all_fields_then_the_same_field_values_should_be_got() {

        final MySubClassDto mySubClassDto = MySubClassDto.builder().id(ID).name(NAME1).build();

        assertEquals(mySubClassDto.getId(), ID);
        assertEquals(mySubClassDto.getName(), NAME1);
    }

    @Test
    void when_two_instances_with_equal_field_values_are_created_then_thy_should_equal_and_hash_equally() {

        final MySubClassDto mySubClassDto1 = MySubClassDto.builder().id(ID).name(NAME1).build();
        final MySubClassDto mySubClassDto2 = MySubClassDto.builder().id(ID).name(NAME1).build();

        assertEquals(mySubClassDto1.hashCode(), mySubClassDto2.hashCode());
        assertEquals(mySubClassDto1, mySubClassDto2);
    }

    @Test
    void when_serialized_and_deserialized_then_the_source_and_target_should_equal() throws JsonProcessingException {

        final MySubClassDto source = MySubClassDto.builder().id(ID).name(NAME1).build();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String mySubClassDtoAsString = objectMapper.writeValueAsString(source);
        final MySubClassDto target = objectMapper.readValue(mySubClassDtoAsString, MySubClassDto.class);

        assertEquals(source, target);
    }

    @Test
    void when_toString_then_the_string_should_be_as_expected() {

        final MySubClassDto mySubClassDto = MySubClassDto.builder().id(ID).name(NAME1).build();
        final String myRecordDtoAsString =  mySubClassDto.toString();

        assertEquals("MySubClassDto(super=MySuperClassDto(id=" + ID + "), name=" + NAME1 + ")", myRecordDtoAsString);
    }

    @Test
    void when_cloning_changing_one_field_then_the_clone_should_be_as_expecetd() {

        final MySubClassDto mySubClassDtoSource = MySubClassDto.builder().id(ID).name(NAME1).build();
        // Very elegant in case there are many fields
        // Lombok wins this one
        final MySubClassDto mySubClassDtoPartialClone =
                mySubClassDtoSource.toBuilder().name(NAME2).build();

        assertEquals(mySubClassDtoSource.getId(), mySubClassDtoPartialClone.getId());
        assertEquals(mySubClassDtoSource.getName(), NAME1);
        assertEquals(mySubClassDtoPartialClone.getName(), NAME2);
        assertNotEquals(mySubClassDtoSource.getName(), mySubClassDtoPartialClone.getName());
    }
}
