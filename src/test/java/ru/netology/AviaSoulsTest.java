package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket = new Ticket("Москва", "Владивосток", 45_000, 11, 21);
    Ticket ticket1 = new Ticket("Москва", "Сочи", 25_000, 12, 18);
    Ticket ticket2 = new Ticket("Москва", "Сочи", 5_000, 12, 15);
    Ticket ticket3 = new Ticket("Москва", "Сочи", 7_000, 16, 18);
    Ticket ticket4 = new Ticket("Москва", "Новосибирск", 35_000, 15, 22);

    @Test
    public void compareTo() {
        Ticket[] tickets = {ticket, ticket1, ticket2, ticket3, ticket4};
        Arrays.sort(tickets);


        Ticket[] expected = {ticket2, ticket3, ticket1, ticket4, ticket};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void compareToWithSearch() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void comparatorTest() {

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket, ticket1, ticket2, ticket3, ticket4};
        Arrays.sort(tickets, ticketTimeComparator);


        Ticket[] expected = {ticket3, ticket2, ticket1, ticket4, ticket};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ComparatorWithSearch() {
        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        aviaSouls.add(ticket);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] expected = {ticket3, ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);

    }

}