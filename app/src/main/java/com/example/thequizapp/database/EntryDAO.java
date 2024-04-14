package com.example.thequizapp.database;

import androidx.lifecycle.LiveData;

import com.example.thequizapp.model.Entry;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

@Dao
public interface EntryDAO {
    @Upsert
    public void insertEntry(Entry entry);
    @Delete
    public void deleteEntry(Entry entry);


    @Query("SELECT * FROM entries")
    public  List<Entry> getAllEntries();
}
