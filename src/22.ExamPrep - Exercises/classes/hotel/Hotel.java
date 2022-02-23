package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (capacity > roster.size()) {
                this.roster.add(person);
            
        }
    }

    public boolean remove(String name) {
        int index = -1;
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
            roster.remove(index);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {

            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder(" The people in the hotel Hilton are:" + System.lineSeparator());
        for (Person person : roster) {

            builder.append(person.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }
}
