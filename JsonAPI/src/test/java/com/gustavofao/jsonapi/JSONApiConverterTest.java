package com.gustavofao.jsonapi;

import com.gustavofao.jsonapi.Models.JSONApiObject;
import com.gustavofao.jsonapi.Models.Links;
import com.gustavofao.jsonapi.testmodels.*;
import com.gustavofao.jsonapi.testutils.FileLoader;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class JSONApiConverterTest {

    private JSONApiConverter subject;
    private FileLoader fileLoader = new FileLoader();

    @Before
    public void setUp() {
        subject = new JSONApiConverter(
                City.class,
                User.class,
                Person.class,
                Conversation.class,
                InvalidResource.class
        );
    }

    @Test
    public void fromJson_shouldSucceed() {
        String json = fileLoader.getContent("jsons/conversation.json");

        JSONApiObject<Conversation> result = subject.fromJson(json);

        assertFalse(result.hasErrors());

        Conversation conversation = result.getData().get(0);
        assertEquals("4214653", conversation.getId());
        assertEquals("content", conversation.getMessage());
        assertEquals(new Date(1466014572000L), conversation.getDate());

        Person person = conversation.getPerson();
        assertEquals("451", person.getId());
        assertEquals("Gustavo Fão Valvassori", person.getName());

        Links links = result.getLinks();
        assertEquals("http://example.com/articles?page[number]=3&page[size]=1", links.getSelf());
        assertEquals("http://example.com/articles?page[number]=1&page[size]=1", links.getFirst());
        assertEquals("http://example.com/articles?page[number]=2&page[size]=1", links.getPrev());
        assertEquals("http://example.com/articles?page[number]=4&page[size]=1", links.getNext());
        assertEquals("http://example.com/articles?page[number]=13&page[size]=1", links.getLast());
    }

    @Test
    public void toJson_withResource_shouldSucceed() {
        String expectedResult = fileLoader.getContent("jsons/person.json");

        Person p = new Person();
        p.setId("id-01");
        p.setName("Gustavo");
        p.setFirstName("Gustavo");
        p.setPseudo("faogustavo");
        p.setCity("Santa Maria - RS, Brazil");
        p.setEmail("faogustavo@gmail.com");

        String result = subject.toJson(p);
        assertEquals(expectedResult, result);
    }
}