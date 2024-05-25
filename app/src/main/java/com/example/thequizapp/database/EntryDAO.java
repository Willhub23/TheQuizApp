package com.example.thequizapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.thequizapp.model.Entry;

import java.util.List;

@Dao
public interface EntryDAO {
    // Upsert annotation is used for inserting or updating an entry
    @Upsert
    public void insertEntry(Entry entry);

    // Delete an entry from the database
    @Delete
    public void deleteEntry(Entry entry);

    // Query to get all entries from the database
    @Query("SELECT * FROM entries")
    public List<Entry> getAllEntries();
}
