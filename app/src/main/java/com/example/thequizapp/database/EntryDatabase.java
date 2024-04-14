package com.example.thequizapp.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.thequizapp.model.Entry;

@Database(entities = {Entry.class}, version = 1)
public abstract class EntryDatabase extends RoomDatabase {
    public abstract EntryDAO getEntryDAO();

}
