package net.barakiroth.lombok_vs_record_vs_kotlin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyKotlinDtoTest {

    private static final int ID = 29;
    private static final String NAME1 = "John Doe";
    private static final String NAME2 = "Kari Normann";

    @Test
    void when_set_with_all_fields_then_the_same_field_values_should_be_got() {

        final MyKotlinDto myKotlinDto = new MyKotlinDto(ID, NAME1);

        assertEquals(myKotlinDto.getId(), ID);
        assertEquals(myKotlinDto.getName(), NAME1);
    }

    @Test
    void when_two_instances_with_equal_field_values_are_created_then_thy_should_equal_and_hash_equally() {

        final MyKotlinDto myKotlinDto1 = new MyKotlinDto(ID, NAME1);
        final MyKotlinDto myKotlinDto2 = new MyKotlinDto(ID, NAME1);

        assertEquals(myKotlinDto1.hashCode(), myKotlinDto2.hashCode());
        assertEquals(myKotlinDto1, myKotlinDto2);
    }

    @Test
    void when_serialized_and_deserialized_then_the_source_and_target_should_equal() throws JsonProcessingException {

        final MyKotlinDto source = new MyKotlinDto(ID, NAME1);
        final ObjectMapper objectMapper = new ObjectMapper().registerModule(new KotlinModule());
        final String mySubClassDtoAsString = objectMapper.writeValueAsString(source);
        final MyKotlinDto target = objectMapper.readValue(mySubClassDtoAsString, MyKotlinDto.class);

        assertEquals(source, target);
    }

    @Test
    void when_toString_then_the_string_should_be_as_expected() {

        final MyKotlinDto myKotlinDto = new MyKotlinDto(ID, NAME1);
        final String myKotlinDtoAsString =  myKotlinDto.toString();

        assertEquals("MyKotlinDto(id=" + ID + ", name=" + NAME1 + ")", myKotlinDtoAsString);
    }

    @Test
    void when_cloning_changing_one_field_then_the_clone_should_be_as_expecetd() {

        final MyKotlinDto myKotlinDtoSource = new MyKotlinDto(ID, NAME1);
        // Very cumbersome in case there are many fields, more to be called manual coding
        // Lombok wins this one
        final MyKotlinDto myKotlinDtoPartialClone = new MyKotlinDto(myKotlinDtoSource.getId(), NAME2);

        assertEquals(myKotlinDtoSource.getId(), myKotlinDtoPartialClone.getId());
        assertEquals(myKotlinDtoSource.getName(), NAME1);
        assertEquals(myKotlinDtoPartialClone.getName(), NAME2);
        assertNotEquals(myKotlinDtoSource.getName(), myKotlinDtoPartialClone.getName());
    }
}
