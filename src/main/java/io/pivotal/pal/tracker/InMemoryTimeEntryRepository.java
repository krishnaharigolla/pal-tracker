package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    /*private TimeEntryRepository timeEntryRepository;

    public InMemoryTimeEntryRepository(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }*/

    private  Long key=1L;

    Map<Long,TimeEntry> timeEntryHashMap = new HashMap<>();

    /*public InMemoryTimeEntryRepository() {

    }*/


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(key++);
        timeEntryHashMap.put(timeEntry.getId(),timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {

    return timeEntryHashMap.get(id);

    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntryHashMap.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {

        if(timeEntryHashMap.containsKey(id)){
            timeEntry.setId(id);
            timeEntryHashMap.put(timeEntry.getId(),timeEntry);
        }
        else{
            timeEntry=null;
        }
        return timeEntry ;
    }

    @Override
    public void delete(Long id) {
        timeEntryHashMap.remove(id);

    }
}
