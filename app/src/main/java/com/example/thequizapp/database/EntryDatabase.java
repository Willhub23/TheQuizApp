package com.example.thequizapp.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.thequizapp.model.Entry;
// Tells room that the "Entry" class should be treated as a table in the database
@Database(entities = {Entry.class}, version = 1)
public abstract class EntryDatabase extends RoomDatabase {
    public abstract EntryDAO getEntryDAO();

}
