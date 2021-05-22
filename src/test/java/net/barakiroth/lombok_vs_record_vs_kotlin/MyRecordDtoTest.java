package net.barakiroth.lombok_vs_record_vs_kotlin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyRecordDtoTest {

    private static final int ID = 29;
    private static final String NAME1 = "John Doe";
    private static final String NAME2 = "Kari Normann";

    @Test
    void when_set_with_all_fields_then_the_same_field_values_should_be_got() {

        final MyRecordDto myRecordDto = new MyRecordDto(ID, NAME1);

        assertEquals(myRecordDto.id(), ID);
        assertEquals(myRecordDto.name(), NAME1);
    }

    @Test
    void when_two_instances_with_equal_field_values_are_created_then_thy_should_equal_and_hash_equally() {

        final MyRecordDto myRecordDto1 = new MyRecordDto(ID, NAME1);
        final MyRecordDto myRecordDto2 = new MyRecordDto(ID, NAME1);

        assertEquals(myRecordDto1.hashCode(), myRecordDto2.hashCode());
        assertEquals(myRecordDto1, myRecordDto2);
    }

    @Test
    void when_serialized_and_deserialized_then_the_source_and_target_should_equal() throws JsonProcessingException {

        final MyRecordDto source = new MyRecordDto(ID, NAME1);
        final ObjectMapper objectMapper = new ObjectMapper();
        final String myRecordAsString = objectMapper.writeValueAsString(source);
        final MyRecordDto target = objectMapper.readValue(myRecordAsString, MyRecordDto.class);

        assertEquals(source, target);
    }

    @Test
    void when_toString_then_the_string_should_be_as_expected() {

        final MyRecordDto myRecordDto = new MyRecordDto(ID, NAME1);
        final String myRecordAsString = myRecordDto.toString();

        assertEquals("MyRecordDto[id=" + ID + ", name=" + NAME1 + "]", myRecordAsString);
    }

    @Test
    void when_cloning_changing_one_field_then_the_clone_should_be_as_expecetd() {

        final MyRecordDto myRecordDtoSource = new MyRecordDto(ID, NAME1);
        // Very cumbersome in case there are many fields, more to be called manual coding
        // Lombok wins this one
        final MyRecordDto myRecordDtoPartialClone = new MyRecordDto(myRecordDtoSource.id(), NAME2);

        assertEquals(myRecordDtoSource.id(), myRecordDtoPartialClone.id());
        assertEquals(myRecordDtoSource.name(), NAME1);
        assertEquals(myRecordDtoPartialClone.name(), NAME2);
        assertNotEquals(myRecordDtoSource.name(), myRecordDtoPartialClone.name());
    }
}